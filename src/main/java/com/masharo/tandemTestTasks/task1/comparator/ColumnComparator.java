package com.masharo.tandemTestTasks.task1.comparator;

import com.masharo.tandemTestTasks.task1.DecomposeString;

import java.util.Comparator;
import java.util.Objects;

public class ColumnComparator implements Comparator<String> {

    @Override
    public int compare(String stringLeft, String stringRight) {

        final boolean stringLeftIsNull = Objects.isNull(stringLeft);
        final boolean stringRightIsNull = Objects.isNull(stringRight);

        if (stringLeftIsNull && stringRightIsNull) return 0;
        if (stringLeftIsNull) return -1;
        if (stringRightIsNull) return 1;

        if (stringLeft.equals(stringRight)) return 0;
        if (stringLeft.length() == 0) return -1;
        if (stringRight.length() == 0) return 1;

        return DecomposeString.parseStringToDecomposeString(stringLeft)
               .compareTo(
               DecomposeString.parseStringToDecomposeString(stringRight));
    }

}
