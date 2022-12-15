package pairmatching.utils;

import pairmatching.message.ErrorMessage;
import pairmatching.model.Course;
import pairmatching.model.Level;
import pairmatching.model.Mission;

public class Validator {
    private static final String PAIR_MATCHING = "1";
    private static final String PAIR_SEARCH = "2";
    private static final String PAIR_INIT = "3";
    private static final String QUIT = "Q";
    private static final String DELIMITER = ", ";

    public void validateFunctionSelect(String input) {
        if (!isFunctionSelect(input)) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_FUNCTION_SELECT);
        }
    }

    private boolean isFunctionSelect(String input) {
        return input.equals(PAIR_MATCHING) || input.equals(PAIR_SEARCH) || input.equals(PAIR_INIT) | input.equals(PAIR_INIT);
    }

    public void validatePairMatching(String input) {
        String[] splitInput = input.split(DELIMITER);
        String course = splitInput[0];
        String level = splitInput[1];
        String mission = splitInput[2];
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
}
