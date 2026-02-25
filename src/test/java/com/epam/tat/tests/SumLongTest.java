package com.epam.tat.tests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

@Test(groups = "arithmetic")
public class SumLongTest {
    private Calculator calculator;

    @BeforeClass
    public void setUp() { calculator = new Calculator(); }

    @AfterClass
    public void tearDown() { calculator = null; }

    @DataProvider(name = "sumLongData", parallel = true)
    public Object[][] provideData() {
        return new Object[][] {
            {  2L,  3L,  5L },
            { -2L, -3L, -5L },
            { -2L,  5L,  3L },
            {  0L,  0L,  0L },
            { Long.MAX_VALUE, 0L, Long.MAX_VALUE },
        };
    }

    @Test(dataProvider = "sumLongData")
    public void testSumLong_parameterized(long a, long b, long expected) {
        Assert.assertEquals(calculator.sum(a, b), expected);
    }

    @Test
    public void testSumLong_twoPositive() {
        Assert.assertEquals(calculator.sum(10L, 20L), 30L);
    }

    @Test
    public void testSumLong_withZero() {
        Assert.assertEquals(calculator.sum(42L, 0L), 42L);
    }
}
