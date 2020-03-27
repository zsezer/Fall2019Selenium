package com.automation.test.day12;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWait {
    private WebDriver driver;



    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createADriver("chrome");

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
    @Test
    public void waitDorTitle(){
        driver.get("http://google.com");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleContains("Google"));


    }

    @Test
    public void waitForVisibility(){

        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        WebDriverWait wait= new WebDriverWait(driver, 10 );

        driver.findElement(By.xpath("//button[text()='Start']")).click();
        WebElement username=driver.findElement(By.name("username"));
        WebElement password   =driver.findElement(By.name("password"));
        WebElement submitBtn=driver.findElement(By.cssSelector("button[type='submit']"));

        wait.until(ExpectedConditions.visibilityOf(username)).sendKeys("tomsmith");
        wait.until(ExpectedConditions.visibilityOf(password)).sendKeys("SuperSecretPassword");
        wait.until(ExpectedConditions.visibilityOf(submitBtn)).click();

        String expected ="Welcome to the Secure Area. When you are done click logout below.";
        String actual= driver.findElement(By.className("subheader")).getText();
        Assert.assertEquals(actual, expected);

    }
    @Test
    public void elementToBeClickableTest(){

        driver.get("http://practice.cybertekschool.com/dynamic_loading/5");

        WebDriverWait wait= new WebDriverWait(driver,15);

        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement submitBtn = driver.findElement(By.cssSelector("button[type='submit']"));

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loadingoverlay")));
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        username.sendKeys("tomsmith");
        password.sendKeys("SuperSecretPassword");
        submitBtn.click();
        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.className("subheader")).getText();
        Assert.assertEquals(actual, expected);
    }



}
