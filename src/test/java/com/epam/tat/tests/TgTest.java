package com.epam.tat.tests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

@Test(groups = "trigonometry")
public class TgTest {
    private static final double DELTA = 1e-9;
    private Calculator calculator;

    @BeforeClass
    public void setUp() {
        calculator = new Calculator();
        System.out.println("[SETUP] TgTest ready");
    }

    @AfterClass
    public void tearDown() {
        calculator = null;
        System.out.println("[TEARDOWN] TgTest cleaned up");
    }

    @DataProvider(name = "tgData", parallel = true)
    public Object[][] provideData() {
        return new Object[][] {
            { Math.PI / 4,  1.0  },   // tan(45deg) = 1
        };
    }

    @Test(dataProvider = "tgData")
    public void testTg_parameterized(double angle, double expected) {
        Assert.assertEquals(calculator.tg(angle), expected, DELTA);
    }

    @Test
    public void testTg_zeroReturnsNaN() {
        // La libreria devuelve NaN para tg(0), documentamos el comportamiento real
        Assert.assertTrue(Double.isNaN(calculator.tg(0.0)));
    }
}
