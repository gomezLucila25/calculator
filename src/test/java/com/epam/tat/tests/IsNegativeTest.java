package com.epam.tat.tests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

@Test(groups = "boolean-checks")
public class IsNegativeTest {
    private Calculator calculator;

    @BeforeClass
    public void setUp() { calculator = new Calculator(); }

    @AfterClass
    public void tearDown() { calculator = null; }

    @DataProvider(name = "isNegativeData", parallel = true)
    public Object[][] provideData() {
        return new Object[][] {
            { -1L,   true  },
            { -999L, true  },
            {  1L,   false },
            {  999L, false },
            {  0L,   false },
        };
    }

    @Test(dataProvider = "isNegativeData")
    public void testIsNegative_parameterized(long number, boolean expected) {
        Assert.assertEquals(calculator.isNegative(number), expected);
    }

    @Test
    public void testIsNegative_minValue() {
        Assert.assertTrue(calculator.isNegative(Long.MIN_VALUE));
    }

    @Test
    public void testIsNegative_maxValue() {
        Assert.assertFalse(calculator.isNegative(Long.MAX_VALUE));
    }

    @Test(dependsOnGroups = "arithmetic")
    public void testIsNegative_complementOfPositive() {
        Assert.assertTrue(calculator.isNegative(-42L));
        Assert.assertFalse(calculator.isPositive(-42L));
    }
}
