package com.masharo.tandemTestTasks.task1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DecomposeString implements Comparable<DecomposeString> {

    private final Iterable<String> substrings;
    private final boolean firstItemInt;// чтобы каждый раз не проверять являются ли 2 подстроки числами

    public DecomposeString(Iterable<String> substrings, boolean firstItemIsInt) {
        this.substrings = substrings;
        this.firstItemInt = firstItemIsInt;
    }

    public static DecomposeString parseStringToDecomposeString(String value) {

        boolean firstItemIsInt = false;

        final Pattern pattern = Pattern.compile("(\\d*\\d)|(\\D*\\D)");
        final Matcher matcher = pattern.matcher(value);

        final List<String> result = new ArrayList<>();

        if (matcher.find()) {
            result.add(matcher.group(0));
            firstItemIsInt = Objects.nonNull(matcher.group(1)); //Проверяем что 1 элемент входит в группу интов
        }

        while (matcher.find()) {
            result.add(matcher.group(0));
        }

        return new DecomposeString(result, firstItemIsInt);
    }

    @Override
    public int compareTo(DecomposeString o) {
        //Проверяем соответствуют ли инты и стринги двух объектов
        if (firstItemInt == o.isFirstItemInt()) {
            return compareStringAndInt(
                    substrings.iterator(),
                    o.getSubstrings().iterator(),
                    firstItemInt
            );
        } else {
            return compareString(
                    substrings.iterator(),
                    o.getSubstrings().iterator()
            );
        }
    }

    private int compareStringAndInt(
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

            firstItemInt = !firstItemInt;//меняем способ сравнения, поскольку числа и строки чередуются по заданию
        }

        return 0; // получается равны хотя быть такого не может
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

        return 0;
    }

    public Iterable<String> getSubstrings() {
        return substrings;
    }

    public boolean isFirstItemInt() {
        return firstItemInt;
    }
}
