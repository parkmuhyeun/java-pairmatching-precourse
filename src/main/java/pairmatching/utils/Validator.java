package pairmatching.utils;

import pairmatching.message.ErrorMessage;

public class Validator {

    public void validateFunctionSelect(String input) {
        if (!isFunctionSelect(input)) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_FUNCTION_SELECT);
        }
    }

    private boolean isFunctionSelect(String input) {
        return input.equals("1") || input.equals("2") || input.equals("3") | input.equals("Q");
    }
}
