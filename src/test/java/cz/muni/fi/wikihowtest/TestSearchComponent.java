package cz.muni.fi.wikihowtest;

import cz.muni.fi.wikihowtest.pageobject.MainPage;
import cz.muni.fi.wikihowtest.pageobject.SearchComponent;
import cz.muni.fi.wikihowtest.pageobject.SearchResultsPage;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestSearchComponent {
    private static WebDriver driver;
    private static MainPage mainPage;
    private static SearchComponent searchComponent;
    private static SearchResultsPage resultsPage;
    private static String baseUrl;

    @BeforeClass
    public static void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://www.wikihow.com/";
        mainPage = new MainPage(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testSearchComponent() throws Exception {
        driver.get(baseUrl + "/Main-Page");
        searchComponent = mainPage.getSearchComponent();
        assertTrue("Search bar is displayed",searchComponent.isInitialized());
        searchComponent.click();
        searchComponent.clear();
        searchComponent.typeText("windows");
        assertEquals("windows", searchComponent.getValue());
        resultsPage = searchComponent.submit();
        assertEquals(10, resultsPage.getResultsCount());
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.close();
    }

}
