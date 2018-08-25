import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Common {

    public WebDriver getDriver() {
        return driver;
    }

    private static WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        driver.manage().window().maximize();
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
