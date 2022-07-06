package com.masharo.tandemTestTasks.task1;

import java.util.ArrayList;
import java.util.Arrays;
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
    public static final IStringRowsListSorter INSTANCE = new Task1Impl();

    @Override
    public void sort(final List<String[]> rows, final int columnIndex) {
        int[] indexSorted = new int[rows.size()];
    }


    public static void main(String[] args) {

        Task1Impl imp = new Task1Impl();
        System.out.println(imp.stringDecompose("l123lfd gt 54 hgh gh 6"));
    }

    private record Decompose(String[] substrings, boolean firstItemIsInt) {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Decompose decompose = (Decompose) o;

            return Arrays.equals(substrings, decompose.substrings);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(substrings);
        }
    }

    private Decompose stringDecompose(String str) {//делаем из строки массив

        boolean firstItemIsInt = false;

        Pattern pattern = Pattern.compile("(\\d*\\d)|(\\D*\\D)");
        Matcher matcher = pattern.matcher(str);

        List<String> result = new ArrayList<>();

        if (matcher.find()) {
            result.add(matcher.group(0));
            if (Objects.nonNull(matcher.group(1))) {
                firstItemIsInt = true;
            }
        }

        while (matcher.find()) {
            result.add(matcher.group(0));
        }

        return new Decompose(result.toArray(new String[0]), firstItemIsInt);
    }
}
