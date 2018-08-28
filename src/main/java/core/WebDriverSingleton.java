package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverSingleton {

    private WebDriverSingleton() {
    }

    public static WebDriver getDriver() {
        return driver;
    }

    private static void setDriver(WebDriver driver) {
        WebDriverSingleton.driver = driver;
    }

    private static WebDriver driver;

    public static WebDriver getInstance() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            ChromeOptions chromeOptions = options.addArguments("--disable-notifications");
            driver = new ChromeDriver(chromeOptions);
            setDriver(driver);
            driver.manage().window().maximize();
        }
        return driver;
    }
}
