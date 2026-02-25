package com.epam.tat.tests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

@Test(groups = "trigonometry")
public class TgTest {
    private static final double DELTA = 1e-9;
    private Calculator calculator;

    @BeforeMethod
    public void setUp() { calculator = new Calculator(); }

    @AfterMethod
    public void tearDown() { calculator = null; }

    @DataProvider(name = "tgData", parallel = true)
    public Object[][] provideData() {
        return new Object[][] {
            { 0.0,           0.0  },
            { Math.PI / 4,   1.0  },
            { -Math.PI / 4, -1.0  },
        };
    }

    @Test(dataProvider = "tgData")
    public void testTg_parameterized(double angle, double expected) {
        Assert.assertEquals(calculator.tg(angle), expected, DELTA);
    }

    @Test
    public void testTg_zero() {
        Assert.assertEquals(calculator.tg(0.0), 0.0, DELTA);
    }
}
