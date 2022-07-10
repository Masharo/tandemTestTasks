package com.masharo.tandemTestTasks.game.model.result;

import static com.masharo.tandemTestTasks.game.model.result.Result.*;

public sealed interface Result<T> permits Success, Failure {

    T getData();

    record Success<T>(T data) implements Result<T> {
        @Override
        public T getData() {
            return data;
        }
    }

    record Failure<T>(FailureParam param) implements Result<T> {
        @Override
        public T getData() {
            return null;
        }
    }

}