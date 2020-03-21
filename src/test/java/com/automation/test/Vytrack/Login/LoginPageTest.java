package com.automation.test.Vytrack.Login;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;



public class LoginPageTest {
    private WebDriver driver;
    private String URL="https://qa2.vytrack.com/user/login";
    private By usernameBy=By.id("prependedInput");
    private By passwordBy=By.id("prependedInput2");
    private By warningMessageBy=By.cssSelector("[class='alert alert-error']>div");
    private String username="storemanager85";
    private String password="UserUser123";

    @Test(description = "verify that warning message displays when user enters invalid username")
    public void invalidUsername(){
        driver.findElement(usernameBy).sendKeys("invalidusername");
        driver.findElement(passwordBy).sendKeys("UserUser123", Keys.ENTER);
        BrowserUtils.wait(3);
        WebElement warningElement=driver.findElement(warningMessageBy);

        assertTrue(warningElement.isDisplayed());

    }
    @Test
    public void loginAsStoreManager(){
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password,Keys.ENTER);

        BrowserUtils.wait(3);
        String actual="Dashboard";
        String expected=driver.getTitle();

        assertEquals(actual, expected, "Page title is not correct!");

    }


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver= new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void teardown(){

        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }


}
