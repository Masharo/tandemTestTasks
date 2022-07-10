package com.masharo.tandemTestTasks.game.repository;

import com.masharo.tandemTestTasks.game.model.result.Result;
import com.masharo.tandemTestTasks.game.model.*;

import java.util.List;

/**
 * Идея в том что этот интерфейс должен лежать в платформено независимом слое
 * вместе с юзкейсами.
 */
public interface PalindromeRepository {

    Result<CountPoints> saveWord(Word word, User user);

    Result<User> authUser(AuthParam param);

    Result<User> registrationUser(RegistrationParam param);

    Result<List<User>> topUsers();

}