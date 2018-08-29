package pages;

import core.WebDriverSingleton;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.element.TextInput;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class ZhkuMoskvaPage extends AbstractPage {

    WebDriverWait wait = new WebDriverWait(WebDriverSingleton.getInstance(), 30);

    @FindBy(xpath = "//DIV[@class='SearchSuggest__entry_2vlxq SearchSuggest__entry_pickable_2Vfxf SearchSuggest__entry_highlighted_1SPg3 SearchSuggest__entry_withIcon_FH3k1']")
    public TextBlock firstSegestionElement;

    @FindBy(xpath = ".//*[@class='PaymentsCatalogHeader__header_1vwKb']/span")
    public HtmlElement kommunalniePlatezhi;

    @FindBy(xpath = "(//*[@class='ui-link__text'][@data-qa-file='UILink'])[3]")
    public Button firstElementUILayoutSection;

    @FindBy(xpath = "//input[@name='login']")
    public TextInput inputLogin;

    @FindBy(xpath = "//h3[@class='ui-button__text']")
    public TextInput buttonUiButton;

    @FindBy(xpath = ".//*[contains(text(),'Оплатить ЖКУ в Москве')]")
    public Button payInMoscowTab;

    @FindBy(xpath = "//BUTTON[@class='ui-button ui-button_failure ui-button_mobile-wide ui-button_provider-pay ui-button_size_xxl ui-form__button ui-button_inline']")
    public Button buttonPayInMoscow;

    @FindBy(xpath = "//div[@class='Input__value_2Kx90 Input__value_changed_2SIME']//input[contains(@placeholder,'')]")
    public TextInput inputValueSumma;

    @FindBy(xpath = "//form[@class = 'ui-form']/div[4]//input")
    public TextInput inputSummaPlateja;

    @FindBy(xpath = "(.//*[@data-qa-file='UIFormRowError'])[1]")
    public TextBlock inputPayerCodeError;

    @FindBy(xpath = "(//DIV[@class='ui-form-field-error-message ui-form-field-error-message_ui-form'])[2]")
    public TextBlock inputPeriodError;

    @FindBy(xpath = "(//DIV[@class='ui-form-field-error-message ui-form-field-error-message_ui-form'])[3]")
    public TextBlock inputSummaPlatejaError;

    @FindBy(xpath = "//input[@name = 'provider-payerCode']")
    public TextInput inputPayerCode;

    @FindBy(xpath = "//input[@name = 'provider-period']")
    public TextInput inputPeriod;

    @FindBy(xpath = " //input[@name='email']")
    public TextInput inputEmail;

    @FindBy(xpath = "(//*[@data-qa-file='GridColumn'])")
    public HtmlElement SearchSuggest__blockContent_2s0YS;

    public ZhkuMoskvaPage verifyInputPayerCodeError(String str) {
        Assert.assertEquals(str, inputPayerCodeError.getText());
        return this;
    }

    public ZhkuMoskvaPage verifyInputPeriodError(String str) {
        Assert.assertEquals(str, inputPeriodError.getText());
        return this;
    }

    public ZhkuMoskvaPage verifyInputSummaPlatejaError(String str) {
        Assert.assertEquals(str, inputSummaPlatejaError.getText());
        return this;
    }

    public ZhkuMoskvaPage fillInputPayerCode(String s) {
        inputPayerCode.sendKeys(s);
        return this;
    }

    public ZhkuMoskvaPage fillInputPeriod(String s) {
        inputPeriod.sendKeys(s);
        return this;
    }

    public ZhkuMoskvaPage fillInputSummaPlateja(String s) {
        inputSummaPlateja.sendKeys(s);
        return this;
    }

    public ZhkuMoskvaPage pushTheButtonPayInMoscow() {
        wait.until(elementToBeClickable(buttonPayInMoscow)).click();
        return this;
    }

    public ZhkuMoskvaPage selectPayInMoscowTab() {
        payInMoscowTab.click();
        return this;
    }

    public MainPage clickOnSegestionLIstByInedex(int index) {
        wait.until(visibilityOf(SearchSuggest__blockContent_2s0YS));
        WebDriverSingleton.getDriver()
                .findElement(By.xpath("(//*[@data-qa-file='GridColumn'])" + "[" + index + "]" + ""))
                .click();
        return new MainPage();
    }
}