package com.automation.test.day06;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectByText {
    public static void main(String[] args) {

        WebDriver driver= DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        WebElement simpleDropdown = driver.findElement(By.id("dropdown"));
        //provide webelement object into constructor
        Select selectSimpleDropdown = new Select(simpleDropdown);
        //select by visible test
        selectSimpleDropdown.selectByVisibleText("Option 2");


        BrowserUtils.wait(3);

        driver.quit();
    }
}
