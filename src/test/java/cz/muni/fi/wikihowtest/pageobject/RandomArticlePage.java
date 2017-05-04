package cz.muni.fi.wikihowtest.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by spriadka on 5/3/17.
 */
public class RandomArticlePage extends PageObject {

    @FindBy(id = "article_info_header")
    private WebElement articleHeader;

    @FindBy(css = "div.step_num")
    private WebElement stepElement;

    public RandomArticlePage(WebDriver driver) {
        super(driver);
    }

    public boolean containsArticleHeader() {
        return articleHeader.isDisplayed();
    }

    public boolean containsSteps() {
        return stepElement.isDisplayed();
    }
}
