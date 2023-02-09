package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base_PO {
    public Base_PO() {
        //  CONSTRUCTOR Logic here
        PageFactory.initElements(getDriver(), this);
    }
    public WebDriver getDriver() {
        return DriverFactory.getDriver();
    }
    public void navigateTo_URL(String url) {
        getDriver().get(url);
    }
}
