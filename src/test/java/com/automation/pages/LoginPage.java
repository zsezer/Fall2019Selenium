package com.automation.pages;

import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(id="prependedInput")
    public WebElement username; // version 1

   // public WebElement username2=Driver.getDriver().findElement(By.id(prependendInput)); //version 2

    @FindBy(id="prependedInput2")
    public WebElement password;

    @FindBy(id="_submit")
    public WebElement login;


    @FindBy(linkText = "Forgot your password?")
    public WebElement forgotPassword;
    public LoginPage(){
        //to connect our webdriver, page class and page factory
        //pageFactory-used to use @FindBy annotations
        //pageFactory-helps to find elements easier

        PageFactory.initElements(Driver.getDriver(), this);  //this or LoginPage.class

    }
    //login as a specific user
    public void setLogin(String usernameValue, String passwordValue){
     username.sendKeys(usernameValue);
     password.sendKeys(passwordValue,Keys.ENTER);
    }

    //login as a default user
    public void login(){
        username.sendKeys(ConfigurationReader.getProperty("store_manager"));
        password.sendKeys(ConfigurationReader.getProperty("password"), Keys.ENTER);
    }
}
