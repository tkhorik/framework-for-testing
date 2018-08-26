import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
        //WebDriverManager.chromedriver().setup(); //-for automatic driver download
        String projectPath = System.getProperty("user.dir");
        System.out.println("projectPath : " + projectPath);
        System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
    }

    @Before
    public void setupTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.get("https://www.tinkoff.ru");
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
        mp.paymentsButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(visibilityOf(mp.requestInput));
    }
    @Test
    public void sampleTest2() {
        MainPage mp = new MainPage(driver);
        mp.paymentsButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(visibilityOf(mp.requestInput));
    }
}