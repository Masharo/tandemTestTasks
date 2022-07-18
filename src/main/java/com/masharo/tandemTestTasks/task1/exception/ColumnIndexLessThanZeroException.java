package com.masharo.tandemTestTasks.task1.exception;

public class ColumnIndexLessThanZeroException extends RuntimeException {

    public ColumnIndexLessThanZeroException() {
        super("Column index less than zero");
    }
}
