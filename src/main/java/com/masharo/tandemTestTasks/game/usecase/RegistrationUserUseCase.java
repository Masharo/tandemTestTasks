package com.masharo.tandemTestTasks.game.usecase;

import com.masharo.tandemTestTasks.game.model.RegistrationParam;
import com.masharo.tandemTestTasks.game.model.User;
import com.masharo.tandemTestTasks.game.model.result.Result;
import com.masharo.tandemTestTasks.game.repository.PalindromeRepository;

public class RegistrationUserUseCase extends BaseUseCase {

    public RegistrationUserUseCase(PalindromeRepository repository) {
        super(repository);
    }

    public Result<User> execute(String name) {
        return repository.registrationUser(new RegistrationParam(name));
    }

}
