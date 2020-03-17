package com.automation.test.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver= new ChromeDriver();

        driver.get("http://google.com");

        Thread.sleep(2000);
        //By.name("q")---> name="q"
        WebElement search= driver.findElement(By.name("q"));
        //when we found an element, how to enter text?
        //to enter keys, use sendKey() method
        //how to press Enter after entering text?
        //use Key.ENTER
        search.sendKeys("Java", Keys.ENTER);
        Thread.sleep(2000);

        WebElement news=driver.findElement(By.linkText("News"));
        news.click();
        Thread.sleep(2000);
        driver.quit();

    }
}
