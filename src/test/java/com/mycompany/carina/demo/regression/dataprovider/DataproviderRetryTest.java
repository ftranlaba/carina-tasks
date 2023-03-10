package com.mycompany.carina.demo.regression.dataprovider;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * Carina regression test with retries and it's registration in Zafira.
 * It just generate failure in 50% of cases and on retry should improve statistic
 *
 * @author qpsdemo
 */
public class DataproviderRetryTest implements IAbstractTest {
    @DataProvider(parallel = false, name = "DP1")
    public static Object[][] dataprovider() {
        return new Object[][]{
                {"111,112", 2, 3, 6},
                {"114", 6, 6, 36},
                {"111,112", 2, 3, 6},
                {"114", 6, 6, 36},
                {"111,112", 2, 3, 6},
                {"114", 6, 6, 36},
                {"111,112", 2, 3, 6},
                {"114", 6, 6, 36},
                {"111,112", 2, 3, 6},
                {"114", 6, 6, 36}};
    }

    @Test(dataProvider = "DP1")
    @MethodOwner(owner = "qpsdemo")
    public void testDataproviderRetry(String testRailColumn, int a, int b, int c) {
        boolean isPassed = (new Random().nextInt(2) == 1) ? true : false;
        Assert.assertTrue(isPassed);

        setCases(testRailColumn.split(","));
        int actual = a * b;
        int expected = c;
        Assert.assertEquals(actual, expected, "Invalid sum result!");
    }


}