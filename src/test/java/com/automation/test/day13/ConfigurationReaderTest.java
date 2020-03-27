package com.automation.test.day13;

import com.automation.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class ConfigurationReaderTest {

    @Test
    public void readProperties(){
        String browser = ConfigurationReader.getProperty("browser");
        System.out.println(browser);

        String url= ConfigurationReader.getProperty("qa1");
        System.out.println(url);


    }
}
