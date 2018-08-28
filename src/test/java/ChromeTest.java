import core.WebDriverSingleton;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.KommunalniePlatezhiPage;
import pages.MainPage;
import pages.PaymentsPage;
import pages.ZhkuMoskvaPage;

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
        MainPage mp = new MainPage();
        mp.getUrl("https://www.tinkoff.ru");
        mp.clickOnPaymentsButton()
                .clickOnKommunalniePlatezhi()
                .selectRegion("Санкт-Петербург") //реализовано для демострации работоспособности условия переключения на московскии регион
                .veryfythatregionisCorrect("Москва")
                .selectOnFirstElementAndStorItTextValue();

        ZhkuMoskvaPage zhku = new ZhkuMoskvaPage();
        zhku.payInMoscowTab.click();
        zhku.payInMoscowTab.click();
        zhku.pushTheButtonPayInMoscow();

        Assert.assertEquals("Поле обязательное", zhku.inputPayerCodeError.getText());
        Assert.assertEquals("Поле обязательное", zhku.inputPeriodError.getText());
        Assert.assertEquals("Поле обязательное", zhku.inputSummaPlatejaError.getText());
        zhku.inputPayerCode.click();
        zhku.inputPayerCode.sendKeys("000000000");
        zhku.inputPeriod.click();
        zhku.inputPeriod.sendKeys("15.2018");
        zhku.inputSummaPlateja.sendKeys("5");
        zhku.pushTheButtonPayInMoscow();

        Assert.assertEquals("Поле неправильно заполнено", zhku.inputPayerCodeError.getText());
        Assert.assertEquals("Поле заполнено некорректно", zhku.inputPeriodError.getText());
        Assert.assertEquals("Минимум — 10 \u20BD", zhku.inputSummaPlatejaError.getText());

        mp.clickOnPaymentsButton();
        PaymentsPage pp = new PaymentsPage();
        KommunalniePlatezhiPage kp = new KommunalniePlatezhiPage();
        pp.searchInput.sendKeys(kp.getValueFromStorage());
        pp.clickOnSegestionLIstByInedex(1);

        mp.clickOnPaymentsButton()
                .clickOnKommunalniePlatezhi()
                .selectRegion("Санкт-Петербург");
        Assert.assertNotEquals(kp.firstElementUILayoutSection.getText(), kp.getValueFromStorage(), "Ошибка");
    }
}