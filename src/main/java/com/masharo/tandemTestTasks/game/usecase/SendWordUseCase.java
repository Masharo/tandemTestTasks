package com.masharo.tandemTestTasks.game.usecase;

import com.masharo.tandemTestTasks.game.model.Word;

public class SendWordUseCase {

    public void execute(Word word) {

        if (!validWord(word.data())) {
            return;
        }

        int length = word.data().length() << 1;

        String startData = word.data().substring(0, length);
        String endData = word.data().substring(length);

        if (startData.equals(reverse(endData))) {

        }

    }

    private boolean validWord(String word) {
        return word.length() > 0;
    }

    private String reverse(String word) {
        return new StringBuilder(word).reverse().toString();
    }
}
