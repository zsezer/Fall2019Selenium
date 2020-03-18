package com.automation.test.day05;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonTest {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        BrowserUtils.wait(2);

        WebElement blackButton = driver.findElement(By.id("black"));
        if (blackButton.isDisplayed() && blackButton.isEnabled()){
            System.out.println("Click on Black Button");
        blackButton.click();
    }else{
        System.out.println("Failed to click on Black Button");
    }
        BrowserUtils.wait(2);
        if(blackButton.isSelected()){
            System.out.println("Test Passed");
        }else{
            System.out.println("test failed");

        }

        driver.quit();
    }
}
