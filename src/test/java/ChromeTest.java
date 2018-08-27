import core.WebDriverSingleton;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.MainPage;
import pages.PaymentsPage;

/*
https://www.swtestacademy.com/allure-testng/ allure implementation
* */

public class ChromeTest {

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

/*    @Before
    public void setupTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.get("https://www.tinkoff.ru");
        driver.manage().window().maximize();
    }*/

    @After
    public void teardown() {
        WebDriverSingleton.getInstance().quit();
    }

    @Test
    public void sampleTest() {

//        WebDriverWait wait = new WebDriverWait(driver, 5);
// открыть https://www.tinkoff.ru/
        MainPage mp = new MainPage();
// нажать платежи															 - переход на страницу https://www.tinkoff.ru/payments/
        mp.paymentsButton.click();
        PaymentsPage pp = new PaymentsPage();
        pp.clickOnKommunalniePlatezhi().;
        // на странице payments нажать ЖКХ                                         - переход на страницу https://www.tinkoff.ru/payments/categories/kommunalnie-platezhi/
/*        PaymentsPage pp = new PaymentsPage(driver);
        pp.JKHbutton.click();
        KommunalniePlatezhiPage kp = new KommunalniePlatezhiPage(driver);
        kp.veryfythatregionisCorrect("Москв");
// * проверить что регион – “г. Москва”
//   -если нет то выбрать регион – “г. Москва”

// * нажать на 1 элемент и запомнить что это ЖКУ Москва (запомнить его текст) - переход на страницу https://www.tinkoff.ru/zhku-moskva/
//        kp.selectOnFirstElementAndStorItTextValue();
// * выполнить проверки на невалидные значения обязательных полей
//	- проверить текст всех ошибок

        mp.paymentsButton.click();
        pp.InsertSavedValueInSearchInput(driver);
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