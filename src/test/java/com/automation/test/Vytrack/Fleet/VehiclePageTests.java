package com.automation.test.Vytrack.Fleet;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VehiclePageTests {

    private WebDriver driver;
    private String URL="https://qa2.vytrack.com/user/login";
    private By usernameBy=By.id("prependedInput");
    private By passwordBy=By.id("prependedInput2");
    private By fleetBy=By.xpath("//span[@class='title title-level-1' and contains(text(),'Fleet')]");
    private By subTitleBy=By.className("oro-subtitle");
    private String username="storemanager85";
    private String password="UserUser123";



    @Test
    public void verifyPageSubTitle(){
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(3);

        //driver.findElement(fleetBy).click();
        Actions actions= new Actions(driver);
        actions.moveToElement(driver.findElement(fleetBy)).perform();

        BrowserUtils.wait(3);
        driver.findElement(By.linkText("Vehicles")).click();
        BrowserUtils.wait(3);

        WebElement subTitleElement=driver.findElement(subTitleBy);
        System.out.println(subTitleElement.getText());

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
