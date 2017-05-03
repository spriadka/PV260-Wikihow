package cz.muni.fi.wikihowtest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class TestRandomArticle {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://www.wikihow.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testRandomArticle() throws Exception {
        driver.get(baseUrl + "/Main-Page");
        driver.findElement(By.id("gatRandom")).click();
        assertTrue(isElementPresent(By.cssSelector("div.step_num")));
        assertTrue(isElementPresent(By.id("article_info_header")));
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
