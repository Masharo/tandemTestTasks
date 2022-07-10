package com.masharo.tandemTestTasks.game.model;

public class User {

    final String name;
    final String id;
    int countPoints;

    public User(String name, String id, int countPoints) {
        this.name = name;
        this.id = id;
        this.countPoints = countPoints;
    }

    public void addCountPoints(int countPoints) {
        this.countPoints += countPoints;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getCountPoints() {
        return countPoints;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof User user)) return false;

        return id.equals(user.id);
    }
}
