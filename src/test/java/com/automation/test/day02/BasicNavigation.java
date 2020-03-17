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
        driver.manage().window().maximize();//to maximize browser
        //driver.manage().window().fullscreen(); //make fullscreen
        Thread.sleep(3000);//for demo, wait 3 seconds
        String title= driver.getTitle();//returns <title>Some title</title> text
        String expectedTitle="Google";
        System.out.println("title = " + title);
        if(expectedTitle.equals(title)) {
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }
        driver.navigate().to("http://amazon.com");

        if(driver.getTitle().toLowerCase().contains("amazon")){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }
        //go back to Google
        driver.navigate().back();;
       // Thread.sleep(3000);//for demo, wait 3 seconds
        //to check if page title is equal to Google
        verifyEquals(driver.getTitle(),"Google");
        // to move forward in the browser history
        driver.navigate().forward();
       // Thread.sleep(3000);//for demo, wait 3 seconds
        System.out.println("Title = " + driver.getTitle());

        System.out.println("URL: " + driver.getCurrentUrl());
        driver.navigate().refresh();//to reload the page

        //must be at the end
        driver.close();// to close browser---browser close by itself

    }
    public static void verifyEquals(String arg1,String arg2){
        if(arg1.equals(arg2)){
                System.out.println("Test Passed");
            }else{
                System.out.println("Test Failed");
            }
        //come back to google


        }
    }
