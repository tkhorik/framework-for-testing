import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

/*
https://www.swtestacademy.com/allure-testng/ allure implementation
* */

public class ChromeTest {

    private WebDriver driver;

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


    @Test
    public void sampleTest() {
        MainPage mp = new MainPage(driver);
        mp.requestInput.getText();
        mp.search("yandex");
        mp.searchButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(visibilityOf(mp.searchButton));
        // Some assertion here
    }
}