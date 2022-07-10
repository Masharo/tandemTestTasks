package com.masharo.tandemTestTasks.game.usecase;

import com.masharo.tandemTestTasks.game.model.AuthParam;
import com.masharo.tandemTestTasks.game.model.User;
import com.masharo.tandemTestTasks.game.model.result.Result;
import com.masharo.tandemTestTasks.game.repository.PalindromeRepository;

public class AuthUserUseCase extends BaseUseCase {

    public AuthUserUseCase(PalindromeRepository repository) {
        super(repository);
    }

    public Result<User> execute(String id) {
        return repository.authUser(new AuthParam(id));
    }

}
