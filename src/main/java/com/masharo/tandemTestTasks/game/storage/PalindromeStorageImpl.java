package com.masharo.tandemTestTasks.game.storage;

import com.masharo.tandemTestTasks.game.data.DB;
import com.masharo.tandemTestTasks.game.model.AuthParam;
import com.masharo.tandemTestTasks.game.model.RegistrationParam;
import com.masharo.tandemTestTasks.game.model.User;
import com.masharo.tandemTestTasks.game.model.Word;

import java.util.List;

public class PalindromeStorageImpl implements PalindromeStorage{

    private DB db;

    public PalindromeStorageImpl(DB db) {
        this.db = db;
    }

    @Override
    public int save(Word word, User user) {
        return db.save(word, user);
    }

    @Override
    public User auth(AuthParam param) {
        return db.auth(param.id());
    }

    @Override
    public User registration(RegistrationParam param) {
        return db.registration(param.name());
    }

    @Override
    public List<User> topUsers() {
        return db.getTopUsers();
    }

}
