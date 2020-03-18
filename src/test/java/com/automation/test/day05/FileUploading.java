package com.automation.test.day05;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class FileUploading {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79.0").setup();
        WebDriver driver= new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/upload");
        BrowserUtils.wait(3);

        WebElement upload=driver.findElement(By.id("file-upload"));

        String filepath= System.getProperty("user.dir")+"/pom.xml";
        String filepath2= "/Users/SEZER/Desktop/Screen Shot 2019-11-12 at 5.25.02 PM.png";

        upload.sendKeys(filepath2);
        driver.findElement(By.id("file-submit")).click();

        BrowserUtils.wait(3);

        driver.quit();
        }
}
