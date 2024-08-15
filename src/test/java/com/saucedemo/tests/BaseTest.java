package com.saucedemo.tests;

import com.saucedemo.config.ConfigReader;
import com.saucedemo.config.TestSettings;
import com.saucedemo.driver.DriverFactory;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class BaseTest {
    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected TestSettings testSettings;

    @BeforeMethod
    public void setup() {
        testSettings = ConfigReader.getTestSettings("src/main/resources/appSettings.json");
        WebDriver driver = DriverFactory.initializeDriver(testSettings);
        setDriver(driver);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        WebDriver driver = getDriver();
        if (driver != null) {
            try {
                String testCaseName = result.getMethod().getMethodName();
                String screenshotPath = "screenshots/" + testCaseName + ".png";
                File destFile = new File(screenshotPath);
                takeScreenshot(destFile);
            } catch (Exception e) {
                System.out.println("Failed to take screenshot: " + e.getMessage());
            } finally {
                driver.quit();
            }
        }
    }

    public void setDriver(WebDriver driver) {
        this.driver.set(driver);
    }

    public WebDriver getDriver() {
        return this.driver.get();
    }

    public void takeScreenshot(File destFile) {
        WebDriver driver = getDriver();
        if (driver != null) {
            try {
                File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(file, destFile);
                try (InputStream is = new FileInputStream(destFile)) {
                    Allure.addAttachment("Screenshot", is);
                }
            } catch (IOException | WebDriverException e) {
                System.out.println("Failed to take or save screenshot: " + e.getMessage());
            }
        }
    }

}
