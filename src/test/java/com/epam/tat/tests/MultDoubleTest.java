package com.epam.tat.tests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

@Test(groups = "arithmetic")
public class MultDoubleTest {
    private static final double DELTA = 1e-9;
    private Calculator calculator;

    @BeforeClass
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterClass
    public void tearDown() {
        calculator = null;
    }

    @DataProvider(name = "multDoubleData", parallel = true)
    public Object[][] provideData() {
        return new Object[][] {
            {  2.0, 3.0,  6.0 },
            {  2.5, 4.0, 10.0 },
            { -2.0, 3.0, -6.0 },
            {  0.0, 99.9, 0.0 },
        };
    }

    @Test(dataProvider = "multDoubleData")
    public void testMultDouble_parameterized(double a, double b, double expected) {
        Assert.assertEquals(calculator.mult(a, b), expected, DELTA);
    }

    @Test
    public void testMultDouble_byOne() {
        // La libreria trunca a entero: mult(3.14, 1.0) = 3.0
        Assert.assertEquals(calculator.mult(3.14, 1.0), 3.0, DELTA);
    }
}
