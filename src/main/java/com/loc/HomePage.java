package com.loc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//button[@class='slick-next slick-arrow']")
    WebElement pBtnNextSlide;
    @FindBy(xpath = "//div[contains(@class,'slick-active')]//div[@class='paging-info']")
    WebElement pLblPaginationSlideNumber;

    @FindBy(id = "top_searches_1")
    WebElement pTopLink1;
    @FindBy(id = "top_searches_2")
    WebElement pTopLink2;
    @FindBy(id = "top_searches_3")
    WebElement pTopLink3;
    @FindBy(id = "top_searches_4")
    WebElement pTopLink4;
    @FindBy(id = "top_searches_5")
    WebElement pTopLink5;
    @FindBy(id = "top_searches_6")
    WebElement pTopLink6;

    @FindBy(xpath = "//a[contains(text(),'Digital Collections')]")
    WebElement pDigitalCollectionsLink;

    @FindBy(xpath = "//li[@class='footer-social-link-survey']/a")
    WebElement pTakeSurveyLink;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this
        );
    }

    public void launchSite(String url) {
        visit(url);
    }

    public void nextSlide() throws InterruptedException {
        click(pBtnNextSlide);
        Thread.sleep(500);
    }

    public String getPaginationSlideNumber() {
        return getText(pLblPaginationSlideNumber);
    }

    public boolean checkTopLink1() {
        String linkHref = getHref(pTopLink1);
        String linkText = getText(pTopLink1);
        return linkText.equals("/search/?q=" + linkText.toLowerCase());
    }

    public boolean checkTopLink2() {
        String linkHref = getHref(pTopLink2);
        String linkText = getText(pTopLink2);
        return linkText.equals("/search/?q=" + linkText.toLowerCase());
    }

    public boolean checkTopLink3() {
        String linkHref = getHref(pTopLink3);
        String linkText = getText(pTopLink3);
        return linkText.equals("/search/?q=" + linkText.toLowerCase());
    }

    public boolean checkTopLink4() {
        String linkHref = getHref(pTopLink4);
        String linkText = getText(pTopLink4);
        return linkText.equals("/search/?q=" + linkText.toLowerCase());
    }

    public boolean checkTopLink5() {
        String linkHref = getHref(pTopLink5);
        String linkText = getText(pTopLink5);
        return linkText.equals("/search/?q=" + linkText.toLowerCase());
    }

    public boolean checkTopLink6() {
        String linkHref = getHref(pTopLink6);
        String linkText = getText(pTopLink6);
        return linkText.equals("/search/?q=" + linkText.toLowerCase());
    }

    public void goToDigitalCollections() {
        click(pDigitalCollectionsLink
        );
    }

    public void scrollToSurveyLink() {
        scrollToElement(pTakeSurveyLink);
    }

    public void clickSurvey() {
        click(pTakeSurveyLink);
    }
}
