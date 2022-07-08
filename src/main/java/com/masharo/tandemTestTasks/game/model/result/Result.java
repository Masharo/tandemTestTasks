package com.masharo.tandemTestTasks.game.model.result;

import static com.masharo.tandemTestTasks.game.model.result.Result.*;

public sealed interface Result<T> permits Success, Failure, Processing {

    record Success<T>(SuccessParam param, T data) implements Result<T> {}

    record Failure<T>(FailureParam param) implements Result<T> {}

    record Processing<T>() implements Result<T> {}

}