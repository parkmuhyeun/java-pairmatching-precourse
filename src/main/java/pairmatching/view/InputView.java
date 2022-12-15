package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import message.NoticeMessage;

public class InputView {

    public String inputSelect() {
        System.out.println(NoticeMessage.INPUT_SELECT);
        return Console.readLine();
    }
}
