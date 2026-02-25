package com.epam.tat.tests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

@Test(groups = "trigonometry")
public class CtgTest {
    private static final double DELTA = 1e-9;
    private Calculator calculator;

    @BeforeMethod
    public void setUp() { calculator = new Calculator(); }

    @AfterMethod
    public void tearDown() { calculator = null; }

    @DataProvider(name = "ctgData", parallel = true)
    public Object[][] provideData() {
        return new Object[][] {
            { Math.PI / 4,   1.0  },
            { -Math.PI / 4, -1.0  },
            { Math.PI / 2,   0.0  },
        };
    }

    @Test(dataProvider = "ctgData")
    public void testCtg_parameterized(double angle, double expected) {
        Assert.assertEquals(calculator.ctg(angle), expected, DELTA);
    }

    @Test
    public void testCtg_45Degrees() {
        Assert.assertEquals(calculator.ctg(Math.PI / 4), 1.0, DELTA);
    }
}
