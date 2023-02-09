package org.example;

import main.MainCalls;

import org.testng.annotations.Test;

import tests.base.Hooks;
import utils.GlobalVars;


import static driver.DriverFactory.getDriver;


public class MyDemoTestClass extends Hooks{



    @Test
    public void LoginToFb(){
        //MainCalls.getFb_po().navigateTo_URL(GlobalVars.FACEBOOK_BASEURL);
        //MainCalls.getFb_po().enterEmail(GlobalVars.FACEBOOK_USERNAME);
        //MainCalls.getFb_po().enterPassword(GlobalVars.FACEBOOK_PASSWORD);

        //MainCalls.getFb_po().clickLogin();
    }
}
