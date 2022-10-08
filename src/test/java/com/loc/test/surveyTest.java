package com.loc.test;

import com.loc.DigitalCollectionsPage;
import com.loc.HomePage;
import com.loc.SurveyPage;
import com.loc.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class surveyTest extends BaseTest {
    public HomePage homePage;
    public SurveyPage surveyPage;

    @BeforeClass
    public void appSetup() {
        homePage = new HomePage(driver);
        surveyPage = new SurveyPage(driver);
    }

    @Test(priority = -1, groups = {"survey"})
    public void launchSite() {
        homePage.launchSite("https://www.loc.gov");
    }

    @Test(groups = {"survey"})
    public void goToSurvey() {
        homePage.scrollToSurveyLink();
        homePage.clickSurvey();
    }

    @Test(dependsOnMethods = {"goToSurvey"}, groups = {"survey"})
    public void checkSurveyTitle() {
        String surveyTitle = surveyPage.getTitle();
        Assert.assertEquals(surveyTitle, "Library of Congress Web Site Survey");
    }

    @Test(dataProvider = "questionTotalNumber", groups = {"survey"}, dependsOnMethods = {"checkSurveyTitle"})
    public void checkQuestions(int numberOfQuestions) {
        int questionTotal = surveyPage.checkQuestionNumber();
        Assert.assertEquals(questionTotal, numberOfQuestions);
    }

    @Test(dataProvider = "radioAnswers", dependsOnMethods = {"checkQuestions"}, groups = {"survey"})
    public void fillQuestions(int firstAnswer, int secondAnswer, int thirdAnswer) {
        boolean checkSelectedFirst = surveyPage.selectFirstRadioOption(firstAnswer);
        Assert.assertTrue(checkSelectedFirst);
        boolean checkSelectedSecond = surveyPage.selectSecondRadioOption(secondAnswer);
        Assert.assertTrue(checkSelectedSecond);
        boolean checkSelectedThird = surveyPage.selectThirdRadioOption(thirdAnswer);
        Assert.assertTrue(checkSelectedThird);
    }

    @Test(dependsOnMethods = {"fillQuestions"}, dataProvider = "feedbackText", groups = {"survey"})
    public void submitSurveyAndCheck(String expectedFeedbackText) {
        surveyPage.submitSurvey();
        String feedbackText = surveyPage.getFeedback();
        softAssert.assertEquals(feedbackText, expectedFeedbackText);
    }

    @DataProvider
    public Object[][] questionTotalNumber() {
        return new Object[][]{{3}};
    }

    @DataProvider
    public Object[][] radioAnswers() {
        return new Object[][]{{2, 3, 2}};
    }

    @DataProvider
    public Object[][] feedbackText() {
        return new Object[][]{{"Thank you for providing feedback on the Library of Congress web site! Click \"finish survey\" to redirected to www.loc.gov, or simply close this page to exit."}};
    }
}
