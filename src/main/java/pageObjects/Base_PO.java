package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.apache.commons.lang3.RandomStringUtils;
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

    protected By byUlTag = new By.ByTagName("ul");
    protected By byLiTag = new By.ByTagName("li");
    protected By byHeading2Tag = new By.ByTagName("h2");
    protected By byHeading4Tag = new By.ByTagName("h4");

    public String generateRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
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

        Assert.assertEquals(actualText, text, "Element Text is not Equals to Expected Text");
        System.out.println("Element Validate Assertion Worked!");
    }

    public void waitForElement_And_Displayed(WebElement element, Boolean displayed) {
        WebDriverWait wait = new WebDriverWait(getDriver(), GlobalVars.WEBDRIVER_DEFAULT_EXPLICIT_TIMEOUT);
        Boolean isDisplayed = wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();

        Assert.assertEquals(displayed, isDisplayed, "Element is not visible on DOM");
        System.out.println("Element Displayed Assertion Worked!");
    }

    public void waitForElement_And_Validate(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), GlobalVars.WEBDRIVER_DEFAULT_EXPLICIT_TIMEOUT);
        boolean isVisable = wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();

        Assert.assertTrue(isVisable);
    }

    public void waitForElement_And_MouseOver(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), GlobalVars.WEBDRIVER_DEFAULT_EXPLICIT_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(element));

        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).perform();
    }

    public void waitForElement_ToDisappear(WebElement element){
        WebDriverWait wait = new WebDriverWait(getDriver(), GlobalVars.WEBDRIVER_DEFAULT_EXPLICIT_TIMEOUT);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
}
