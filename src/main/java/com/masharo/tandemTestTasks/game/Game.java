package com.masharo.tandemTestTasks.game;

import com.masharo.tandemTestTasks.game.model.CountPoints;
import com.masharo.tandemTestTasks.game.model.User;
import com.masharo.tandemTestTasks.game.model.Word;
import com.masharo.tandemTestTasks.game.model.result.Result;
import com.masharo.tandemTestTasks.game.usecase.AuthUserUseCase;
import com.masharo.tandemTestTasks.game.usecase.RegistrationUserUseCase;
import com.masharo.tandemTestTasks.game.usecase.SendWordUseCase;

public class Game {

    private SendWordUseCase sendWordUseCase;
    private RegistrationUserUseCase registrationUserUseCase;
    private AuthUserUseCase authUserUseCase;

    Game(SendWordUseCase sendWordUseCase,
         RegistrationUserUseCase registrationUserUseCase,
         AuthUserUseCase authUserUseCase
    ) {
        this.sendWordUseCase = sendWordUseCase;
        this.registrationUserUseCase = registrationUserUseCase;
        this.authUserUseCase = authUserUseCase;
    }

    public int inputWord(String word, User user) {
        Result<CountPoints> points = sendWordUseCase.execute(new Word(word), user);

        return switch (points) {
            case Result.Success ignored -> points.getData().count();
            case Result.Failure ignored -> 0;
        };
    }

    public Result<User> auth(String id) {
        return authUserUseCase.execute(id);
    }
 
    public Result<User> registration(String name) {
        return registrationUserUseCase.execute(name);
    }
}
