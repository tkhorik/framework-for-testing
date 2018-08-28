package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverSingleton2 {

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    //    private static ThreadLocal<WebDriver> driver;
    private static WebDriver driver;

    private WebDriverSingleton2() {
    }

    //    public static WebDriver getInstance() {
//        if (driver.get() == null) {
    public static WebDriver getInstance() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            final ChromeOptions chromeOptions = options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
            driver.get("https://www.tinkoff.ru");
            driver.manage().window().maximize();
        }
        return driver;
    }
}