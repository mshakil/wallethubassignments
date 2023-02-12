package tests.base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import static driver.DriverFactory.cleanUpDriver;
import static driver.DriverFactory.getDriver;

public class Hooks {
    @BeforeClass
    public void Setup() {
        getDriver();
        System.out.println("Before Test Worked!");

    }
    @AfterClass
    public void Teardown() {
        cleanUpDriver();
        System.out.println("After Test Worked!");
    }
}
