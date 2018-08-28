package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverSingleton {

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        WebDriverSingleton.driver = driver;
    }

    public WebDriverSingleton() {

    }

    private static WebDriver driver;

    public static WebDriver getInstance() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            final ChromeOptions chromeOptions = options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
            setDriver(driver);
            driver.manage().window().maximize();
//            driver.get("https://www.tinkoff.ru");
        }
        return driver;
    }
}
