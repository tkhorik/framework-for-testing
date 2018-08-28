import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.BeforeClass;

import static core.WebDriverSingleton2.getInstance;

public class Common {
    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }


    @After
    public void teardown() {
        if (getInstance() != null) {
            getInstance().quit();
        }
    }
}
