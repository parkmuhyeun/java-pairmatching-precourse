package pairmatching.message;

public class ErrorMessage {
    private static final String HEADER = "[ERROR] ";
    public static final String INCORRECT_FUNCTION_SELECT = HEADER + "올바른 기능 선택을 입력해주세요.";
    public static final String INCORRECT_PAIR_MATCHING = HEADER + "올바른 과정, 레벨, 미션을 입력해주세요.";
    public static final String NO_MATCHING = HEADER + "더 이상 매칭이 되지 않습니다.";
    public static final String NO_SEARCH = HEADER + "매칭 이력이 없습니다.";
}
