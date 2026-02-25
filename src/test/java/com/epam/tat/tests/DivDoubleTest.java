package com.epam.tat.tests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

@Test(groups = "arithmetic")
public class DivDoubleTest {
    private static final double DELTA = 1e-9;
    private Calculator calculator;

    @BeforeClass
    public void setUp() { calculator = new Calculator(); }

    @AfterClass
    public void tearDown() { calculator = null; }

    @DataProvider(name = "divDoubleData", parallel = true)
    public Object[][] provideData() {
        return new Object[][] {
            { 10.0, 4.0,  2.5           },
            { -9.0, 3.0, -3.0           },
            {  0.0, 5.0,  0.0           },
            {  1.0, 3.0,  0.3333333333  },
        };
    }

    @Test(dataProvider = "divDoubleData")
    public void testDivDouble_parameterized(double a, double b, double expected) {
        Assert.assertEquals(calculator.div(a, b), expected, 1e-9);
    }

    @Test
    public void testDivDouble_byZeroIsInfinity() {
        Assert.assertTrue(Double.isInfinite(calculator.div(1.0, 0.0)));
    }
}
