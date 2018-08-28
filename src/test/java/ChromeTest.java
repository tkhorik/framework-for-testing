import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.MainPage;
import pages.PaymentsPage;
import pages.ZhkuMoskvaPage;

/*
https://www.swtestacademy.com/allure-testng/ allure implementation
* */

public class ChromeTest {

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @After
    public void teardown() {
//            WebDriverSingleton.getInstance().quit();
    }

    @Test
    public void sampleTest() {
        MainPage mp = new MainPage();
        mp.clickOnPaymentsButton()
                .clickOnKommunalniePlatezhi()
                .selectRegion("Санкт-Петербург")
                .veryfythatregionisCorrect("Москва")
                .selectOnFirstElementAndStorItTextValue();

        ZhkuMoskvaPage zhku = new ZhkuMoskvaPage();
        zhku.payInMoscowTab.click();
        zhku.payInMoscowTab.click();
        zhku.pushTheButtonPayInMoscow();

        Assert.assertEquals("Поле обязательное", zhku.inputPayerCodeError.getText());
        Assert.assertEquals("Поле обязательное", zhku.inputPeriodError.getText());
        Assert.assertEquals("Поле обязательное", zhku.inputSummaPlatejaError.getText());
//        Assert.assertEquals("Поле заполнено некорректно", zhkuMoskvaOplata.getErrorPeriodMessage());
//         * выполнить проверки на невалидные значения обязательных полей
        zhku.inputPayerCode.click();
        zhku.inputPayerCode.sendKeys("000000000");
        zhku.inputPeriod.click();
        zhku.inputPeriod.sendKeys("15.2018");
        zhku.inputSummaPlateja.sendKeys("5");
        zhku.pushTheButtonPayInMoscow();

        Assert.assertEquals("Поле неправильно заполнено", zhku.inputPayerCodeError.getText());
        Assert.assertEquals("Поле заполнено некорректно", zhku.inputPeriodError.getText());
        Assert.assertEquals("Минимум — 10 \u20BD", zhku.inputSummaPlatejaError.getText());
//        	- проверить текст всех ошибок

        // нажать платежи
        mp.clickOnPaymentsButton();
        // ввести запомненное значение ЖКУ-Москва
        PaymentsPage pp = new PaymentsPage();
        pp.searchInput.sendKeys(zhku.getValueFromStorage());
        zhku.clicOnFirstSegestion();
        zhku.selectOnFirstElementAndStorItTextValue();

        // * проверить что в выпадающем списке ЖКУ-Москва первым элементом
//                .verifyFirsElementIs("ЖКУ-Москва")
        // выбрать элемен с значением из сохраненной переменной ЖКУ-Москва
//                .verifyThatOpenedPageHasTitle(savedPageTitle);
        // * убедится что загруженная страница таже (проверить тайтлы)

        // перейти опять на коммунальные платежи через кнопку меню платежи
        // выбрать Сант петербург
        mp.clickOnPaymentsButton()
                .clickOnKommunalniePlatezhi()
                .selectRegion("Санкт-Петербург");
        // * проверяем что открылась страница Питера
//        new MainPage().clickOnPaymentsButton() .selecRegion("Сант петербург").verifyPageTitleIs("qweqwe");
        // * 14.	Убедится, что в списке поставщиков на странице
//        .verifyThatelementEbsent(savedelement);
        // выбора поставщиков услуг отсутствует искомый.


// нажать платежи															 - переход на страницу https://www.tinkoff.ru/payments/
//        PaymentsPage pp = new PaymentsPage();
//        new PaymentsPage()
//                .setSearchField("sdf");
        // на странице payments нажать ЖКХ                                         - переход на страницу https://www.tinkoff.ru/payments/categories/kommunalnie-platezhi/
/*        PaymentsPage pp = new PaymentsPage(driver);
        pp.JKHbutton.click();
        KommunalniePlatezhiPage kp = new KommunalniePlatezhiPage(driver);
        kp.
// * проверить что регион – “г. Москва”
//   -если нет то выбрать регион – “г. Москва”

// * нажать на 1 элемент и запомнить что это ЖКУ Москва (запомнить его текст) - переход на страницу https://www.tinkoff.ru/zhku-moskva/
//        kp.selectOnFirstElementAndStorItTextValue();
// * выполнить проверки на невалидные значения обязательных полей
//	- проверить текст всех ошибок

        mp.paymentsButton.click();
        pp.insertSavedValueInSearchInput(driver);
        ZhkuMoskvaPage zmp = new ZhkuMoskvaPage(driver);
        zmp.verifyPageTitle("Узнайте задолженность по ЖКУ в Москве");
        wait.until(visibilityOf(mp.requestInput));
// нажать платежи															 - переход на страницу https://www.tinkoff.ru/payments/
// ввести запомненное значение ЖКУ-Москва
// * проверить что в выпадающем списке ЖКУ-Москва первым элементом
// выбрать элемен с значением из сохраненной переменной ЖКУ-Москва
// * убедится что загруженная страница таже (проверить тайтлы) 			- переход на страницу https://www.tinkoff.ru/payments/categories/kommunalnie-platezhi/
// перейти опять на коммунальные платежи через кнопку меню платежи		- переход на страницу https://www.tinkoff.ru/payments/categories/kommunalnie-platezhi/
// выбрать Сант петербург													- переход на страницу https://www.tinkoff.ru/payments/categories/kommunalnie-platezhi/
// * проверяем что открылась страница Питера
// * 14.	Убедится, что в списке поставщиков на странице выбора поставщиков услуг отсутствует искомый.
//
//
//  открыть https://www.tinkoff.ru/
// нажать платежи
// на странице payments нажать ЖКХ
// * проверить что регион – “г. Москва”
//   -если нет то выбрать регион – “г. Москва”
// * нажать на 1 элемент и запомнить что это ЖКУ Москва (запомнить его текст) - переход на страницу https://www.tinkoff.ru/zhku-moskva/
// * выполнить проверки на невалидные значения обязательных полей
//	- проверить текст всех ошибок
// нажать платежи															 - переход на страницу https://www.tinkoff.ru/payments/
// ввести запомненное значение ЖКУ-Москва
// * проверить что в выпадающем списке ЖКУ-Москва первым элементом
// выбрать элемен с значением из сохраненной переменной ЖКУ-Москва
// * убедится что загруженная страница таже (проверить тайтлы) 			- переход на страницу https://www.tinkoff.ru/payments/categories/kommunalnie-platezhi/
// перейти опять на коммунальные платежи через кнопку меню платежи		- переход на страницу https://www.tinkoff.ru/payments/categories/kommunalnie-platezhi/
// выбрать Сант петербург													- переход на страницу https://www.tinkoff.ru/payments/categories/kommunalnie-platezhi/
// * проверяем что открылась страница Питера
// * 14.	Убедится, что в списке поставщиков на странице выбора поставщиков услуг отсутствует искомый.
    }*/
    }


}