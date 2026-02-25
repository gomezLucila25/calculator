package com.epam.tat.tests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

@Test(groups = "boolean-checks")
public class IsPositiveTest {
    private Calculator calculator;

    @BeforeClass
    public void setUp() { calculator = new Calculator(); }

    @AfterClass
    public void tearDown() { calculator = null; }

    @DataProvider(name = "isPositiveData", parallel = true)
    public Object[][] provideData() {
        return new Object[][] {
            {  1L,   true  },
            {  100L, true  },
            { -1L,   false },
            { -100L, false },
            {  0L,   false },
        };
    }

    @Test(dataProvider = "isPositiveData")
    public void testIsPositive_parameterized(long number, boolean expected) {
        Assert.assertEquals(calculator.isPositive(number), expected);
    }

    @Test
    public void testIsPositive_maxValue() {
        Assert.assertTrue(calculator.isPositive(Long.MAX_VALUE));
    }

    @Test
    public void testIsPositive_minValue() {
        Assert.assertFalse(calculator.isPositive(Long.MIN_VALUE));
    }
}
