package com.epam.tat.tests;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

@Test(groups = "arithmetic")
public class SubLongTest {
    private Calculator calculator;

    @BeforeClass
    public void setUp() { calculator = new Calculator(); }

    @AfterClass
    public void tearDown() { calculator = null; }

    @DataProvider(name = "subLongData", parallel = true)
    public Object[][] provideData() {
        return new Object[][] {
            { 10L,  3L,  7L },
            {  3L, 10L, -7L },
            {  0L,  0L,  0L },
            { -5L, -3L, -2L },
            {  5L,  5L,  0L },
        };
    }

    @Test(dataProvider = "subLongData")
    public void testSubLong_parameterized(long a, long b, long expected) {
        Assert.assertEquals(calculator.sub(a, b), expected);
    }

    @Test
    public void testSubLong_sameNumber() {
        Assert.assertEquals(calculator.sub(99L, 99L), 0L);
    }

    @Test
    public void testSubLong_fromZero() {
        Assert.assertEquals(calculator.sub(0L, 50L), -50L);
    }
}
