package pairmatching.controller;

import pairmatching.utils.Validator;
import pairmatching.view.InputView;

public class PairController {
    private final InputView inputView;
    private final Validator validator;

    public PairController() {
        inputView = new InputView();
        validator = new Validator();
    }

    public void run() {
        inputFunctionSelect();

    }

    private String inputFunctionSelect() {
        try {
            String input = inputView.inputFunctionSelect();
            validator.validateFunctionSelect(input);
            return input;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return inputFunctionSelect();
        }
    }
}
