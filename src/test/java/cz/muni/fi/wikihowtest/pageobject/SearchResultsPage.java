package cz.muni.fi.wikihowtest.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by spriadka on 5/3/17.
 */
public class SearchResultsPage extends PageObject {

    @FindBy(className = "result")
    private List<WebElement> resultElements;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }


    public int getResultsCount() {
        return resultElements.size();
    }


}
