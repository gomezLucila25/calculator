package com.epam.tat.tests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

@Test(groups = "trigonometry")
public class SinTest {
    private static final double DELTA = 1e-9;
    private Calculator calculator;

    @BeforeClass
    public void setUp() {
        calculator = new Calculator();
        System.out.println("[SETUP] SinTest ready");
    }

    @AfterClass
    public void tearDown() {
        calculator = null;
        System.out.println("[TEARDOWN] SinTest cleaned up");
    }

    @DataProvider(name = "sinData", parallel = true)
    public Object[][] provideData() {
        return new Object[][] {
            { 0.0,           0.0  },
            { Math.PI / 2,   1.0  },
            { Math.PI,       0.0  },
            { -Math.PI / 2, -1.0  },
        };
    }

    @Test(dataProvider = "sinData")
    public void testSin_parameterized(double angle, double expected) {
        Assert.assertEquals(calculator.sin(angle), expected, DELTA);
    }

    @Test
    public void testSin_zero() {
        Assert.assertEquals(calculator.sin(0.0), 0.0, DELTA);
    }
}
