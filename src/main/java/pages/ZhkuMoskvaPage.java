package pages;

import core.WebDriverSingleton;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.*;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

public class ZhkuMoskvaPage extends AbstractPage {
    WebDriverWait wait = new WebDriverWait(WebDriverSingleton.getInstance(), 30);
    private static String SAVEDVALUE;

    private static void setSAVEDVALUE(String SAVEDVALUE) {
        ZhkuMoskvaPage.SAVEDVALUE = SAVEDVALUE;
    }

    static String getSAVEDVALUE() {
        return SAVEDVALUE;
    }

    @FindBy(xpath = "//DIV[@class='SearchSuggest__entry_2vlxq SearchSuggest__entry_pickable_2Vfxf SearchSuggest__entry_highlighted_1SPg3 SearchSuggest__entry_withIcon_FH3k1']")
    public TextBlock firstSegestionElement;

    @FindBy(xpath = "//DIV[@class='Text__text_1yBRv Text__text_size_21_3OIp0 Text__text_sizeDesktop_40_O_1Sl Text__text_align_center_1gFso Text__text_alignDesktop_left_1xu1i'][text()='Узнайте задолженность по ЖКУ в Москве']")
    public TextBlock zhkuMoskvaPageTitle;

    @FindBy(xpath = ".//*[contains(text(),'Оплатить ЖКУ в Москве')]")
    public Button payInMoscowTab;
    @FindBy(xpath = "//BUTTON[@class='ui-button ui-button_failure ui-button_mobile-wide ui-button_provider-pay ui-button_size_xxl ui-form__button ui-button_inline']")
    public Button buttonPayInMoscow;


    @FindBy(xpath = ".//*[@class='PaymentsCatalogHeader__header_1vwKb']/span")
    public HtmlElement kommunalniePlatezhi;

    @FindBy(xpath = "(//*[@class='ui-link__text'][@data-qa-file='UILink'])[3]")
    public Button firstElementUILayoutSection;

    @FindBy(xpath = "//*[@data-qa-file=\"UIScrollList\"]")
    public Button scrolllistUIScrollList;


    @FindBy(xpath = ".//*[@class='PaymentsCatalogHeader__header_1vwKb']/span/span")
    public Button paymentsCatalogHeader;

    @FindBy(xpath = "//input[@class = 'ui-input__field']")
    public TextInput searchRegionField;

    @FindBy(xpath = "(//div[@class='UiRegions__uiRegions__layout_2wFF-']//a)[1]")
    public Link firstSearchResult;

    @FindBy(xpath = "(//*[@data-qa-file='UIScrollList']//span)[3]//span")
    public Button firstElementUIScrollList;

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

    public ZhkuMoskvaPage veryfythatregionisCorrect(String name) {
        if (paymentsCatalogHeader.getText().contains(name)) {
//            String firstElement = firstElementUILayoutSection.getAttribute("title");
//            Assert.assertEquals("ЖКУ-Москва", firstElement);
            return new ZhkuMoskvaPage();
        } else {
            selectRegion(name);
//            String firstElement = firstElementUILayoutSection.getAttribute("title");
//            Assert.assertEquals("ЖКУ-Москва", firstElement);
            return new ZhkuMoskvaPage();
        }

    }

    public void pushTheButtonPayInMoscow() {
        clickOnButton(buttonPayInMoscow);
    }

      /*  public void verifyPageTitle (String s){
            Assert.assertEquals("Заголовок страницы не корректен", zhkuMoskvaPageTitle.getText(), s);
        }*/

    public ZhkuMoskvaPage selectRegion(String name) {
        wait.until(elementToBeClickable(paymentsCatalogHeader));
        paymentsCatalogHeader.click();
        searchRegionField.click();
        searchRegionField.sendKeys(name);
        firstSearchResult.click();
        return new ZhkuMoskvaPage();
    }

    public void selectOnFirstElementAndStorItTextValue() {
        wait.until(visibilityOfAllElements(scrolllistUIScrollList));
        setSAVEDVALUE(firstElementUILayoutSection.getText());
        System.out.println("было сохранено значение первого элемента " + getSAVEDVALUE());
        firstElementUIScrollList.click();
    }
    public String getValueFromStorage(){
        return getSAVEDVALUE();
    }

    public void clicOnFirstSegestion(){
    firstSegestionElement.click();
    }

}