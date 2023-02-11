package pageObjects.task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageObjects.Base_PO;

import java.util.List;

public class facebook_PO extends Base_PO {
    private @FindBy(css = ("input[id='email']"))
    WebElement userName_TextField;
    private @FindBy(css = ("input[id='pass']"))
    WebElement password_TextField;
    private @FindBy(css = ("button[name='login']"))
    WebElement login_Button;
    private @FindBy(css = ("a[aria-label='Home']"))
    WebElement home_Button;
    private @FindBy(xpath = ("//div[@aria-label='Create a post']//div[@role='button']"))
    WebElement status_Button;

    private @FindBy(css = ("div[aria-label*='on your mind']"))
    WebElement status_TextField;

    private @FindBy(css = ("div[aria-label='Post']"))
    WebElement status_PostButton;

    private @FindBy(css = ("div[data-pagelet='FeedUnit_0'] div[id^='jsc_c'] div.x1vvkbs"))  //div[data-pagelet^='FeedUnit_'] strong span
    WebElement check_Status;

    private @FindBy(css = ("div[data-pagelet^='FeedUnit_']")) List<WebElement> posts;

    public facebook_PO() {
        super();
    }

    private void enterEmail(String email) {
        sendKeys(userName_TextField, email);
    }

    private void enterPassword(String password) {
        sendKeys(password_TextField, password);
    }

    private void clickLogin() {
        waitForWebElementAndClick(login_Button);
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLogin();

    }

    private void clickHomeButton() {
        waitForWebElementAndClick(home_Button);
    }

    public void CheckFaceBookPage() {
        waitForElement_And_Validate(home_Button);

    }

    private void clickStatus() {
        waitForWebElementAndClick(status_Button);
    }

    private void enterStatus(String status) {
        sendKeys(status_TextField, status);
    }

    private void clickPostButton() throws InterruptedException {
        waitForWebElementAndClick(status_PostButton);
        waitForElement_ToDisappear(status_PostButton);

    }

    public void postStatus(String status) {
        clickHomeButton();
        clickStatus();
        enterStatus(status);
        try {
            clickPostButton();
        } catch (Exception a) {
        }
    }

    public void checkStatus(String text) {
        waitForElement_And_ValidateText(check_Status, text);
    }


    public void FindMyPost(String postText) {
        String postId = null;
        for (WebElement element : posts) {

            String userName = element.findElement(By.tagName("strong")).findElement(By.tagName("span")).getText();
            System.out.println(userName);
            if (userName.equals("Alex Jason")) {
                postId = element.getAttribute("data-pagelet");
                String customSelector = "div[data-pagelet='" + postId + "'] div[id^='jsc_c'] div.x1vvkbs";
                System.out.println(customSelector);

                String text = getDriver().findElement(By.cssSelector(customSelector)).getText();
                Assert.assertEquals(text, postText, "Status Not Posted");
                break;
            }
        }
    }

}
