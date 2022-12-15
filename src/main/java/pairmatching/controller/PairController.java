package pairmatching.controller;

import pairmatching.view.InputView;

public class PairController {
    private final InputView inputView;

    public PairController() {
        inputView = new InputView();
    }

    public void run() {
        String input = inputView.inputSelect();

    }
}
