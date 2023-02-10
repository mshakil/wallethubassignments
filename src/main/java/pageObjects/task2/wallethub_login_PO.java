package pageObjects.task2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class wallethub_login_PO extends wallethub_PO {

    private @FindBy(id = ("email"))
    WebElement userName_TextField;

    private @FindBy(id = ("password"))
    WebElement password_TextField;

    private @FindBy(xpath = ("//input[@value='submit']/../button[@data-hm-tap='doLogin($event);']"))
    WebElement login_Button;

    private @FindBy(className = ("profile-name"))
    WebElement profile_Name;

    private @FindBy(xpath = ("//div[@class='header-container']//button"))
    WebElement profile_Edit_Button;

    private void EnterUserName(String username) {
        sendKeys(userName_TextField, username);
    }

    private void EnterPassword(String password) {
        sendKeys(password_TextField, password);
    }

    private void ClickLoginButton() {
        waitForWebElementAndClick(login_Button);
    }

    public void LoginToWalletHubAccount(String username, String password) {
        EnterUserName(username);
        EnterPassword(password);
        ClickLoginButton();
    }

    public void VerifyIsProfileNameVisible(String profilename) {
        waitForElement_And_ValidateText(profile_Name, profilename);
    }

    public void VerifyIsEditProfileButtonVisible(Boolean isDisplayed) {
        waitForElement_And_Displayed(profile_Edit_Button, isDisplayed);
    }
}
