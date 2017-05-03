package cz.muni.fi.wikihowtest.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SearchComponent extends PageObject {

    @FindBy(name = "search")
    private WebElement searchElement;

    @FindBy(id = "search_site_bubble")
    private WebElement searchBubbleElement;

    public SearchComponent(WebDriver driver) {
        super(driver);
    }

    public void click(){
        searchElement.click();
    }

    public void clear(){
        searchElement.clear();
    }

    public void typeText(String textToType){
        searchElement.sendKeys(textToType);
    }

    public String getValue(){
        return searchElement.getAttribute("value");
    }

    public boolean isInitialized(){
        return searchElement.isDisplayed() && searchBubbleElement.isDisplayed();
    }

    public SearchResultsPage submit(){
        searchBubbleElement.click();
        return new SearchResultsPage(driver);
    }
}
