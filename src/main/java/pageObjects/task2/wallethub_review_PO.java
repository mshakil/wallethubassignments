package pageObjects.task2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class wallethub_review_PO extends wallethub_PO {
    private @FindBy(css = ("div.left-content a"))
    List<WebElement> navigation_Links;

    private @FindBy(css= ("div.review-action h3"))
    WebElement rating_Heading;

    public void ClickReviewSection()
    {
        for (WebElement element : navigation_Links)
        {
            String href = element.getAttribute("href");
            if(href.contains("#reviews")){
                waitForWebElementAndClick(element);
                break;
            }
        }
    }

    public void VerifyReviewSectionIsVisible(String message)
    {
        waitForElement_And_ValidateText(rating_Heading,message);
    }

}
