package com.masharo.tandemTestTasks.game;

import com.masharo.tandemTestTasks.game.model.User;
import com.masharo.tandemTestTasks.game.data.DB;
import com.masharo.tandemTestTasks.game.repository.PalindromeRepository;
import com.masharo.tandemTestTasks.game.repository.PalindromeRepositoryImpl;
import com.masharo.tandemTestTasks.game.storage.PalindromeStorageImpl;
import com.masharo.tandemTestTasks.game.usecase.AuthUserUseCase;
import com.masharo.tandemTestTasks.game.usecase.RegistrationUserUseCase;
import com.masharo.tandemTestTasks.game.usecase.SendWordUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

}