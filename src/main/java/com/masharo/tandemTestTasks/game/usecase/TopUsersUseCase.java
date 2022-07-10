package com.masharo.tandemTestTasks.game.usecase;

import com.masharo.tandemTestTasks.game.model.User;
import com.masharo.tandemTestTasks.game.model.result.Result;
import com.masharo.tandemTestTasks.game.repository.PalindromeRepository;

import java.util.List;

public class TopUsersUseCase extends BaseUseCase {

    public TopUsersUseCase(PalindromeRepository repository) {
        super(repository);
    }

    public Result<List<User>> execute() {
        return repository.topUsers();
    }

}
