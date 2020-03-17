package com.automation.test.warmup;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;

public class March4 {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
       ebayTest();
        //amazonTest();
      //wikiTest();
    }

    public static void ebayTest(){
        driver= DriverFactory.createADriver("chrome");
        driver.get("http://ebay.com");
        driver.findElement(By.id("gh-ac")).sendKeys("java book");
        driver.findElement(By.id("gh-btn")).click();
        WebElement searchResult= driver.findElement(By.tagName("h1"));
        String [] searchSentence= searchResult.getText().split(" ");
        System.out.println(Arrays.toString(searchSentence));
        System.out.println(searchSentence[0]);



        driver.quit();

    }
    public static void amazonTest() throws InterruptedException {
        driver= DriverFactory.createADriver("chrome");
        driver.get("http://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java books", Keys.ENTER);


        Thread.sleep(3000);
        String title=driver.getTitle();
        if(title.contains("java book")){
            System.out.println("Test Passed");
        }else{
            System.out.println("test failed");
        }
        driver.quit();
    }


    public static void wikiTest(){
        driver= DriverFactory.createADriver("chrome");
        driver.get("http://wikipedia.org/wiki/Main_Page");
        driver.findElement(By.id("searchInput")).sendKeys("Selenium (software)",Keys.ENTER);
        driver.findElement(By.partialLinkText("Selenium (software)")).click();
        String link=driver.getCurrentUrl();
        if(link.endsWith("Selenium_(software)")){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }

        driver.quit();

    }
}

