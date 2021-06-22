package com.featuretesting;


import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


public class DriverClass {

    WebDriver driver;
      static  final Logger Log = Logger.getLogger(DriverClass.class.getName());
      DriverClass()
      {
          DOMConfigurator.configure("log4j.xml");
      }

    public WebDriver setUp(String driverType, WebDriver driver) {

        if (driverType.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Drivers\\chromedriver.exe");
            driver = new ChromeDriver();
            Log.info("Chrome Driver Initialized");
        } else if (driverType.equals("edge")) {
            System.setProperty("webdriver.edge.driver", "C:\\Users\\Lenovo\\Drivers\\msedgedriver.exe");
            driver = new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;

    }

    @BeforeMethod(alwaysRun = true)
    public void initialize() {

        driver = setUp("Chrome", driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws InterruptedException {
        driver.quit();
        Thread.sleep(5000);
    }


}


