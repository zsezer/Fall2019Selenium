package com.automation.test.day06;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByText {
    public static void main(String[] args) {

        WebDriver driver= DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        WebElement simpleDropdown = driver.findElement(By.id("dropdown"));
        //provide webelement object into constructor
        Select selectSimpleDropdown = new Select(simpleDropdown);
        //select by visible test
        selectSimpleDropdown.selectByVisibleText("Option 2");


        BrowserUtils.wait(3);
        selectSimpleDropdown.selectByVisibleText("Option 1");

        Select selectYear = new Select(driver.findElement(By.id("year")));
        Select selectMonth = new Select(driver.findElement(By.id("month")));
        Select selectDay = new Select(driver.findElement(By.id("day")));

        selectYear.selectByVisibleText("1986");
        selectMonth.selectByVisibleText("October");
        selectDay.selectByVisibleText("4");

        //select all months one by one

        /*List<WebElement>months=selectMonth.getOptions();
        for(WebElement month:months){
            selectMonth.selectByVisibleText(month.getText());
            BrowserUtils.wait(1);
        }

*/
        Select stateSelect= new Select(driver.findElement(By.id("state")));
        stateSelect.selectByVisibleText("Arkansas");

        String selected= stateSelect.getFirstSelectedOption().getText();

        List<WebElement>states=stateSelect.getOptions();
        for(WebElement state:states){
            System.out.println(state.getText());
        }

        if(selected.equals("Arkansas")){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed ");
        }

        BrowserUtils.wait(3);

        driver.quit();
    }
}
