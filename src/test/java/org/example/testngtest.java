package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class testngtest {
    @Test
    public void HelloWorld(){
        System.setProperty("webdriver.chrome.driver","C:\\drivers\\chrome\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://facebook.com");

        driver.quit();
    }
}
