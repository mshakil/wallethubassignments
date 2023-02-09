package pageObjects.task1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.Base_PO;

public class facebook_PO  extends Base_PO {
    public facebook_PO(){
        super();
    }

    private @FindBy(xpath="//input[@name='first_name']")
    WebElement firstName_TextField;


}
