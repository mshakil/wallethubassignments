package pageObjects.task1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.Base_PO;

public class facebook_PO extends Base_PO {
    private @FindBy(css = ("input[id='email']"))
    WebElement userName_TextField;
    private @FindBy(css = ("input[id='pass']"))
    WebElement password_TextField;
    private @FindBy(css = ("button[name='login']"))
    WebElement login_Button;

    public void enterEmail(String email) {
        sendKeys(userName_TextField, email);
    }

    public void enterPassword(String password) {
        sendKeys(password_TextField, password);
    }

    public void clickLogin() {
        waitForWebElementAndClick(login_Button);
    }
}
