package com.loc;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

public class BaseTest {

    protected WebDriver driver;
    protected SoftAssert softAssert;

    @BeforeSuite
    public void setup() {
        this.driver = WebDriverManager.edgedriver().create();
        this.softAssert = new SoftAssert();
    }

    @BeforeTest
    public void profileSetup() {
        driver.manage().window().maximize();
        System.out.println("The profile setup process is completed");

    }

    @AfterTest
    public void teardown() {
        this.driver.quit();
    }

}
