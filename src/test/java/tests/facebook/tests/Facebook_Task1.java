package tests.facebook.tests;

import main.MainCalls;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.Hooks;
import utils.GlobalVars;

public class Facebook_Task1 extends Hooks {
    @Test
    public void LoginToFacebookAndPostStatus() {
        String status = MainCalls.getFb_po().generateRandomString(10);

        try {
            MainCalls.getFb_po().navigateTo_URL(GlobalVars.FACEBOOK_BASEURL);
            MainCalls.getFb_po().login(GlobalVars.FACEBOOK_USERNAME, GlobalVars.FACEBOOK_PASSWORD);

            MainCalls.getFb_po().CheckFaceBookPage();

            MainCalls.getFb_po().postStatus(status);
            MainCalls.getFb_po().FindMyPost(status);

        } catch (Exception ex) {
            System.out.println(ex);
            Assert.fail("Some error occurred while executing scripts");
        }
    }
}
