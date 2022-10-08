package com.loc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SurveyPage extends BasePage {

    @FindBy(className = "title-text")
    WebElement pSurveyTitle;

    @FindBy(xpath = "//h4[contains(@class,'question-title-container')]")
    List<WebElement> pQuestionTitles;

    @FindBy(xpath = "//span[@class='question-number notranslate' and contains(text(),' 1')]//ancestor::fieldset//input[@class='radio-button-input ']")
    List<WebElement> pFirstQuestionRadios;
    @FindBy(xpath = "//span[@class='question-number notranslate' and contains(text(),' 3')]//ancestor::fieldset//input[@class='radio-button-input ']")
    List<WebElement> pSecondQuestionRadios;
    @FindBy(xpath = "//span[@class='question-number notranslate' and contains(text(),' 2')]//ancestor::fieldset//input[@class='radio-button-input ']")
    List<WebElement> pThirdQuestionRadios;
    @FindBy(xpath = "//button[contains(text(),'Finish Survey')]")
    WebElement pBtnFinishSurvey;

    @FindBy(xpath = "//div[contains(@class,'thanks-message')]")
    WebElement pTxtThanks;

    public SurveyPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return getText(pSurveyTitle);
    }

    public int checkQuestionNumber() {
        waitForVisibility(pQuestionTitles);
        return pQuestionTitles.size();
    }

    public boolean selectFirstRadioOption(int index) {
        clickOnRadioByIndex(pFirstQuestionRadios, index);
        return checkSelected(pFirstQuestionRadios, index);
    }

    public boolean selectSecondRadioOption(int index) {
        clickOnRadioByIndex(pSecondQuestionRadios, index);
        return checkSelected(pSecondQuestionRadios, index);

    }

    public boolean selectThirdRadioOption(int index) {
        clickOnRadioByIndex(pThirdQuestionRadios, index);
        return checkSelected(pThirdQuestionRadios, index);

    }

    public void submitSurvey() {
        click(pBtnFinishSurvey);
    }

    public String getFeedback() {
        waitForVisibility(pTxtThanks);
        return getText(pTxtThanks);
    }


}
