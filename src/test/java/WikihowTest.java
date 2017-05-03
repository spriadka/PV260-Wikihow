import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WikihowTest {

    private WebDriver driver;
    private final String baseUrl = "http://www.wikihow.com";
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver","/home/spriadka/Apps/gecko/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testCase() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.linkText("Site map")).click();
        // Warning: assertTextNotPresent may require manual changes
        assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Pornography[\\s\\S]*$"));
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}