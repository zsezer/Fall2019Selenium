package com.automation.test.day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class VerifyThatElementIsGone {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().version("79.0").setup();
        WebDriver driver= new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        Thread.sleep(2000);

        driver.findElement(By.id("disappearing_button"));
        Thread.sleep(2000);

        List<WebElement>list=driver.findElements(By.id("disappearing_button"));
        if(list.size()==0){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }
        Thread.sleep(2000);

        List<WebElement> buttons =driver.findElements( By.tagName("button"));
        for (WebElement button:buttons){
            button.click();
            Thread.sleep(2000);
        }
        driver.quit();
    }
}
