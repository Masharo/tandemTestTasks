package com.masharo.tandemTestTasks.game;

import com.masharo.tandemTestTasks.game.model.User;
import com.masharo.tandemTestTasks.game.repository.PalindromeRepository;
import com.masharo.tandemTestTasks.game.repository.PalindromeRepositoryImpl;
import com.masharo.tandemTestTasks.game.storage.PalindromeStorageImpl;
import com.masharo.tandemTestTasks.game.usecase.AuthUserUseCase;
import com.masharo.tandemTestTasks.game.usecase.RegistrationUserUseCase;
import com.masharo.tandemTestTasks.game.usecase.SendWordUseCase;
import com.masharo.tandemTestTasks.game.usecase.TopUsersUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class GameTest {

    @Test
    public void testRegistration() {
        PalindromeRepository repos = new PalindromeRepositoryImpl(new PalindromeStorageImpl(DB.getInstance()));
        Game game = new Game(
                new SendWordUseCase(repos),
                new RegistrationUserUseCase(repos),
                new AuthUserUseCase(repos)
        );

        User execute = game.registration("Test Name").getData();
        String actualName = "Test Name";
        int actualPoints = 0;

        Assertions.assertEquals(execute.getName(), actualName);
        Assertions.assertEquals(execute.getCountPoints(), actualPoints);
    }

    @Test
    public void testAuth() {
        PalindromeRepository repos = new PalindromeRepositoryImpl(new PalindromeStorageImpl(DB.getInstance()));
        Game game = new Game(
                new SendWordUseCase(repos),
                new RegistrationUserUseCase(repos),
                new AuthUserUseCase(repos)
        );

        String id = game.registration("Test Name Ya").getData().getId();

        User execute = game.auth(id).getData();

        String actualName = "Test Name Ya";
        int actualPoints = 0;

        Assertions.assertEquals(execute.getName(), actualName);
        Assertions.assertEquals(execute.getCountPoints(), actualPoints);
    }

    @Test
    public void testGame() {
        PalindromeRepository repos = new PalindromeRepositoryImpl(new PalindromeStorageImpl(DB.getInstance()));
        Game game = new Game(
                new SendWordUseCase(repos),
                new RegistrationUserUseCase(repos),
                new AuthUserUseCase(repos)
        );

        String id = game.registration("Test Name Ya").getData().getId();

        User user = game.auth(id).getData();

        int executePoint = game.inputWord("топот", user);
        int actualPoint = 5;
        int actualUserPoint = game.auth(id).getData().getCountPoints();

        Assertions.assertEquals(executePoint, actualPoint);
        Assertions.assertEquals(executePoint, actualUserPoint);
    }

    @Test
    public void testGameEndTrash() {
        PalindromeRepository repos = new PalindromeRepositoryImpl(new PalindromeStorageImpl(DB.getInstance()));
        Game game = new Game(
                new SendWordUseCase(repos),
                new RegistrationUserUseCase(repos),
                new AuthUserUseCase(repos)
        );

        String id = game.registration("Test Name Ya 2").getData().getId();

        User user = game.auth(id).getData();

        int executePoint = game.inputWord("а роза упала на лапу Азора!!!", user);
        int actualPoint = 29;
        int actualUserPoint = game.auth(id).getData().getCountPoints();

        Assertions.assertEquals(executePoint, actualPoint);
        Assertions.assertEquals(executePoint, actualUserPoint);
    }

    @Test
    public void testGameNoValid() {
        PalindromeRepository repos = new PalindromeRepositoryImpl(new PalindromeStorageImpl(DB.getInstance()));
        Game game = new Game(
                new SendWordUseCase(repos),
                new RegistrationUserUseCase(repos),
                new AuthUserUseCase(repos)
        );

        String id = game.registration("Test Name Ya 3").getData().getId();

        User user = game.auth(id).getData();

        int executePoint = game.inputWord("ай роза упалиа на лапу Азора!!!", user);
        int actualPoint = 0;
        int actualUserPoint = game.auth(id).getData().getCountPoints();

        Assertions.assertEquals(executePoint, actualPoint);
        Assertions.assertEquals(executePoint, actualUserPoint);
    }

    @Test
    public void testGameDoubleData() {
        PalindromeRepository repos = new PalindromeRepositoryImpl(new PalindromeStorageImpl(DB.getInstance()));
        Game game = new Game(
                new SendWordUseCase(repos),
                new RegistrationUserUseCase(repos),
                new AuthUserUseCase(repos)
        );

        String id = game.registration("Test Name Ya 3").getData().getId();

        User user = game.auth(id).getData();

        int executePoint = game.inputWord("а роза упала на лапу Азора!!!", user);
        int actualPoint = 29;
        int actualUserPoint = game.auth(id).getData().getCountPoints();

        Assertions.assertEquals(executePoint, actualPoint);
        Assertions.assertEquals(executePoint, actualUserPoint);

        int executePoint2 = game.inputWord("а роза упала на лапу Азора!!!", user);
        int actualPoint2 = 0;
        int actualUserPoint2 = game.auth(id).getData().getCountPoints();

        Assertions.assertEquals(executePoint2, actualPoint2);
        Assertions.assertEquals(actualPoint, actualUserPoint2);
    }

    @Test
    public void testGameMoreData() {
        PalindromeRepository repos = new PalindromeRepositoryImpl(new PalindromeStorageImpl(DB.getInstance()));
        Game game = new Game(
                new SendWordUseCase(repos),
                new RegistrationUserUseCase(repos),
                new AuthUserUseCase(repos)
        );

        String id = game.registration("Test Name Ya 3").getData().getId();

        User user = game.auth(id).getData();

        int executePoint = game.inputWord("а роза упала на лапу Азора!!!", user);
        int actualPoint = 29;
        int actualUserPoint = game.auth(id).getData().getCountPoints();

        Assertions.assertEquals(executePoint, actualPoint);
        Assertions.assertEquals(executePoint, actualUserPoint);

        int executePoint2 = game.inputWord("топот", user);
        int actualPoint2 = 5;
        int actualUserPoint2 = game.auth(id).getData().getCountPoints();

        Assertions.assertEquals(executePoint2, actualPoint2);
        Assertions.assertEquals(actualPoint + actualPoint2, actualUserPoint2);
    }

    @Test
    public void testGameTopFiveUsers() {
        PalindromeRepository repos = new PalindromeRepositoryImpl(new PalindromeStorageImpl(DB.getInstance()));
        Game game = new Game(
                new SendWordUseCase(repos),
                new RegistrationUserUseCase(repos),
                new AuthUserUseCase(repos)
        );

        String id1 = game.registration("Test Name Top 1").getData().getId();
        String id2 = game.registration("Test Name Top 2").getData().getId();
        String id3 = game.registration("Test Name Top 3").getData().getId();
        String id4 = game.registration("Test Name Top 4").getData().getId();
        String id5 = game.registration("Test Name Top 5").getData().getId();
        String id6 = game.registration("Test Name Top 6").getData().getId();
        String id7 = game.registration("Test Name Top 7").getData().getId();
        String id8 = game.registration("Test Name Top 8").getData().getId();
        String id9 = game.registration("Test Name Top 9").getData().getId();

        User user1 = game.auth(id1).getData();
        User user2 = game.auth(id2).getData();
        User user3 = game.auth(id3).getData();
        User user4 = game.auth(id4).getData();
        User user5 = game.auth(id5).getData();
        User user6 = game.auth(id6).getData();
        User user7 = game.auth(id7).getData();
        User user8 = game.auth(id8).getData();
        User user9 = game.auth(id9).getData();

        game.inputWord("а роза упала на лапу Азора!!!а роза упала на лапу Азора", user1);
        game.inputWord("а роза упала на лапу Азора!!!а роза упала на лапу Азора", user2);
        game.inputWord("а роза упала на лапу Азора!!!а роза упала на лапу Азора", user3);
        game.inputWord("рот", user4);
        game.inputWord("java", user5);
        game.inputWord("qrrq", user6);
        game.inputWord("", user7);
        game.inputWord("а роза упала на лапу Азора!!!а роза упала на лапу Азораа роза упала на лапу Азора!!!а роза упала на лапу Азора", user8);
        game.inputWord("а роза упала на лапу Азора!!!а роза упала на лапу Азораа роза упала на лапу Азора!!!а роза упала на лапу Азора", user9);

        List<User> topUsers = new TableLeader(new TopUsersUseCase(repos)).getTopUsers();

        Assertions.assertTrue(topUsers.contains(user8));
        Assertions.assertTrue(topUsers.contains(user9));
        Assertions.assertTrue(topUsers.contains(user3));
        Assertions.assertTrue(topUsers.contains(user2));
        Assertions.assertTrue(topUsers.contains(user1));
    }

}