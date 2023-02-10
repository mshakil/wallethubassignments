package pageObjects.task2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.Base_PO;

import java.util.List;

public class wallethub_PO extends Base_PO {
    private @FindBy(css=("div[data-pagelet^='FeedUnit_']")) List<WebElement> posts;

    public void FindMyPost(){
        String postId = null;
        for (WebElement element: posts) {

            String userName = element.findElement( By.tagName("strong")).findElement(By.tagName("span")).getText();
            if(userName.equals("Alex Json")){
                postId = element.getAttribute("id");
                break;
            }
            String customSelector = "div[data-pagelet='"+postId+"'] div[id^='jsc_c'] div.x1vvkbs";
            String text = getDriver().findElement(By.cssSelector(customSelector)).getText();

        }
    }
}
