package com.epam.tat.tests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

@Test(groups = "trigonometry")
public class CosTest {
    private static final double DELTA = 1e-9;
    private Calculator calculator;

    @BeforeMethod
    public void setUp() { calculator = new Calculator(); }

    @AfterMethod
    public void tearDown() { calculator = null; }

    @DataProvider(name = "cosData", parallel = true)
    public Object[][] provideData() {
        return new Object[][] {
            { 0.0,         1.0  },
            { Math.PI / 2, 0.0  },
            { Math.PI,    -1.0  },
            { 2*Math.PI,   1.0  },
        };
    }

    @Test(dataProvider = "cosData")
    public void testCos_parameterized(double angle, double expected) {
        Assert.assertEquals(calculator.cos(angle), expected, DELTA);
    }

    @Test
    public void testCos_zero() {
        Assert.assertEquals(calculator.cos(0.0), 1.0, DELTA);
    }
}
