package com.masharo.tandemTestTasks.game.repository;

import com.masharo.tandemTestTasks.game.model.result.Result;
import com.masharo.tandemTestTasks.game.model.*;

import java.util.List;

/**
 * В реализации мы можем передать не только сторедж, например сервис.
 */

public interface PalindromeRepository {

    Result<CountPoints> saveWord(Word word, User user);

    Result<User> authUser(AuthParam param);

    Result<User> registrationUser(RegistrationParam param);

    Result<List<User>> topUsers();

}