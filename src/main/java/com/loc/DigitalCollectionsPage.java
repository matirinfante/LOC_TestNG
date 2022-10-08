package com.loc;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DigitalCollectionsPage extends BasePage {

    @FindBy(xpath = "//header[@class='collections-header']/h1")
    WebElement pDigitalCollectionHeader;

    @FindBy(id = "search")
    WebElement pSearchInput;

    @FindBy(xpath = "//div[@class='item-description']//span[@class='item-description-abstract']")
    WebElement pFirstItemDescription;

    public DigitalCollectionsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getCollectionsHeader() {
        return getText(pDigitalCollectionHeader);
    }

    public void searchKeyword(String searchText) {
        type(pSearchInput, searchText);
        typeKey(pSearchInput, Keys.ENTER);
        clear(pSearchInput);
    }

    public boolean verifySearchResult(String searchText) {
        return getText(pFirstItemDescription).contains(searchText);
    }
}
