package tests.wallethub.test;

import main.MainCalls;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;
import tests.base.Hooks;
import utils.GlobalVars;

public class WalletHub_Task2 extends Hooks
{
    @Test
    public void LoginToWalletHubWebSite(){

        String webUrl = GlobalVars.WALLET_HUB_LOGIN_URL;
        String profileUrl = GlobalVars.WALLET_HUB_PROFILE_URL;
        String username = GlobalVars.WALLET_HUB_USER_NAME;
        String password = GlobalVars.WALLET_HUB_USER_PASSWORD;
        String profilename = GlobalVars.WALLET_HUB_PROFILE_NAME;

        Boolean isEditProfileVisible = true;
        String ratingHeadingTitle = "What's Your Rating?";
        String startToRate = "4 star rating";
        try{
            MainCalls.getWallethub_login_po().navigateTo_URL(webUrl);
            MainCalls.getWallethub_login_po().LoginToWalletHubAccount(username,password);

            MainCalls.getWallethub_login_po().VerifyIsProfileNameVisible(profilename);
            MainCalls.getWallethub_login_po().VerifyIsEditProfileButtonVisible(isEditProfileVisible);

            profilename = "Test Insurance Company";
            MainCalls.getWallethub_review_po().navigateTo_URL(profileUrl);
            MainCalls.getWallethub_login_po().VerifyIsProfileNameVisible(profilename);

            MainCalls.getWallethub_review_po().clickReviewSection();
            MainCalls.getWallethub_review_po().verifyReviewSectionIsVisible(ratingHeadingTitle);

            MainCalls.getWallethub_review_po().verifyAllRatingStarsLightUpAndClickOnStart(startToRate);
            MainCalls.getWallethub_review_po().verifyRatingProfileNameIsVisible(profilename);
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }
}
