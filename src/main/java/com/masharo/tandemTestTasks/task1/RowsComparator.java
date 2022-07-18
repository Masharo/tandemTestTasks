package com.masharo.tandemTestTasks.task1;

import java.util.Comparator;

public class RowsComparator implements Comparator<String[]> {

    private final int indexColumn;
    private final Comparator<String> stringComparator;

    public RowsComparator(int indexColumn, Comparator<String> stringComparator) {
        this.indexColumn = indexColumn;
        this.stringComparator = stringComparator;
    }

    @Override
    public int compare(String[] rowLeft, String[] rowRight) {

        if (rowLeft.length <= indexColumn || rowRight.length <= indexColumn) {
//            throw new Exception("index column out of range array"); exception
        }

        return stringComparator.compare(
                rowLeft[indexColumn],
                rowRight[indexColumn]
        );
    }

}
