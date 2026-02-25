package com.epam.tat.tests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

@Test(groups = "arithmetic")
public class MultLongTest {
    private Calculator calculator;

    @BeforeMethod
    public void setUp() { calculator = new Calculator(); }

    @AfterMethod
    public void tearDown() { calculator = null; }

    @DataProvider(name = "multLongData", parallel = true)
    public Object[][] provideData() {
        return new Object[][] {
            {  3L,  4L,  12L },
            { -3L,  4L, -12L },
            { -3L, -4L,  12L },
            {  0L, 99L,   0L },
            {  1L, 42L,  42L },
        };
    }

    @Test(dataProvider = "multLongData")
    public void testMultLong_parameterized(long a, long b, long expected) {
        Assert.assertEquals(calculator.mult(a, b), expected);
    }

    @Test
    public void testMultLong_byZero() {
        Assert.assertEquals(calculator.mult(Long.MAX_VALUE, 0L), 0L);
    }

    @Test
    public void testMultLong_negativeNegativeIsPositive() {
        Assert.assertEquals(calculator.mult(-7L, -8L), 56L);
    }
}
