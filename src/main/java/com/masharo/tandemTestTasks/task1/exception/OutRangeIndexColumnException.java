package com.masharo.tandemTestTasks.task1.exception;

public class OutRangeIndexColumnException extends RuntimeException {

    public OutRangeIndexColumnException() {
        super("Index column out of range array");
    }
}
