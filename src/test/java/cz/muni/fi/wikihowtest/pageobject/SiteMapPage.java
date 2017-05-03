package cz.muni.fi.wikihowtest.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SiteMapPage extends PageObject{

    @FindBy(id = "catentry")
    private List<WebElement> categories;

    public SiteMapPage(WebDriver driver) {
        super(driver);
    }

    public boolean containsText(String text){
        for (WebElement category : categories){
            if (category.getText().contains(text)){
                return true;
            }
        }
        return false;
    }
}
