package org.example;

import main.MainCalls;

import org.testng.annotations.Test;

import tests.base.Hooks;


import static driver.DriverFactory.getDriver;


public class MyDemoTestClass extends Hooks{



    @Test
    public void HelloWorld(){
        MainCalls.getFb_po().navigateTo_URL("https://google.com");
    }
}
