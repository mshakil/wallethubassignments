package org.example;

import main.MainCalls;

import org.testng.annotations.Test;

import tests.base.Hooks;
import utils.GlobalVars;


import static driver.DriverFactory.getDriver;


public class MyDemoTestClass extends Hooks{



    @Test
    public void HelloWorld(){
        MainCalls.getFb_po().navigateTo_URL(GlobalVars.FACEBOOK_BASEURL);
        System.out.println(GlobalVars.FACEBOOK_USERNAME);
        System.out.println(GlobalVars.WEBDRIVER_DEFAULT_EXPLICIT_TIMEOUT);
        System.out.println(GlobalVars.FACEBOOK_BASEURL);
        System.out.println(GlobalVars.FACEBOOK_PASSWORD);
    }
}
