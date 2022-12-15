package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.dto.GameInfoDTO;
import pairmatching.message.NoticeMessage;

public class InputView {
    private static final String DELIMITER = ", ";

    public String inputFunctionSelect() {
        System.out.println(NoticeMessage.INPUT_FUNCTION_SELECT);
        String input = Console.readLine();
        System.out.println();
        return input;
    }

    public GameInfoDTO inputPairMatching() {
        System.out.println(NoticeMessage.INPUT_PAIR_MATCHING);
        String input = Console.readLine();
        String[] splitInput = input.split(DELIMITER);
        String course = splitInput[0];
        String level = splitInput[1];
        String mission = splitInput[2];
        System.out.println();
        return new GameInfoDTO(course, level, mission);
    }
}
