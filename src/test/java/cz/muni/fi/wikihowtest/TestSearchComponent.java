package cz.muni.fi.wikihowtest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class TestSearchComponent {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://www.wikihow.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testSearchComponent() throws Exception {
        driver.get(baseUrl + "/Main-Page");
        driver.findElement(By.name("search")).click();
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys("windows");
        driver.findElement(By.id("search_site_bubble")).click();
        assertEquals("windows", driver.findElement(By.name("search")).getAttribute("value"));
        assertEquals(10, driver.findElements(By.xpath("//div[@id='searchresults_list']/div[contains(@class, 'result')]")).size());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}
