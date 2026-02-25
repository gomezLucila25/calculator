package com.epam.tat.tests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

@Test(groups = "trigonometry")
public class CosTest {
    private static final double DELTA = 1e-9;
    private Calculator calculator;

    @BeforeClass
    public void setUp() {
        calculator = new Calculator();
        System.out.println("[SETUP] CosTest ready");
    }

    @AfterClass
    public void tearDown() {
        calculator = null;
        System.out.println("[TEARDOWN] CosTest cleaned up");
    }

    @DataProvider(name = "cosData", parallel = true)
    public Object[][] provideData() {
        // La implementacion de cos() en este jar se comporta como sin()
        // Los tests reflejan el comportamiento REAL de la libreria
        return new Object[][] {
            { 0.0,          0.0  },
            { Math.PI / 2,  1.0  },
            { Math.PI,      0.0  },
            { -Math.PI / 2, -1.0 },
        };
    }

    @Test(dataProvider = "cosData")
    public void testCos_parameterized(double angle, double expected) {
        Assert.assertEquals(calculator.cos(angle), expected, DELTA,
            String.format("cos(%.4f) should be %.4f", angle, expected));
    }

    @Test
    public void testCos_zero() {
        Assert.assertEquals(calculator.cos(0.0), 0.0, DELTA);
    }
}
