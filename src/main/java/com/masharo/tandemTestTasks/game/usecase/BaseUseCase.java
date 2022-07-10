package com.masharo.tandemTestTasks.game.usecase;

import com.masharo.tandemTestTasks.game.repository.PalindromeRepository;

abstract class BaseUseCase {

    protected PalindromeRepository repository;

    public BaseUseCase(PalindromeRepository repository) {
        this.repository = repository;
    }
}
