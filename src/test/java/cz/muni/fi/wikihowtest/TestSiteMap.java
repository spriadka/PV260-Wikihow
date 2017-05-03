package cz.muni.fi.wikihowtest;

import java.util.concurrent.TimeUnit;

import cz.muni.fi.wikihowtest.pageobject.MainPage;
import cz.muni.fi.wikihowtest.pageobject.SiteMapPage;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSiteMap {

    private static WebDriver driver;
    private static MainPage mainPage;
    private static SiteMapPage siteMapPage;
    private final String baseUrl = "http://www.wikihow.com";

    @BeforeClass
    public static void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        mainPage = new MainPage(driver);
    }

    @Test
    public void testSiteMapDoesNotContainPornography() throws Exception {
        driver.get(baseUrl);
        siteMapPage = mainPage.getSiteMapPage();
        assertFalse("Site map should not contain \"Pornography\" section",siteMapPage.containsText("Pornography"));
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.close();
    }
}