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

    public String inputPairMatching() {
        System.out.println(NoticeMessage.INPUT_PAIR_MATCHING);
        String input = Console.readLine();
        System.out.println();
        return input;
    }

    public String inputRematching() {
        System.out.println(NoticeMessage.INPUT_REMATCHING);
        String input = Console.readLine();
        System.out.println();
        return input;
    }
}
