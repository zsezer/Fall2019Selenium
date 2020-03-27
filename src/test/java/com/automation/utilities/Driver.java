package com.automation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    private static WebDriver driver;

    //no one can create object of Driver class
    //everyone should call static method instead

    private Driver(){

    }
    public static WebDriver getDriver(){

        if(driver==null) {
            String browser = ConfigurationReader.getProperty("browser");
            switch (browser)
            {
                case"chrome":
                    WebDriverManager.chromedriver().version("79").setup();
                    driver=new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                default:
                    throw new RuntimeException("wrong browser name!");

            }
        }
        return driver;

    }

    public static void closeDriver(){
        if(driver!=null){
            driver.quit();
            driver=null;

        }
    }
}
