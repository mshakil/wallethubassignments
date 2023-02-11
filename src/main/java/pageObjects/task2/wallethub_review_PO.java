package pageObjects.task2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class wallethub_review_PO extends wallethub_PO {
    private @FindBy(css = ("div.left-content a"))
    List<WebElement> navigation_Links;

    private @FindBy(css = ("div.review-action h3"))
    WebElement rating_Heading;

    private @FindBy(css = ("div[class*='review-action'] svg"))
    List<WebElement> ratingStars;

    private @FindBy(css= ("div.flex-box-rv h4"))
    WebElement review_Dialog_ProfileName;

    public void clickReviewSection() {
        for (WebElement element : navigation_Links) {
            String href = element.getAttribute("href");
            if (href.contains("#reviews")) {
                waitForWebElementAndClick(element);
                break;
            }
        }
    }

    public void verifyReviewSectionIsVisible(String message) {
        waitForElement_And_ValidateText(rating_Heading, message);
    }

    public void verifyAllRatingStarsLightUpAndClickOnStart(String startToRate) {
        for (WebElement element :
                ratingStars) {
            waitForElement_And_MouseOver(element);
            String lightStatus = element.getAttribute("aria-checked");
            String starLabel = element.getAttribute("aria-label");
            System.out.println(starLabel + ":" + lightStatus);

            if (starLabel.equals(startToRate)) {
                waitForWebElementAndClick(element);
            }
        }
    }
    public void verifyRatingProfileNameIsVisible(String profileName)
    {
        waitForElement_And_ValidateText(review_Dialog_ProfileName,profileName);
    }
}
