package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.message.NoticeMessage;

public class InputView {

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
}
