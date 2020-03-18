package com.automation.test.day06;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MultiSelection {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver= new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);

        Select languageSelect = new Select(driver.findElement(By.name("Languages")));

        boolean isMultiple=languageSelect.isMultiple();
        System.out.println(isMultiple);

        languageSelect.selectByVisibleText("Java");
        languageSelect.selectByVisibleText("JavaScript");
        languageSelect.selectByVisibleText("Python");

        List<WebElement> selectedLanguages= languageSelect.getAllSelectedOptions();

       for(WebElement selectedLanguage:selectedLanguages){
           System.out.println(selectedLanguage.getText());
       }

       languageSelect.deselectByVisibleText("Java");//to unselect something


        BrowserUtils.wait(3);

        driver.quit();

    }
}
