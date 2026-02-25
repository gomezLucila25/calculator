package com.epam.tat.tests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

@Test(groups = "arithmetic")
public class SumDoubleTest {
    private static final double DELTA = 1e-9;
    private Calculator calculator;

    @BeforeClass
    public void setUp() { calculator = new Calculator(); }

    @AfterClass
    public void tearDown() { calculator = null; }

    @DataProvider(name = "sumDoubleData", parallel = true)
    public Object[][] provideData() {
        return new Object[][] {
            {  1.5,  2.5,  4.0 },
            { -1.5, -2.5, -4.0 },
            {  0.0,  0.0,  0.0 },
            {  3.14, 2.86, 6.0 },
        };
    }

    @Test(dataProvider = "sumDoubleData")
    public void testSumDouble_parameterized(double a, double b, double expected) {
        Assert.assertEquals(calculator.sum(a, b), expected, DELTA);
    }

    @Test
    public void testSumDouble_negativeResult() {
        Assert.assertEquals(calculator.sum(-10.5, 3.5), -7.0, DELTA);
    }
}
