package com.masharo.tandemTestTasks.game.data;

import com.masharo.tandemTestTasks.game.model.User;
import com.masharo.tandemTestTasks.game.model.Word;
import com.masharo.tandemTestTasks.task1.Task1Impl;

import java.util.*;

public class DB {

    volatile private static DB instance = null;
    Map<User, List<Word>> db = new HashMap<>();

    public static DB getInstance() {
        if (Objects.isNull(instance)) {
            synchronized(Task1Impl.class) {
                if (Objects.isNull(instance)) {
                    instance = new DB();
                }
            }
        }

        return instance;
    }

    private DB() {}

    public List<User> getTopUsers() {
        return db.keySet().stream().sorted((prev, next) -> {
            return Integer.compare(next.getCountPoints(), prev.getCountPoints());
        }).limit(5).toList();
    }

    public User registration(String name) {
        User user = new User(name, UUID.randomUUID().toString(), 0);
        db.put(user, new ArrayList<>());
        return user;
    }

    public User auth(String id) {
        Optional<User> userOptional = db.keySet().stream().filter(it -> it.getId().equals(id)).findFirst();
        return userOptional.get();
    }

    public int save(Word word, User user) {
        List<Word> words = db.get(user);
        if (words.contains(word)) {
            return 0;
        } else {
            int points = word.data().length();
            words.add(word);
            user.addCountPoints(points);
            return word.data().length();
        }
    }

}
