package com.loc.test;

import com.loc.DigitalCollectionsPage;
import com.loc.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class digitalCollectionsTest extends BaseTest {

    public DigitalCollectionsPage digitalCollectionsPage;

    @BeforeClass
    public void appSetup() {
        digitalCollectionsPage = new DigitalCollectionsPage(driver);
    }

    @Test(groups = {"digitalcollections"}, dependsOnGroups = {"homepage"})
    public void checkTitle() {
        String title = digitalCollectionsPage.getCollectionsHeader();
        Assert.assertEquals(title, "Digital Collections");
    }

    @Test(dataProvider = "searchTexts", groups = {"digitalcollections"}, dependsOnGroups = {"homepage"})
    public void searchTest(String searchKeyword) {
        digitalCollectionsPage.searchKeyword(searchKeyword);
        boolean checkResult = digitalCollectionsPage.verifySearchResult(searchKeyword);
        softAssert.assertTrue(checkResult, "Results present but presumable not match with search keyword");
    }

    @DataProvider
    public Object[][] searchTexts() {
        return new Object[][]{{"Abraham Lincoln"}, {"Benjamin Franklin Papers"}, {"Earth Day"}};
    }

}
