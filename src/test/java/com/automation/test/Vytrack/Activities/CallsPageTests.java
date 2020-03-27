package com.automation.test.Vytrack.Activities;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CallsPageTests{

    private By usernameBy= By.id("prependedInput");
    private By passwordBy= By.id("prependedInput2");
    private By activitiesBy=By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]");
    private By logCallBtnBy=By.cssSelector("a[title='Log call']");
    private WebDriver driver;
    private Actions actions;


    private String storeManagerUsername="storemanager85";
    private String storeManagerPassword="UserUser123";



@BeforeMethod
public void setup(){

    driver= DriverFactory.createADriver("chrome");
    driver.get("https://qa2.vytrack.com/user/login");
    driver.manage().window().maximize();
    actions=new Actions(driver);
    BrowserUtils.wait(3);
    driver.findElement(usernameBy).sendKeys(storeManagerUsername);
    driver.findElement(passwordBy).sendKeys(storeManagerPassword, Keys.ENTER);

    BrowserUtils.wait(3);
    //hover over activities
    actions.moveToElement(driver.findElement(activitiesBy)).perform();
    BrowserUtils.wait(2);
    driver.findElement(By.linkText("Calls")).click();
    BrowserUtils.wait(3);
}

@Test
    public void verifyLogCallButton(){
    WebElement logCallBtnElement=driver.findElement(logCallBtnBy);
    Assert.assertTrue(logCallBtnElement.isDisplayed());

}
@AfterMethod
    public void teardown(){
    driver.quit();
}
}
