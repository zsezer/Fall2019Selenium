package com.automation.test.day07;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.WebDriver;

public class Xpath {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/login");
        BrowserUtils.wait(3);




        BrowserUtils.wait(2);
        driver.quit();
    }
}
