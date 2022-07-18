package com.masharo.tandemTestTasks.task1;

import com.masharo.tandemTestTasks.task1.comparator.ColumnComparator;
import com.masharo.tandemTestTasks.task1.comparator.RowsComparator;
import com.masharo.tandemTestTasks.task1.exception.RowsIsNullException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <h1>Задание №1</h1>
 * Реализуйте интерфейс {@link IStringRowsListSorter}.
 *
 * <p>Мы будем обращать внимание в первую очередь на структуру кода и владение стандартными средствами java.</p>
 */
public class Task1Impl implements IStringRowsListSorter {

    // ваша реализация должна работать, как singleton. даже при использовании из нескольких потоков.
    volatile private static IStringRowsListSorter instance = null;

    public static IStringRowsListSorter getInstance() {
        if (Objects.isNull(instance)) {
            synchronized(Task1Impl.class) {
                if (Objects.isNull(instance)) {
                    instance = new Task1Impl();
                }
            }
        }

        return instance;
    }

    private Task1Impl() {}

    @Override
    public void sort(final List<String[]> rows, final int columnIndex) {

        if (Objects.isNull(rows)) {
            throw new RowsIsNullException();
        }

        rows.sort(new RowsComparator(columnIndex, new ColumnComparator()));

    }

    public static int compareStringAndInt(
            Iterator<String> iteratorLeft,
            Iterator<String> iteratorRight,
            boolean firstItemInt
    ) {
        while (iteratorLeft.hasNext() && iteratorRight.hasNext()) {
            if (firstItemInt) { //Сравниваем числа

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

            firstItemInt = !firstItemInt;//меняем способ сравнения, поскольку числа и строки чередуются
        }

        if (iteratorLeft.hasNext() || iteratorRight.hasNext()) {
            return iteratorLeft.hasNext() ? -1 : 1;
        }

        return 0;
    }

    public static int compareString(
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
