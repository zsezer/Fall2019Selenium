package com.automation.test.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) throws InterruptedException {
        //to start selenium script we need:
        //setup webdriver (browser driver) and create webdriver object

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //in selenium everything starts from WebDriver Interface
        driver.get("http://google.com"); //to open website
        Thread.sleep(3000);//for demo, wait 3 seconds
        String title= driver.getTitle();//returns <title>Some title</title> text
        String expectedTitle="Google";
        System.out.println("title = " + title);
        if(expectedTitle.equals(title)) {
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }

        driver.close();// to close browser---browser close by itself



    }
}
