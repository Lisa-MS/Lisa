package com.company.test.lab0;

import com.company.lab0.Variant17;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestVariant17 {

    @Test(dataProvider = "inputOutputProvider")
    public void testInputOutputTask(int p1, int p2, int p3, int[] p4) {
        assertEquals(new Variant17().inputOutputTask(p1, p2, p3), p4);
    }

    @DataProvider
    public Object[][] inputOutputProvider() {
        return new Object[][]{{2, 8, 16, new int[]{14, 8, 22}}, {2, 3, 5, new int[]{3, 2, 5}}};
    }

    @Test(expectedExceptions = AssertionError.class,
            dataProvider = "negativeInputOutput")
    public void negativeInputOutputTest(int p1, int p2, int p3) {
        new Variant17().inputOutputTask(p1, p2, p3);
    }

    @DataProvider
    public Object[][] negativeInputOutput() {
        return new Object[][]{{2, 2, 2}, {2, -3, 5}, {4, 5, -8}};
    }

    @Test(dataProvider = "integerNumbersTask")
    public void testIntegerNumbersTask(int n1, int n2) {

        assertEquals(new Variant17().integerNumbersTask(n1), n2);
    }

    @DataProvider
    public Object[][] integerNumbersTask() {
        return new Object[][]{{1254, 2}, {375487, 4}, {987654321, 3}};
    }

    @Test(expectedExceptions = AssertionError.class,
            dataProvider = "negativeIntegerNumbersTask")
    public void negativeIntegerNumbersTask(int n1) {
        new Variant17().integerNumbersTask(n1);
    }

    @DataProvider
    public Object[][] negativeIntegerNumbersTask() {
        return new Object[][]{{45}, {999}, {-765}};
    }

    @Test(dataProvider = "switchProvider")
    public void switchTest(int number, String word) {
        assertEquals(new Variant17().switchTask(number), word);
    }

    @DataProvider
    public Object[][] switchProvider() {
        return new Object[][]{{11, "eleven task"}, {14, "fourteen task"}, {36, "thirty six task"}, {28, "twenty eight task"}, {23, "twenty three task"}};
    }

    @Test(expectedExceptions = AssertionError.class,
            dataProvider = "switchNegativeTest")
    public void switchNegativeTest(int number) {
        new Variant17().switchTask(number);
    }

    @DataProvider
    public Object[][] switchNegativeTest() {
        return new Object[][]{{9}, {-5}, {41}};
    }

    @Test(dataProvider = "whileProvider")
    public void whileTest(int number, String result) {
        assertEquals(new Variant17().whileTask(number), result);
    }

    @DataProvider
    public Object[][] whileProvider() {
        return new Object[][]{{10, "01"}, {12, "21"}};
    }

    @Test(expectedExceptions = AssertionError.class,
            dataProvider = "negativeWhileProvider")

    public void negativeWhileProvider(int number) {
        new Variant17().whileTask(number);
    }

    @DataProvider
    public Object[][] negativeWhileProvider() {
        return new Object[][]{{0}, {-2}};
    }

    @Test(dataProvider = "matrixProvider")
    public void twoDimensionArrayTest(int[][] input, int k, int[] output) {
        assertEquals(new Variant17().twoDimensionArrayTask(input, k), output);
    }

    @DataProvider
    public Object[][] matrixProvider() {
        int[][] input = {{1, -1, 2},
                {3, 4, 7}};

        int[][] input23 = {{1, -1},
                {2, 3},
                {4, 7},
                {8, 0}};

        int[][] input14 = {{-98, 8, 1, 5, 3},
                {-4, 2, 1, 6, 1},
                {34, 98, -9, 2, 1},
                {2, 3, 6, 9, -9}};

        return new Object[][]{{input, 1, new int[]{14, 84}}, {input23, 2, new int[]{11, 28}}, {input14, 0, new int[]{-81, -11760}}};
    }


    @Test(dataProvider = "arrayProvider")
    public void arrayTest(int[] array, int[] result) {
        assertEquals(new Variant17().arrayTask(array), result);
    }

    @DataProvider
    public Object[][] arrayProvider() {
        return new Object[][]{{new int[]{2, 3, 4, 1, 7, 8}, new int[]{2, 3, 8, 7, 4, 1}}, {new int[]{1, 2, 3}, new int[]{1, 2, 3}},
                {new int[]{4, 3, 5, -4, 9, 2}, new int[]{4, 3, 2, 9, 5, -4}}};
    }


    @Test(dataProvider = "ifProvider")
    public void ifTest(int a, int b, int c, int[] expected) {
        assertEquals(new Variant17().ifTask(a,b,c), expected);
      }

        @DataProvider
       public Object[][] ifProvider() {
           return new Object[][] {2, 3, 4, new int[]{4, 6, 8}, {2, 0, 6, new int[]{4, 0, 12}}};
        }

    @Test(dataProvider = "booleanProvider")
    public void booleanTest(int a,boolean expected) {

        assertEquals(new Variant17().booleanTask(a),  expected);
    }
    @DataProvider
    public Object[][] booleanProvider() {
        return new Object[][] {{2, false}, {345, true}, {6, false}};
    }
    @Test(dataProvider = "forProvider")
    public void forTest(double a, int n, int expected) {
        assertEquals(new Variant17().forTask(a, n), expected);
    }
    @DataProvider
    public Object[][] forProvider() {

        return new Object[][] {{2, 3, 15}, {2, 2, 7}, {3, 2, 13}};
    }


}

