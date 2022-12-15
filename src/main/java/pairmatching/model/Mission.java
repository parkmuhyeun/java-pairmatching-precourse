package pairmatching.model;

import java.util.Arrays;

public enum Mission {
    RACING_CAR("자동차경주"),
    LOTTO("로또"),
    BASEBALL_GAME("숫자야구게임"),
    BASKET("장바구니"),
    PAY("결제"),
    SUBWAY("지하철노선도"),
    IMPROVEMENT_PERFORMANCE("성능개선"),
    RELEASE("배포");

    private String name;

    Mission(String name) {
        this.name = name;
    }

    public static boolean isMission(String input) {
        return Arrays.stream(values()).anyMatch(mission -> mission.name.equals(input));
    }

    public String getName() {
        return name;
    }
}
