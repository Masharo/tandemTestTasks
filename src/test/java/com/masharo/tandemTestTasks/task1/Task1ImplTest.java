package com.masharo.tandemTestTasks.task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class Task1ImplTest {

    String[] row0 = {"Hallo fel poll", "8943", "fsdg iufdg u34 gr", "hallo fel poll", ""};
    String[] row1 = {"fkd jfeljg oi", "9000", "jgf n;trnjrt ", "fkd jfeljg oi", null};
    String[] row2 = {"Hallo fel poll", "100", "fsdg iufdg u34 gr", "hallo fel poll", "hallo fel poll"};
    String[] row3 = {"kph kty", "0008", "jm hort5p4g 8", "kph kty", "fkd jfeljg oi"};
    String[] row4 = {"Kph kty", "0008", "jm hort5p4g 8", "kpa kty", "123"};

    @Test
    void sortOnlyInteger() {
        List<String[]> expected = new ArrayList<>() {{
            add(row0);
            add(row1);
            add(row2);
            add(row3);
            add(row4);
        }};

        List<String[]> actual = new ArrayList<>() {{
            add(row3);
            add(row4);
            add(row2);
            add(row0);
            add(row1);
        }};

        IStringRowsListSorter task1 = Task1Impl.getInstance();
        task1.sort(expected, 1);

        Assertions.assertArrayEquals(expected.get(0), actual.get(0));
        Assertions.assertArrayEquals(expected.get(1), actual.get(1));
        Assertions.assertArrayEquals(expected.get(2), actual.get(2));
        Assertions.assertArrayEquals(expected.get(3), actual.get(3));
        Assertions.assertArrayEquals(expected.get(4), actual.get(4));
    }

    @Test
    void sortOnlyRegistrString() {
        List<String[]> expected = new ArrayList<>() {{
            add(row0);
            add(row1);
            add(row2);
            add(row3);
            add(row4);
        }};

        List<String[]> actual = new ArrayList<>() {{
            add(row0);
            add(row2);
            add(row4);
            add(row1);
            add(row3);
        }};

        IStringRowsListSorter task1 = Task1Impl.getInstance();
        task1.sort(expected, 0);

        Assertions.assertArrayEquals(expected.get(0), actual.get(0));
        Assertions.assertArrayEquals(expected.get(1), actual.get(1));
        Assertions.assertArrayEquals(expected.get(2), actual.get(2));
        Assertions.assertArrayEquals(expected.get(3), actual.get(3));
        Assertions.assertArrayEquals(expected.get(4), actual.get(4));
    }

    @Test
    void sortOnlyNoRegistrString() {
        List<String[]> expected = new ArrayList<>() {{
            add(row0);
            add(row1);
            add(row2);
            add(row3);
            add(row4);
        }};

        List<String[]> actual = new ArrayList<>() {{
            add(row1);
            add(row0);
            add(row2);
            add(row4);
            add(row3);
        }};

        IStringRowsListSorter task1 = Task1Impl.getInstance();
        task1.sort(expected, 3);

        Assertions.assertArrayEquals(expected.get(0), actual.get(0));
        Assertions.assertArrayEquals(expected.get(1), actual.get(1));
        Assertions.assertArrayEquals(expected.get(2), actual.get(2));
        Assertions.assertArrayEquals(expected.get(3), actual.get(3));
        Assertions.assertArrayEquals(expected.get(4), actual.get(4));
    }

    @Test
    void sortEmptyEndNull() {
        List<String[]> expected = new ArrayList<>() {{
            add(row0);
            add(row1);
            add(row2);
            add(row3);
            add(row4);
        }};

        List<String[]> actual = new ArrayList<>() {{
            add(row1);
            add(row0);
            add(row4);
            add(row3);
            add(row2);
        }};

        IStringRowsListSorter task1 = Task1Impl.getInstance();
        task1.sort(expected, 4);

        Assertions.assertArrayEquals(expected.get(0), actual.get(0));
        Assertions.assertArrayEquals(expected.get(1), actual.get(1));
        Assertions.assertArrayEquals(expected.get(2), actual.get(2));
        Assertions.assertArrayEquals(expected.get(3), actual.get(3));
        Assertions.assertArrayEquals(expected.get(4), actual.get(4));
    }
}