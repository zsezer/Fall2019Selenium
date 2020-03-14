package com.automation.test.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) {
        //to start selenium script we need:
        //setup webdriver (browser driver) and create webdriver object

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //in selenium everything starts from WebDriver Interface
         driver.get("http://google.com"); //to open website


    }
}
