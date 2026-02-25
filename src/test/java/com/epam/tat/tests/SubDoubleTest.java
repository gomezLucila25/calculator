package com.epam.tat.tests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

@Test(groups = "arithmetic")
public class SubDoubleTest {
    private static final double DELTA = 1e-9;
    private Calculator calculator;

    @BeforeMethod
    public void setUp() { calculator = new Calculator(); }

    @AfterMethod
    public void tearDown() { calculator = null; }

    @DataProvider(name = "subDoubleData", parallel = true)
    public Object[][] provideData() {
        return new Object[][] {
            {  5.5,  2.5,  3.0 },
            {  2.5,  5.5, -3.0 },
            {  0.0,  0.0,  0.0 },
            { -3.0, -1.0, -2.0 },
        };
    }

    @Test(dataProvider = "subDoubleData")
    public void testSubDouble_parameterized(double a, double b, double expected) {
        Assert.assertEquals(calculator.sub(a, b), expected, DELTA);
    }

    @Test
    public void testSubDouble_selfIsZero() {
        Assert.assertEquals(calculator.sub(3.14, 3.14), 0.0, DELTA);
    }
}
