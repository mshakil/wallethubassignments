package pageObjects.task2;

import net.bytebuddy.matcher.FilterableList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class wallethub_review_PO extends wallethub_PO {
    private @FindBy(css = ("div.left-content a"))
    List<WebElement> navigation_Links;

    private @FindBy(css = ("div.review-action h3"))
    WebElement rating_Heading;

    private @FindBy(css = ("div[class*='review-action'] svg"))
    List<WebElement> ratingStars;

    private @FindBy(css = ("div.flex-box-rv"))
    WebElement review_Dialog_Container;

    private @FindBy(css = ("div.flex-box-rv h4"))
    WebElement review_Dialog_ProfileName;

    private @FindBy(css = ("div[class='flex-box-rv'] div[class='rating-box-wrapper'] svg > g :not(path[stroke-linejoin='miter'])"))
    List<WebElement> review_Dialog_Ratings;

    private @FindBy(css = ("div[class='flex-box-rv'] div[class*='dropdown']"))
    WebElement insurance_Dropdown;

    private @FindBy(css = ("div.flex-box-rv textarea"))
    WebElement review_TextArea;

    private @FindBy(css=("div[class='sub-nav-ct'] div[role='button'][class*='sbn-action']"))
    WebElement submit_Review_Button;

    private @FindBy(css=("div.rvc-header"))
    WebElement rating_Success_Message;

    private @FindBy(css = ("div.rvc-body-middle p"))
    WebElement rating_ActualMessage;

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

    public void verifyRatingProfileNameIsVisible(String profileName) {
        waitForElement_And_ValidateText(review_Dialog_ProfileName, profileName);
        System.out.println(profileName + " showing in Review Dialog window");
    }

    public void verifyRatingStarsAlsoLightUpOnReviewDialog(int rating) {
        int actualCount = 0;
        for (WebElement element :
                review_Dialog_Ratings) {
            String getFillAttribute = element.getAttribute("fill");
            if (getFillAttribute.equals("#4ae0e1")) {
                actualCount++;
            }
        }
        Assert.assertEquals(rating, actualCount, "Actual rating is not equals to expected rating.");
        System.out.println(actualCount + " Stars are showing in Review Dialog window");
    }

    private void selectInsuranceType(String insuranceType){
        waitForWebElementAndClick(insurance_Dropdown);

         List<WebElement> insuranceList = insurance_Dropdown.findElement(byUlTag).findElements(byLiTag);
        for (WebElement element: insuranceList) {
            if(element.getText().equals(insuranceType)){
                waitForWebElementAndClick(element);
                break;
            }
        }
        System.out.println(insuranceType+" Selected from dropdown");
    }

    private void writeReview(String reviewMessage){
        sendKeys(review_TextArea,reviewMessage);
    }

    private void clickSubmitReview()
    {
        waitForWebElementAndClick(submit_Review_Button);
    }

    public void submitReview(String insuranceType, String reviewMessage){
        selectInsuranceType(insuranceType);
        writeReview(reviewMessage);
        clickSubmitReview();
    }

    public void verifyReviewSuccessMessage(){
        waitForElement_And_Displayed(rating_Success_Message,true);

        String headingMessage = rating_Success_Message.findElement(byHeading2Tag).getText()+rating_Success_Message.findElement(byHeading4Tag).getText();
        Assert.assertEquals(headingMessage,"Awesome!Your review has been posted.");
    }

    public void verifyReviewMessageAfterSubmit(String message)
    {
        waitForElement_And_ValidateText(rating_ActualMessage,message);
    }
}

