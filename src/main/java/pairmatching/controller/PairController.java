package pairmatching.controller;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.dto.GameInfoDTO;
import pairmatching.dto.MatchingResultDTO;
import pairmatching.message.ErrorMessage;
import pairmatching.model.*;
import pairmatching.utils.FileReader;
import pairmatching.utils.Validator;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static pairmatching.model.Course.toCourse;
import static pairmatching.model.Level.toLevel;
import static pairmatching.model.Mission.toMission;

public class PairController {
    private static final String PAIR_MATCHING = "1";
    private static final String YES = "네";
    private static final String BACKEND_FILE = "backend-crew.md";
    private static final String FRONTEND_FILE = "frontend-crew.md";

    private final InputView inputView;
    private final Validator validator;
    private final CrewRepository crewRepository;
    private final FileReader fileReader;
    private final GameRepository gameRepository;
    private final OutputView outputView;

    public PairController() {
        inputView = new InputView();
        validator = new Validator();
        crewRepository = new CrewRepository();
        fileReader = new FileReader();
        gameRepository = new GameRepository();
        outputView = new OutputView();
    }

    public void run() {
        saveCrew();
        while (true) {
            String select = inputFunctionSelect();
            if (select.equals(PAIR_MATCHING)) {
                Game game = matchPair();
                Pair pair = game.getPair();
                outputView.outputMatchingResult(new MatchingResultDTO(pair.getCrew(), pair.getPartner()));
            }
        }
    }

    private void saveCrew() {
        List<String> backendCrew = fileReader.read(BACKEND_FILE);
        List<String> frontendCrew = fileReader.read(FRONTEND_FILE);
        for (int index = 0; index < backendCrew.size(); index++) {
            crewRepository.save(new Crew(Course.BACKEND, backendCrew.get(index), new HashMap<>()));
        }
        for (int index = 0; index < frontendCrew.size(); index++) {
            crewRepository.save(new Crew(Course.FRONTEND, frontendCrew.get(index), new HashMap<>()));
        }
    }

    private Game matchPair() {
        GameInfoDTO gameInfoDTO = getGameInfoDTO();
        List<String> crews = crewRepository.getCrewsNameByCourse(Course.toCourse(gameInfoDTO.getCourse()));
        List<String> shuffleCrews = Randoms.shuffle(crews);
        int count = 0;
        while (true) {
            Pair pair = match(gameInfoDTO, shuffleCrews);
            if (pair.getSize() == shuffleCrews.size() / 2) {
                return gameRepository.saveGame(getGame(gameInfoDTO, pair));
            }
            count++;
            validateMatch(count);
        }
    }

    private GameInfoDTO getGameInfoDTO() {
        GameInfoDTO gameInfoDTO;
        while (true) {
            gameInfoDTO = inputPairMatching();
            if (needMatch(gameInfoDTO)) {
                break;
            }
        }
        return gameInfoDTO;
    }

    private boolean needMatch(GameInfoDTO gameInfoDTO) {
        return !gameRepository.hasGame(gameInfoDTO) || (gameRepository.hasGame(gameInfoDTO) && inputRematching().equals(YES));
    }

    private String inputRematching() {
        try {
            String input = inputView.inputRematching();
            validator.validateRematching(input);
            return input;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return inputRematching();
        }
    }

    private void validateMatch(int count) {
        if (count == 3) {
            throw new IllegalArgumentException(ErrorMessage.NO_MATCHING);
        }
    }

    private Pair match(GameInfoDTO gameInfoDTO, List<String> shuffleCrews) {
        Pair pair = new Pair(new ArrayList<>(), new ArrayList<>());
        for (int index = 0; index < shuffleCrews.size(); index += 2) {
            if (index == shuffleCrews.size() - 1) {
                break;
            }
            Crew crew = crewRepository.getCrewByName(shuffleCrews.get(index));
            Crew partner = crewRepository.getCrewByName(shuffleCrews.get(index + 1));
            if (crew.checkPair(gameInfoDTO.getLevel(), partner.getName())) {
                break;
            }

            //TODO 분리
            //페어 추가
            List<String> partnersName = new ArrayList<>();
            partnersName.add(partner.getName());
            if (index + 3 == shuffleCrews.size()) {
                partnersName.add(shuffleCrews.get(index + 2));
            }
            pair.addPair(crew.getName(), partnersName);
            
            // 제외 추가
            crew.addExclusion(gameInfoDTO.getLevel(), partner.getName());
            partner.addExclusion(gameInfoDTO.getLevel(), crew.getName());
            if (index + 3 == shuffleCrews.size()) {
                crew.addExclusion(gameInfoDTO.getLevel(), shuffleCrews.get(index + 2));
                partner.addExclusion(gameInfoDTO.getLevel(), shuffleCrews.get(index + 2));
                Crew lastCrew = crewRepository.getCrewByName(shuffleCrews.get(index + 2));
                lastCrew.addExclusion(gameInfoDTO.getLevel(), shuffleCrews.get(index));
                lastCrew.addExclusion(gameInfoDTO.getLevel(), shuffleCrews.get(index + 1));
            }
        }
        return pair;
    }

    private Game getGame(GameInfoDTO gameInfoDTO, Pair pair) {
        return new Game(toCourse(gameInfoDTO.getCourse()),
                toLevel(gameInfoDTO.getLevel()),
                toMission(gameInfoDTO.getMission()),
                pair);
    }

    private GameInfoDTO inputPairMatching() {
        try {
            GameInfoDTO input = inputView.inputPairMatching();
            validator.validatePairMatching(input);
            return input;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return inputPairMatching();
        }
    }

    private String inputFunctionSelect() {
        try {
            String input = inputView.inputFunctionSelect();
            validator.validateFunctionSelect(input);
            return input;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return inputFunctionSelect();
        }
    }
}
