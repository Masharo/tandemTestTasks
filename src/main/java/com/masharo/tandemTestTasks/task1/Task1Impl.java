package com.masharo.tandemTestTasks.task1;

import com.masharo.tandemTestTasks.task1.comparator.ColumnComparator;
import com.masharo.tandemTestTasks.task1.comparator.RowsComparator;
import com.masharo.tandemTestTasks.task1.exception.RowsIsNullException;

import java.util.List;
import java.util.Objects;

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

}
