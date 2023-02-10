package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.GlobalVars;

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
    public void sendKeys(WebElement element, String textToType) {
        WebDriverWait wait = new WebDriverWait(getDriver(), GlobalVars.WEBDRIVER_DEFAULT_EXPLICIT_TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(textToType);
    }

    public void waitForWebElementAndClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), GlobalVars.WEBDRIVER_DEFAULT_EXPLICIT_TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void waitForElement_And_ValidateText(WebElement element, String text) {
        WebDriverWait wait = new WebDriverWait(getDriver(), GlobalVars.WEBDRIVER_DEFAULT_EXPLICIT_TIMEOUT);
        String actualText = wait.until(ExpectedConditions.visibilityOf(element)).getText();

        Assert.assertEquals(actualText, text);
    }

    public void waitForElement_And_Validate(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), GlobalVars.WEBDRIVER_DEFAULT_EXPLICIT_TIMEOUT);
        boolean isVisable = wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();

        Assert.assertTrue(isVisable);
    }
}
