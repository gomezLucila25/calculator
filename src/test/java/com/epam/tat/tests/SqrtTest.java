package com.epam.tat.tests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

@Test(groups = "advanced")
public class SqrtTest {
    private static final double DELTA = 1e-9;
    private Calculator calculator;

    @BeforeMethod
    public void setUp() { calculator = new Calculator(); }

    @AfterMethod
    public void tearDown() { calculator = null; }

    @DataProvider(name = "sqrtData", parallel = true)
    public Object[][] provideData() {
        return new Object[][] {
            {  4.0, 2.0 },
            {  9.0, 3.0 },
            { 16.0, 4.0 },
            {  0.0, 0.0 },
            {  1.0, 1.0 },
            { 0.25, 0.5 },
        };
    }

    @Test(dataProvider = "sqrtData")
    public void testSqrt_parameterized(double input, double expected) {
        Assert.assertEquals(calculator.sqrt(input), expected, DELTA);
    }

    @Test
    public void testSqrt_negativeIsNaN() {
        Assert.assertTrue(Double.isNaN(calculator.sqrt(-1.0)));
    }
}
