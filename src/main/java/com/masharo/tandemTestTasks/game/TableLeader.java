package com.masharo.tandemTestTasks.game;

import com.masharo.tandemTestTasks.game.model.User;
import com.masharo.tandemTestTasks.game.model.result.Result;
import com.masharo.tandemTestTasks.game.usecase.TopUsersUseCase;

import java.util.ArrayList;
import java.util.List;

public class TableLeader {

    private TopUsersUseCase topUsersUseCase;

    public TableLeader(TopUsersUseCase topUsersUseCase) {
        this.topUsersUseCase = topUsersUseCase;
    }

    public List<User> getTopUsers() {
        Result<List<User>> topUsers = topUsersUseCase.execute();

        return switch (topUsers) {
            case Result.Success ignored -> topUsers.getData();
            case Result.Failure ignored -> new ArrayList<>();
        };
    }

}
