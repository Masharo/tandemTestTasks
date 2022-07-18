package com.masharo.tandemTestTasks.task1;

import java.util.ArrayList;
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
        final List<Decompose> listSort = new ArrayList<>();
        final List<String[]> indexEmpty = new ArrayList<>();
        final List<String[]> indexNull = new ArrayList<>();

        for (String[] row : rows) {
            String item = row[columnIndex];

            if (Objects.isNull(item)) {
                indexNull.add(row);
            } else if (item.isEmpty()) {
                indexEmpty.add(row);
            } else {
                listSort.add(stringDecompose(row, columnIndex));
            }
        }

        sortValidItems(listSort);

        for (int i = 0; i < indexNull.size(); i++) {
            rows.set(i, indexNull.get(i));
        }

        for (int i = 0; i < indexEmpty.size(); i++) {
            rows.set(i + indexNull.size(), indexEmpty.get(i));
        }

        int startIndex = indexEmpty.size() + indexNull.size();
        for (int i = 0; i < listSort.size(); i++) {
            rows.set(i + startIndex, listSort.get(i).row);
        }

    }

    /**
     * Сортировка значений, без null и empty.
      * @param listSort
     */
    private void sortValidItems(List<Decompose> listSort) {
        listSort.sort((dLeft, dRight) -> {
            if (dLeft.firstItemIsInt == dRight.firstItemIsInt) { // Совпадают ли позиции интов и строк в срапвниваемых объектах
                for (int i = 0; i < dLeft.substrings.length; i++) {
                    if ((i % 2 == 0) == dLeft.firstItemIsInt) { // Обрабатываем как Int
                        int dLeftInt = Integer.parseInt(dLeft.substrings[i]);
                        int dRightInt = Integer.parseInt(dRight.substrings[i]);

                        if (dLeftInt != dRightInt) {
                            return Integer.compare(dLeftInt, dRightInt);
                        }
                    } else {
                        int compareString = dLeft.substrings[i].compareTo(dRight.substrings[i]);
                        if (compareString != 0) {
                            return compareString;
                        }
                    }
                }
            } else {

                for (int i = 0; i < dLeft.substrings.length; i++) {
                    int compareString = dLeft.substrings[i].compareTo(dRight.substrings[i]);
                    if (compareString != 0) {
                        return compareString;
                    }
                }
            }

            return 0;
        });
    }

    /**
     * @param substrings битая строка
     * @param firstItemIsInt является ли 1 элемент числом
     * @param row исходная строка
     */
    private record Decompose(String[] substrings, boolean firstItemIsInt, String[] row) {}

    /**
     * Разбиваем строку на подстроки, и определяем является ли 1 подстрока
     * числом.
     * @param strings
     * @param index
     * @return Decompose
     */
    private Decompose stringDecompose(String[] strings, int index) { // делаем из строки массив

        boolean firstItemIsInt = false;
        final String str = strings[index];

        final Pattern pattern = Pattern.compile("(\\d*\\d)|(\\D*\\D)");
        final Matcher matcher = pattern.matcher(str);

        final List<String> result = new ArrayList<>();

        if (matcher.find()) {
            result.add(matcher.group(0));
            if (Objects.nonNull(matcher.group(1))) {
                firstItemIsInt = true;
            }
        }

        while (matcher.find()) {
            result.add(matcher.group(0));
        }

        return new Decompose(result.toArray(new String[0]), firstItemIsInt, strings);
    }
}
