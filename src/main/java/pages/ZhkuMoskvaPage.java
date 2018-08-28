package pages;

import core.WebDriverSingleton;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class ZhkuMoskvaPage extends AbstractPage {
    WebDriverWait wait = new WebDriverWait(WebDriverSingleton.getInstance(), 30);

    @FindBy(xpath = "//DIV[@class='SearchSuggest__entry_2vlxq SearchSuggest__entry_pickable_2Vfxf SearchSuggest__entry_highlighted_1SPg3 SearchSuggest__entry_withIcon_FH3k1']")
    public TextBlock firstSegestionElement;



    @FindBy(xpath = ".//*[contains(text(),'Оплатить ЖКУ в Москве')]")
    public Button payInMoscowTab;
    @FindBy(xpath = "//BUTTON[@class='ui-button ui-button_failure ui-button_mobile-wide ui-button_provider-pay ui-button_size_xxl ui-form__button ui-button_inline']")
    public Button buttonPayInMoscow;


    @FindBy(xpath = ".//*[@class='PaymentsCatalogHeader__header_1vwKb']/span")
    public HtmlElement kommunalniePlatezhi;

    @FindBy(xpath = "(//*[@class='ui-link__text'][@data-qa-file='UILink'])[3]")
    public Button firstElementUILayoutSection;










    //    @FindBy(xpath = "//label[@class='ui-input__container']//input[@id='payerCode']")
    @FindBy(xpath = "//input[@name = 'provider-payerCode']")
    public TextInput inputPayerCode;

    @FindBy(xpath = "//input[@name = 'provider-period']")
    public TextInput inputPeriod;

    @FindBy(xpath = " //input[@name='email']")
    public TextInput inputEmail;
    @FindBy(xpath = "//div[@class='Input__value_2Kx90 Input__value_changed_2SIME']//input[contains(@placeholder,'')]")
    public TextInput inputValueSumma;
    @FindBy(xpath = "//form[@class = 'ui-form']/div[4]//input")
    public TextInput inputSummaPlateja;


    @FindBy(xpath = "//input[@name='login']")
    public TextInput inputLogin;

    @FindBy(xpath = "//h3[@class='ui-button__text']")
    public TextInput buttonUiButton;

    @FindBy(xpath = "(.//*[@data-qa-file='UIFormRowError'])[1]")
    public TextBlock inputPayerCodeError;

    @FindBy(xpath = "(//DIV[@class='ui-form-field-error-message ui-form-field-error-message_ui-form'])[2]")
    public TextBlock inputPeriodError;

    @FindBy(xpath = "(//DIV[@class='ui-form-field-error-message ui-form-field-error-message_ui-form'])[3]")
    public TextBlock inputSummaPlatejaError;

    public void pushTheButtonPayInMoscow() {
        clickOnButton(buttonPayInMoscow);
    }










}