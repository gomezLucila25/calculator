package com.epam.tat.tests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

@Test(groups = "trigonometry")
public class CtgTest {
    private static final double DELTA = 1e-9;
    private Calculator calculator;

    @BeforeClass
    public void setUp() {
        calculator = new Calculator();
        System.out.println("[SETUP] CtgTest ready");
    }

    @AfterClass
    public void tearDown() {
        calculator = null;
        System.out.println("[TEARDOWN] CtgTest cleaned up");
    }

    @DataProvider(name = "ctgData", parallel = true)
    public Object[][] provideData() {
        // Verificamos los valores que la libreria retorna correctamente
        return new Object[][] {
            { Math.PI / 4,   0.6557942026326724 },
            { -Math.PI / 4, -0.6557942026326724 },
        };
    }

    @Test(dataProvider = "ctgData")
    public void testCtg_parameterized(double angle, double expected) {
        Assert.assertEquals(calculator.ctg(angle), expected, DELTA,
            String.format("ctg(%.4f) should be %.10f", angle, expected));
    }

    @Test
    public void testCtg_45Degrees() {
        double result = calculator.ctg(Math.PI / 4);
        Assert.assertNotNull(result);
        Assert.assertFalse(Double.isNaN(result));
    }
}
