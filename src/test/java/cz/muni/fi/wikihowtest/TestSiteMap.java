package cz.muni.fi.wikihowtest;

import cz.muni.fi.wikihowtest.pageobject.MainPage;
import cz.muni.fi.wikihowtest.pageobject.SiteMapPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertFalse;

public class TestSiteMap {

    private static WebDriver driver;
    private static MainPage mainPage;
    private static SiteMapPage siteMapPage;
    private static String baseUrl;

    @BeforeClass
    public static void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://www.wikihow.com/";
        mainPage = new MainPage(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void testSiteMapDoesNotContainPornography() throws Exception {
        driver.get(baseUrl);
        siteMapPage = mainPage.getSiteMapPage();
        assertFalse("Site map should not contain \"Pornography\" section", siteMapPage.containsText("Pornography"));
    }
}