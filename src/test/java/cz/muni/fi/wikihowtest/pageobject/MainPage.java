package cz.muni.fi.wikihowtest.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by spriadka on 5/3/17.
 */
public class MainPage extends PageObject{

    @FindBy(linkText = "Site map")
    private WebElement siteMapLink;

    @FindBy(id = "gatRandom")
    private WebElement randomArticle;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public SiteMapPage getSiteMapPage(){
        siteMapLink.click();
        return new SiteMapPage(driver);
    }

    public RandomArticlePage getRandomArticlePage(){
        randomArticle.click();
        return new RandomArticlePage(driver);
    }

    public SearchComponent getSearchComponent(){
        return new SearchComponent(driver);
    }
}
