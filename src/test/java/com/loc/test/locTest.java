package com.loc.test;

import com.loc.HomePage;
import com.loc.base.BaseTest;
import com.loc.utils.Retry;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class locTest extends BaseTest {
    public String url = "https://www.loc.gov/";
    public HomePage homePage;

    @BeforeClass
    public void appSetup() {
        System.out.println("I'm inside before Class");
        homePage = new HomePage(this.driver);
    }

    @Test(groups = {"homepage"})
    public void checkHomeUrl() {
        homePage.launchSite(url);
        String currentUrl = homePage.getUrl();
        Assert.assertEquals(currentUrl, url);
    }

    @Test(groups = {"homepage"}, retryAnalyzer = Retry.class, priority = 1)
    public void checkCarrousel() throws InterruptedException {
        homePage.nextSlide();
        String paginationSliderNumber = homePage.getPaginationSlideNumber();
        Assert.assertEquals(paginationSliderNumber, "4/4");
    }

    @Test(groups = {"homepage"}, priority = 1)
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

    @Test(groups = {"homepage"}, dependsOnMethods = {"checkHomeUrl", "checkCarrousel", "checkTopSearches"})
    public void goToDigitalCollections() {
        homePage.goToDigitalCollections();
        String currentUrl = homePage.getUrl();
        Assert.assertEquals(currentUrl, "https://www.loc.gov/collections/");
    }

}
