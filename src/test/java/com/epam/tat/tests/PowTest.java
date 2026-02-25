package com.epam.tat.tests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

@Test(groups = "advanced")
public class PowTest {
    private static final double DELTA = 1e-9;
    private Calculator calculator;

    @BeforeClass
    public void setUp() {
        calculator = new Calculator();
        System.out.println("[SETUP] PowTest ready");
    }

    @AfterClass
    public void tearDown() {
        calculator = null;
        System.out.println("[TEARDOWN] PowTest cleaned up");
    }

    @DataProvider(name = "powData", parallel = true)
    public Object[][] provideData() {
        return new Object[][] {
            { 2.0,  3.0, 8.0 },
            { 3.0,  2.0, 9.0 },
            { 5.0,  0.0, 1.0 },
            { 0.0,  5.0, 0.0 },
        };
    }

    @Test(dataProvider = "powData")
    public void testPow_parameterized(double base, double exp, double expected) {
        Assert.assertEquals(calculator.pow(base, exp), expected, DELTA);
    }

    @Test
    public void testPow_baseOne() {
        Assert.assertEquals(calculator.pow(1.0, 100.0), 1.0, DELTA);
    }
}
