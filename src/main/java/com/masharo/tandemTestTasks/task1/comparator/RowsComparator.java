package com.masharo.tandemTestTasks.task1.comparator;

import com.masharo.tandemTestTasks.task1.exception.ColumnIndexLessThanZeroException;
import com.masharo.tandemTestTasks.task1.exception.OutRangeIndexColumnException;

import java.util.Comparator;

public class RowsComparator implements Comparator<String[]> {

    private final int indexColumn;
    private final Comparator<String> stringComparator;

    public RowsComparator(int indexColumn, Comparator<String> stringComparator) {

        if (indexColumn < 0) {
            throw new ColumnIndexLessThanZeroException();
        }

        this.indexColumn = indexColumn;
        this.stringComparator = stringComparator;
    }

    @Override
    public int compare(String[] rowLeft, String[] rowRight) {

        if (rowLeft.length <= indexColumn ||
            rowRight.length <= indexColumn
        ) {
            throw new OutRangeIndexColumnException();
        }

        return stringComparator.compare(
                rowLeft[indexColumn],
                rowRight[indexColumn]
        );
    }

}
