package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.message.NoticeMessage;

public class InputView {

    public String inputFunctionSelect() {
        System.out.println(NoticeMessage.INPUT_FUNCTION_SELECT);
        return Console.readLine();
    }

    public String inputPairMatching() {
        System.out.println(NoticeMessage.INPUT_PAIR_MATCHING);
        return Console.readLine();
    }
}
