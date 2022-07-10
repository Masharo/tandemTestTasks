package com.masharo.tandemTestTasks.game.repository;

import com.masharo.tandemTestTasks.game.model.result.FailureParam;
import com.masharo.tandemTestTasks.game.model.result.Result;
import com.masharo.tandemTestTasks.game.model.*;
import com.masharo.tandemTestTasks.game.storage.PalindromeStorage;

import java.util.List;

public class PalindromeRepositoryImpl implements PalindromeRepository {

    private final PalindromeStorage storage;

    public PalindromeRepositoryImpl(PalindromeStorage storage) {
        this.storage = storage;
    }

    @Override
    public Result<CountPoints> saveWord(Word word, User user) {
        try {
            return new Result.Success<>(
                    new CountPoints(storage.save(word, user))
            );
        } catch (Exception ex) {
            return new Result.Failure<>(
                    new FailureParam(ex.getMessage())
            );
        }
    }

    @Override
    public Result<User> authUser(AuthParam param) {
        try {
            return new Result.Success<>(
                    storage.auth(param)
            );
        } catch (Exception ex) {
            return new Result.Failure<>(
                    new FailureParam(ex.getMessage())
            );
        }
    }

    @Override
    public Result<User> registrationUser(RegistrationParam param) {
        try {
            return new Result.Success<>(
                    storage.registration(param)
            );
        } catch (Exception ex) {
            return new Result.Failure<>(
                    new FailureParam(ex.getMessage())
            );
        }
    }

    @Override
    public Result<List<User>> topUsers() {
        try {
            return new Result.Success<>(
                    storage.topUsers()
            );
        } catch (Exception ex) {
            return new Result.Failure<>(
                    new FailureParam(ex.getMessage())
            );
        }
    }

}
