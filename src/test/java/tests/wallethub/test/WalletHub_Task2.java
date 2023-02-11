package tests.wallethub.test;

import main.MainCalls;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;
import tests.base.Hooks;
import utils.GlobalVars;

public class WalletHub_Task2 extends Hooks {
    @Test
    public void LoginToWalletHubWebSite() {

        String webUrl = GlobalVars.WALLET_HUB_LOGIN_URL;
        String test_profileUrl = GlobalVars.WALLET_HUB_PROFILE_URL;
        String username = GlobalVars.WALLET_HUB_USER_NAME;
        String password = GlobalVars.WALLET_HUB_USER_PASSWORD;
        String test_profile_name = GlobalVars.WALLET_HUB_PROFILE_NAME;
        String user_profile_url = GlobalVars.WALLET_HUB_PROFILE;

        Boolean isEditProfileVisible = true;
        String ratingHeadingTitle = "What's Your Rating?";
        String startToRate = "4 star rating";
        String insuranceType = "Health Insurance";

        String reviewMessage = "Lorem Ipsum is simply dummy text of the printing and typesetting industry." +
                " Lorem Ipsum has been the industry's standard dummy text ever since the 1500s," +
                " when an unknown printer took a galley of type and scrambled it to make a type specimen book.";

        String checkReviewName = GlobalVars.WALLET_HUB_PROFILE_TAG;
        String profileRecommendation = GlobalVars.WALLET_HUB_PROFILE_NAME + "'s Recommendations";
        try {
            //  LOGIN TO WALLET HUB ACCOUNT
            MainCalls.getWallethub_login_po().navigateTo_URL(webUrl);
            MainCalls.getWallethub_login_po().LoginToWalletHubAccount(username, password);

            //  VERIFY LOGIN TO WALLET HUB ACCOUNT SUCCESSFUL
            MainCalls.getWallethub_login_po().VerifyIsProfileNameVisible(test_profile_name);
            MainCalls.getWallethub_login_po().VerifyIsEditProfileButtonVisible(isEditProfileVisible);

            //  NAVIGATE TO TEST INSURANCE PROFILE
            test_profile_name = "Test Insurance Company";
            MainCalls.getWallethub_review_po().navigateTo_URL(test_profileUrl);
            MainCalls.getWallethub_login_po().VerifyIsProfileNameVisible(test_profile_name);

            //  CLICK REVIEW SECTION AND CHECK RATING TITLE
            MainCalls.getWallethub_review_po().clickReviewSection();


            MainCalls.getWallethub_review_po().verifyReviewSectionIsVisible(ratingHeadingTitle);

            //  CHECK ALL THE STARS LIGHT UP PROPERLY AND PROFILE AND RATINGS ALSO SHOWING IN DIALOG BOX
            MainCalls.getWallethub_review_po().verifyAllRatingStarsLightUpAndClickOnStart(startToRate);
            MainCalls.getWallethub_review_po().verifyRatingProfileNameIsVisible(test_profile_name);
            MainCalls.getWallethub_review_po().verifyRatingStarsAlsoLightUpOnReviewDialog(4);

            //  SELECT INSURANCE TYPE, WRITE REVIEW AND SUBMIT
            MainCalls.getWallethub_review_po().submitReview(insuranceType, reviewMessage);

            //  VERIFY REVIEW IS SUBMITTED SUCCESSFULLY!
            MainCalls.getWallethub_review_po().verifyReviewSuccessMessage();
            MainCalls.getWallethub_review_po().verifyReviewMessageAfterSubmit(reviewMessage);

            // CLICK CONTINUE BUTTON AND VERIFY REVIEW FEED
            MainCalls.getWallethub_review_po().clickContinueButton();
            MainCalls.getWallethub_login_po().VerifyIsProfileNameVisible(test_profile_name);
            MainCalls.getWallethub_review_po().checkReviewInReviewList(checkReviewName);


            MainCalls.getWallethub_review_po().navigateTo_URL(user_profile_url);
            MainCalls.getWallethub_login_po().VerifyIsProfileNameVisible(GlobalVars.WALLET_HUB_PROFILE_NAME);
            MainCalls.getWallethub_login_po().verifyUserRecommendation(profileRecommendation);
        } catch (Exception ex) {
            System.out.println(ex);
            Assert.fail("Some error occurred while executing scripts");
        }
    }
}
