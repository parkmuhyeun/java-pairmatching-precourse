package pairmatching.utils;

import pairmatching.dto.GameInfoDTO;
import pairmatching.message.ErrorMessage;
import pairmatching.model.Course;
import pairmatching.model.Level;
import pairmatching.model.Mission;

public class Validator {
    private static final String PAIR_MATCHING = "1";
    private static final String PAIR_SEARCH = "2";
    private static final String PAIR_INIT = "3";
    private static final String YES = "네";
    private static final String NO = "아니오";

    public void validateFunctionSelect(String input) {
        if (!isFunctionSelect(input)) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_FUNCTION_SELECT);
        }
    }

    private boolean isFunctionSelect(String input) {
        return input.equals(PAIR_MATCHING) || input.equals(PAIR_SEARCH) || input.equals(PAIR_INIT) | input.equals(PAIR_INIT);
    }

    public void validatePairMatching(GameInfoDTO input) {
        String course = input.getCourse();
        String level = input.getLevel();
        String mission = input.getMission();
        checkType(course, level, mission);
        checkLevelMission(level, mission);
    }

    private void checkLevelMission(String level, String mission) {
        if (level.equals(Level.LEVEL3.getName()) || level.equals(Level.LEVEL5.getName())) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_PAIR_MATCHING);
        }
        if (level.equals(Level.LEVEL1.getName()) && !isLevel1Mission(mission)) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_PAIR_MATCHING);
        }
        if (level.equals(Level.LEVEL2.getName()) && !isLevel2Mission(mission)) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_PAIR_MATCHING);
        }
        if (level.equals(Level.LEVEL4.getName()) && !isLevel4Mission(mission)) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_PAIR_MATCHING);
        }
    }

    private boolean isLevel4Mission(String mission) {
        return mission.equals(Mission.IMPROVEMENT_PERFORMANCE.getName())
                || mission.equals(Mission.RELEASE.getName());
    }

    private boolean isLevel2Mission(String mission) {
        return mission.equals(Mission.BASKET.getName())
                || mission.equals(Mission.PAY.getName())
                || mission.equals(Mission.SUBWAY.getName());
    }

    private boolean isLevel1Mission(String mission) {
        return mission.equals(Mission.RACING_CAR.getName())
                || mission.equals(Mission.LOTTO.getName())
                || mission.equals(Mission.BASEBALL_GAME.getName());
    }
    
    private void checkType(String course, String level, String mission) {
        if (!Course.isCourse(course) || !Level.isLevel(level) || !Mission.isMission(mission)) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_PAIR_MATCHING);
        }
    }

    public void validateRematching(String input) {
        if (isRematchingCommand(input)) {

        }
    }

    private boolean isRematchingCommand(String input) {
        return input.equals(YES) || input.equals(NO);
    }
}
