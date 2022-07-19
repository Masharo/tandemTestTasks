package com.masharo.tandemTestTasks.task1.comparator;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <ul>
 *  <li>{@link ColumnComparator#decomposeString(String)} - бьет строку на подстроки</li>
 *  <li>{@link ColumnComparator#firstItemIsInt(List)} - возвращает boolean в зависимости от того является ли первая подстрока числом или нет</li>
 *  <li>{@link ColumnComparator#compare(String, String)} - сравнивает значения одной колонки из разных записей</li>
 *  <li>{@link ColumnComparator#compareStringAndInt(Iterator, Iterator, boolean)} - обходит списки и сравнивает строки либо как строки, либо как инт в зависимости от параметра firstItemIsInt</li>
 *  <li>{@link ColumnComparator#compareString(Iterator, Iterator)} - обходит списки и сравнивает строки</li>
 * </ul>
 */

public class ColumnComparator implements Comparator<String> {

    @Override
    public int compare(String stringLeft, String stringRight) {

        final boolean stringLeftIsNull = Objects.isNull(stringLeft);
        final boolean stringRightIsNull = Objects.isNull(stringRight);

        if (stringLeftIsNull || stringRightIsNull) {
            if (stringLeftIsNull && stringRightIsNull) return 0;
            if (stringLeftIsNull) return -1;
            return 1;
        }

        if (stringLeft.equals(stringRight)) return 0; // если равны то и бить на подсторки смысла нет
        if (stringLeft.length() == 0) return -1;
        if (stringRight.length() == 0) return 1;

        List<String> listLeft = decomposeString(stringLeft);
        List<String> listRight = decomposeString(stringRight);

        boolean leftFirstItemIsInt = firstItemIsInt(listLeft);

        if (leftFirstItemIsInt == firstItemIsInt(listRight)) {
            return compareStringAndInt(
                    listLeft.iterator(),
                    listRight.iterator(),
                    leftFirstItemIsInt
            );
        } else {
            return compareString(
                    listLeft.iterator(),
                    listRight.iterator()
            );
        }
    }

    private boolean firstItemIsInt(List<String> list) {

        try {
            Integer.parseInt(list.get(0));
            return true;
        } catch (NumberFormatException ignored) {
            return false;
        }

    }

    private List<String> decomposeString(String value) {

        final Pattern pattern = Pattern.compile("(\\d*\\d)|(\\D*\\D)");
        final Matcher matcher = pattern.matcher(value);

        final List<String> result = new ArrayList<>();

        while (matcher.find()) {
            result.add(matcher.group(0));
        }

        return result;
    }

    private int compareStringAndInt(
            Iterator<String> iteratorLeft,
            Iterator<String> iteratorRight,
            boolean firstItemIsInt
    ) {
        while (iteratorLeft.hasNext() && iteratorRight.hasNext()) {
            if (firstItemIsInt) { //Сравниваем числа

                int resultCompareInt = Integer.compare(
                        Integer.parseInt(iteratorLeft.next()),
                        Integer.parseInt(iteratorRight.next())
                );

                if (resultCompareInt != 0) {
                    return resultCompareInt;
                }
            } else { //Сравниваем строки
                int resultCompareString = iteratorLeft.next().compareTo(iteratorRight.next());
                if (resultCompareString != 0) {
                    return resultCompareString;
                }
            }

            firstItemIsInt = !firstItemIsInt;//меняем способ сравнения, поскольку числа и строки чередуются
        }

        if (iteratorLeft.hasNext() || iteratorRight.hasNext()) {
            return iteratorLeft.hasNext() ? -1 : 1;
        }

        return 0;
    }

    private int compareString(
            Iterator<String> iteratorLeft,
            Iterator<String> iteratorRight
    ) {
        while (iteratorLeft.hasNext() && iteratorRight.hasNext()) {
            int resultCompareString = iteratorLeft.next().compareTo(iteratorRight.next());
            if (resultCompareString != 0) {
                return resultCompareString;
            }
        }

        if (iteratorLeft.hasNext() || iteratorRight.hasNext()) {
            return iteratorLeft.hasNext() ? -1 : 1;
        }

        return 0;
    }

}
