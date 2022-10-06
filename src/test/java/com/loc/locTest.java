package com.loc;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class locTest extends BaseTest {
    public String url = "https://www.loc.gov/";
    public HomePage homePage;
    public DigitalCollectionsPage digitalCollectionsPage;
    public SurveyPage surveyPage;

    @BeforeClass
    public void appSetup() {
        homePage = new HomePage(this.driver);
    }

    @Test
    public void checkHomeUrl() {
        homePage.launchSite(url);
        String currentUrl = homePage.getUrl();
        Assert.assertEquals(currentUrl, url);
    }

    @Test(retryAnalyzer = Retry.class, priority = 1)
    public void checkCarrousel() throws InterruptedException {
        homePage.nextSlide();
        String paginationSliderNumber = homePage.getPaginationSlideNumber();
        Assert.assertEquals(paginationSliderNumber, "4/4");
    }

    @Test(priority = 1)
    public void checkTopSearches() {
        boolean firstLink = homePage.checkTopLink1();
        softAssert.assertTrue(firstLink);

        boolean secondLink = homePage.checkTopLink2();
        softAssert.assertTrue(secondLink);

        boolean thirdLink = homePage.checkTopLink3();
        softAssert.assertTrue(thirdLink);

        boolean fourthLink = homePage.checkTopLink4();
        softAssert.assertTrue(fourthLink);

        boolean fifthLink = homePage.checkTopLink5();
        softAssert.assertTrue(fifthLink);

        boolean sixthLink = homePage.checkTopLink6();
        softAssert.assertTrue(sixthLink);

    }

    @Test(dependsOnMethods = {"checkHomeUrl", "checkCarrousel", "checkTopSearches"})
    public void goToDigitalCollections() {
        homePage.goToDigitalCollections();
        String currentUrl = homePage.getUrl();
        Assert.assertEquals(currentUrl, "https://www.loc.gov/collections/");
    }

}
