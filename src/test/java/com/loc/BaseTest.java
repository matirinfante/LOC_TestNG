package com.loc;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

public class BaseTest {

    protected WebDriver driver;
    protected SoftAssert softAssert;

    @BeforeTest
    public void setup() {
        this.driver = WebDriverManager.edgedriver().create();
        this.driver.manage().window().maximize();
        this.softAssert = new SoftAssert();
    }

    @AfterTest
    public void teardown() {
        this.driver.quit();
    }

}
