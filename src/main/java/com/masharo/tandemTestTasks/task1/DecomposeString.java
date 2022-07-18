package com.masharo.tandemTestTasks.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.masharo.tandemTestTasks.task1.Task1Impl.compareString;
import static com.masharo.tandemTestTasks.task1.Task1Impl.compareStringAndInt;

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
            //Проверяем что 1 элемент входит в группу интов
            //чтобы в будующем не использовать parseInt или что то подбное
            //на каждой группе
            firstItemIsInt = Objects.nonNull(matcher.group(1));
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

    public Iterable<String> getSubstrings() {
        return substrings;
    }

    public boolean isFirstItemInt() {
        return firstItemInt;
    }
}
