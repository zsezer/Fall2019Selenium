package com.automation.test.day05;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckboxesTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79.0").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/checkboxes");
        BrowserUtils.wait(2);

        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));

        if(!checkBoxes.get(0).isSelected() && checkBoxes.get(1).isSelected()){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }
        BrowserUtils.wait(2);
        //Way #1
        //checkBoxes.get(0).click();
        //Way #2
        WebElement checkbox1=checkBoxes.get(0);
        checkbox1.click();

        if(checkbox1.isSelected()){
            System.out.println("Test Passed");
            System.out.println("checkbox #1 is selected ");
        }else{
            System.out.println("Test Failed");
            System.out.println("checkbox #1 is not selected ");
        }

        driver.quit();
    }
}