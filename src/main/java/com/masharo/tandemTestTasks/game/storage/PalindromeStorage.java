package com.masharo.tandemTestTasks.game.storage;

import com.masharo.tandemTestTasks.game.model.AuthParam;
import com.masharo.tandemTestTasks.game.model.RegistrationParam;
import com.masharo.tandemTestTasks.game.model.User;
import com.masharo.tandemTestTasks.game.model.Word;

import java.util.List;

public interface PalindromeStorage {

    int save(Word word, User user);

    User auth(AuthParam param);

    User registration(RegistrationParam param);

    List<User> topUsers();

}
