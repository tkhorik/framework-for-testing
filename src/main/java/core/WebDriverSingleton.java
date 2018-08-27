package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverSingleton {

    private static WebDriver driver;

    private WebDriverSingleton(){}

    public static WebDriver getInstance() {
        if (driver == null) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.get("https://www.tinkoff.ru");
        driver.manage().window().maximize();
        }
        return driver;
    }

    public static void close(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }
}
