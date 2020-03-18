package com.automation.test.day06;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectByIndex {
    public static void main(String[] args) {

        WebDriver driver= DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);

        Select stateSelect= new Select(driver.findElement(By.id("state")));

        stateSelect.selectByIndex(9);
        String expected = "District of Columbia";
        String actual = stateSelect.getFirstSelectedOption().getText();
        //Select last option
        stateSelect.selectByIndex(stateSelect.getOptions().size()-1);

        if (expected.equals(actual)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Passed");
        }







        BrowserUtils.wait(2);
        driver.quit();

    }
}
