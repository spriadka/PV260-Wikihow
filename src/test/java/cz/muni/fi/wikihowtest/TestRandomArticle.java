package cz.muni.fi.wikihowtest;

import cz.muni.fi.wikihowtest.pageobject.MainPage;
import cz.muni.fi.wikihowtest.pageobject.RandomArticlePage;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class TestRandomArticle {
    private static WebDriver driver;
    private static MainPage mainPage;
    private static RandomArticlePage randomArticlePage;
    private static String baseUrl;

    @BeforeClass
    public static void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://www.wikihow.com/";
        mainPage = new MainPage(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testRandomArticle() throws Exception {
        driver.get(baseUrl + "/Main-Page");
        randomArticlePage = mainPage.getRandomArticlePage();
        assertTrue("Random article should contain steps",randomArticlePage.containsSteps());
        assertTrue("Random article should contain header",randomArticlePage.containsArticleHeader());
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.close();
    }

}
