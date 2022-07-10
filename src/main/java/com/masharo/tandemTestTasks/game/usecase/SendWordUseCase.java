package com.masharo.tandemTestTasks.game.usecase;

import com.masharo.tandemTestTasks.game.model.CountPoints;
import com.masharo.tandemTestTasks.game.model.User;
import com.masharo.tandemTestTasks.game.model.Word;
import com.masharo.tandemTestTasks.game.model.result.FailureParam;
import com.masharo.tandemTestTasks.game.model.result.Result;
import com.masharo.tandemTestTasks.game.repository.PalindromeRepository;

public class SendWordUseCase extends BaseUseCase {

    public SendWordUseCase(PalindromeRepository repository) {
        super(repository);
    }

    public Result<CountPoints> execute(Word word, User user) {

        if (!validWord(word.data())) {
            return new Result.Failure<>(new FailureParam("Передана пустая строка"));
        }

        String localWord = word.data()
                .replaceAll("[^\\p{L}\\p{N}]+", "")
                .toLowerCase();
        int length = localWord.length() >> 1;

        String startData = localWord.substring(0, length);
        String endData = localWord.substring(localWord.length() - length);

        if (startData.equals(reverse(endData))) {
            return repository.saveWord(word, user);
        }

        return new Result.Failure<>(new FailureParam("Переданное Слово не является палиндромом"));

    }

    private boolean validWord(String word) {
        return word.length() > 0;
    }

    private String reverse(String word) {
        return new StringBuilder(word).reverse().toString();
    }
}
