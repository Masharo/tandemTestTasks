package com.masharo.tandemTestTasks.game;

import com.masharo.tandemTestTasks.game.model.User;
import com.masharo.tandemTestTasks.game.data.DB;
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

class TableLeaderTest {

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