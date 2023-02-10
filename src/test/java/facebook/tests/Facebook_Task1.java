package facebook.tests;

import main.MainCalls;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.Hooks;
import utils.GlobalVars;

public class Facebook_Task1 extends Hooks {
    @Test
    public void LoginToFacebookAndPostStatus() {
        String status = "Hello World";

        MainCalls.getFb_po().navigateTo_URL(GlobalVars.FACEBOOK_BASEURL);
        MainCalls.getFb_po().login(GlobalVars.FACEBOOK_USERNAME,GlobalVars.FACEBOOK_PASSWORD);

        MainCalls.getFb_po().CheckFaceBookPage();

        MainCalls.getFb_po().postStatus(status);
        MainCalls.getFb_po().checkStatus(status);
        
    }
}
