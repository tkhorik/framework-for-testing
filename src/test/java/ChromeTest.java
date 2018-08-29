import core.WebDriverSingleton;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.KommunalniePlatezhiPage;
import pages.MainPage;

public class ChromeTest {

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @After
    public void teardown() {
        WebDriverSingleton.getInstance().quit();
    }

    @Test
    public void sampleTest() {
        new MainPage()
//Шаг1
                .getUrl("https://www.tinkoff.ru")
//Шаг2
                .clickOnPaymentsButton()
//Шаг3
                .clickOnKommunalniePlatezhi()
                .selectRegion("Санкт-Петербург") //реализовано для демострации работоспособности условия переключения на московскии регион
                .veryfythatregionisCorrect("Москва")
//Шаг4
                .selectOnFirstElementAndStorItTextValue()
//Шаг5
                .selectPayInMoscowTab()
//Шаг6
                .pushTheButtonPayInMoscow()
//Шаг7
                .verifyInputPayerCodeError("Поле обязательное")
                .verifyInputPeriodError("Поле обязательное")
                .verifyInputSummaPlatejaError("Поле обязательное")
                .fillInputPayerCode("000000000")//.sendKeys("000000000")
                .fillInputPeriod("15.2018")//.sendKeys("15.2018")
                .fillInputSummaPlateja("5")//.sendKeys("5")
                .pushTheButtonPayInMoscow()
                .verifyInputPayerCodeError("Поле неправильно заполнено")
                .verifyInputPeriodError("Поле заполнено некорректно")
                .verifyInputSummaPlatejaError("Минимум — 10 \u20BD")
//Шаг8
                .clickOnPaymentsButton()
//Шаг9
                .fillSearchInput(new KommunalniePlatezhiPage().getValueFromStorage())
//Шаг10
                .clickOnSegestionLIstByInedex(1)
//Шаг11
//Шаг12
                .clickOnPaymentsButton()
                .clickOnKommunalniePlatezhi()
//Шаг13
                .selectRegion("Санкт-Петербург")
//Шаг14
                .maintTestVerification();
    }
}