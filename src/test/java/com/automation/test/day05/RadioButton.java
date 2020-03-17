package com.automation.test.day05;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RadioButton {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().version("79.0").setup();

        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        driver.manage().window().maximize();
        BrowserUtils.wait(2);

        List<WebElement> radioButtons = driver.findElements(By.tagName("input"));

        for (WebElement radioButton : radioButtons){
            String id=radioButton.getAttribute("id");
            boolean isSelected= radioButton.isSelected();
            System.out.println(id+" is selected? "+isSelected);
            if (radioButton.isEnabled()) {
                radioButton.click();
                System.out.println("clicked on: " + id);
                BrowserUtils.wait(1);

            }else{
                System.out.println("Button is disabled, not clicked : "+id);


        }
    }
        driver.quit();
}
}