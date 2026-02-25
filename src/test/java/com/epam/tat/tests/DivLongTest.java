package com.epam.tat.tests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

@Test(groups = "arithmetic")
public class DivLongTest {
    private Calculator calculator;

    @BeforeMethod
    public void setUp() { calculator = new Calculator(); }

    @AfterMethod
    public void tearDown() { calculator = null; }

    @DataProvider(name = "divLongData", parallel = true)
    public Object[][] provideData() {
        return new Object[][] {
            {  10L,  2L,  5L },
            { -10L,  2L, -5L },
            {  10L, -2L, -5L },
            {   0L,  5L,  0L },
            {   7L,  2L,  3L },
        };
    }

    @Test(dataProvider = "divLongData")
    public void testDivLong_parameterized(long a, long b, long expected) {
        Assert.assertEquals(calculator.div(a, b), expected);
    }

    @Test
    public void testDivLong_selfDivision() {
        Assert.assertEquals(calculator.div(42L, 42L), 1L);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivLong_byZeroThrowsException() {
        calculator.div(10L, 0L);
    }
}
