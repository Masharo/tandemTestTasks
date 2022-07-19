package com.masharo.tandemTestTasks.task1;

import com.masharo.tandemTestTasks.task1.exception.ColumnIndexLessThanZeroException;
import com.masharo.tandemTestTasks.task1.exception.OutRangeIndexColumnException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class Task1ImplTest {

    String[] row0 = {"Hallo fel poll", "8943", "fsdg iufdg u34 gr", "hallo fel poll", "", null, "", "Hallo fel po"};
    String[] row1 = {"fkd jfeljg oi", "9000", "jgf n;trnjrt ", "fkd jfeljg oi", null, null, "", "Hallo fel p"};
    String[] row2 = {"Hallo fel poll", "100", "fsdg iufdg u7 gr", "hallo fel poll", "hallo fel poll", null, "", "Hallo fel"};
    String[] row3 = {"kph kty", "0008", "jm hort5p4g 89", "kph kty", "fkd jfeljg oi", null, "", "Hallo fe"};
    String[] row4 = {"Kph kty", "0008", "jm hort5p4g 9", "kpa kty", "123", null, "", "Hallo fel pol"};

    @Test
    void sortLength() {
        List<String[]> expected = new ArrayList<>() {{
            add(row0);
            add(row1);
            add(row2);
            add(row3);
            add(row4);
        }};

        List<String[]> actual = new ArrayList<>() {{
            add(row3);
            add(row2);
            add(row1);
            add(row0);
            add(row4);
        }};

        IStringRowsListSorter task1 = Task1Impl.getInstance();
        task1.sort(expected, 7);

        Assertions.assertArrayEquals(expected.get(0), actual.get(0));
        Assertions.assertArrayEquals(expected.get(1), actual.get(1));
        Assertions.assertArrayEquals(expected.get(2), actual.get(2));
        Assertions.assertArrayEquals(expected.get(3), actual.get(3));
        Assertions.assertArrayEquals(expected.get(4), actual.get(4));
    }

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
    void sortTwoColumn() {
        List<String[]> expected = new ArrayList<>() {{
            add(row0);
            add(row1);
            add(row2);
            add(row3);
            add(row4);
        }};

        List<String[]> actual = new ArrayList<>() {{
            add(row2);
            add(row0);
            add(row1);
            add(row4);
            add(row3);
        }};

        IStringRowsListSorter task1 = Task1Impl.getInstance();
        task1.sort(expected, 2);

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

    @Test
    void sortOnlyNull() {
        List<String[]> expected = new ArrayList<>() {{
            add(row0);
            add(row1);
            add(row2);
            add(row3);
            add(row4);
        }};

        List<String[]> actual = new ArrayList<>() {{
            add(row0);
            add(row1);
            add(row2);
            add(row3);
            add(row4);
        }};

        IStringRowsListSorter task1 = Task1Impl.getInstance();
        task1.sort(expected, 5);

        Assertions.assertArrayEquals(expected.get(0), actual.get(0));
        Assertions.assertArrayEquals(expected.get(1), actual.get(1));
        Assertions.assertArrayEquals(expected.get(2), actual.get(2));
        Assertions.assertArrayEquals(expected.get(3), actual.get(3));
        Assertions.assertArrayEquals(expected.get(4), actual.get(4));
    }

    @Test
    void sortOnlyEmpty() {
        List<String[]> expected = new ArrayList<>() {{
            add(row0);
            add(row1);
            add(row2);
            add(row3);
            add(row4);
        }};

        List<String[]> actual = new ArrayList<>() {{
            add(row0);
            add(row1);
            add(row2);
            add(row3);
            add(row4);
        }};

        IStringRowsListSorter task1 = Task1Impl.getInstance();
        task1.sort(expected, 6);

        Assertions.assertArrayEquals(expected.get(0), actual.get(0));
        Assertions.assertArrayEquals(expected.get(1), actual.get(1));
        Assertions.assertArrayEquals(expected.get(2), actual.get(2));
        Assertions.assertArrayEquals(expected.get(3), actual.get(3));
        Assertions.assertArrayEquals(expected.get(4), actual.get(4));
    }

    @Test
    void sortOneItem() {
        List<String[]> expected = new ArrayList<>() {{
            add(row0);
        }};

        List<String[]> actual = new ArrayList<>() {{
            add(row0);
        }};

        IStringRowsListSorter task1 = Task1Impl.getInstance();
        task1.sort(expected, 1);

        Assertions.assertArrayEquals(expected.get(0), actual.get(0));
    }

    @Test
    void sortZeroItem() {
        List<String[]> expected = new ArrayList<>();

        try {
            IStringRowsListSorter task1 = Task1Impl.getInstance();
            task1.sort(expected, 1);
            Assertions.assertTrue(expected.isEmpty());
        } catch (Exception ignored) {
            Assertions.fail();
        }

    }

    @Test
    void sortExceptionLessColumn() {
        List<String[]> expected = new ArrayList<>() {{
            add(row0);
        }};

        try {
            Task1Impl.getInstance().sort(expected, -1);
            Assertions.fail();
        } catch (ColumnIndexLessThanZeroException ignored) {
            //Успех
        } catch (Exception ex) {
            Assertions.fail();
        }
    }

    @Test
    void sortExceptionOutOfRangeColumnIndex() {
        List<String[]> expected = new ArrayList<>() {{
            add(row0);
            add(new String[]{"", ""});
        }};

        try {
            Task1Impl.getInstance().sort(expected, 2);
            Assertions.fail();
        } catch (OutRangeIndexColumnException ignored) {
            //Успех
        } catch (Exception ex) {
            Assertions.fail();
        }
    }
}