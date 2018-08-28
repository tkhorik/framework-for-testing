package pages;

import core.WebDriverSingleton;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.*;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class KommunalniePlatezhiPage extends AbstractPage {

    WebDriverWait wait = new WebDriverWait(WebDriverSingleton.getInstance(), 30);

    public String getValueFromStorage() {
        return getSAVEDVALUE();
    }

    private static void setSAVEDVALUE(String SAVEDVALUE) {
        KommunalniePlatezhiPage.SAVEDVALUE = SAVEDVALUE;
    }

    private static String getSAVEDVALUE() {
        return SAVEDVALUE;
    }

    @FindBy(xpath = ".//*[@class='PaymentsCatalogHeader__header_1vwKb']/span")
    public HtmlElement kommunalniePlatezhi;

    @FindBy(xpath = "//*[@class='Link__link_dvp7e Link__link_theme_default_PBgyj']//div[contains(text(),'ЖКХ')]")
    public Button buttonJKH;

    @FindBy(xpath = ".//*[@class='PaymentsCatalogHeader__header_1vwKb']/span/span")
    public Button paymentsCatalogHeader;

    @FindBy(xpath = "(//div[@class='UiRegions__uiRegions__layout_2wFF-']//a)[1]")
    public Link firstSearchResult;

    @FindBy(xpath = "//DIV[@class='Text__text_1yBRv Text__text_size_21_3OIp0 Text__text_sizeDesktop_40_O_1Sl Text__text_align_center_1gFso Text__text_alignDesktop_left_1xu1i'][text()='Узнайте задолженность по ЖКУ в Москве']")
    public TextBlock kommunalniePlatezhiPageTitle;

    @FindBy(xpath = "//*[@data-qa-file=\"UIScrollList\"]")
    public Button scrolllistUIScrollList;

    @FindBy(xpath = "(//*[@data-qa-file='SearchSuggested']//*[@data-qa-node='Tag'])[1]")
    public TextInput firstSearchSuggestedelEment;

    private static String SAVEDVALUE;

    @FindBy(xpath = "(//*[@class='ui-link__text'][@data-qa-file='UILink'])[3]")
    public Button firstElementUILayoutSection;

    @FindBy(xpath = "(//*[@data-qa-file='UIScrollList']//span)[3]//span")
    public Button firstElementUIScrollList;

    public void verifyPageTitleIs(String s) {
        wait.until(visibilityOf(kommunalniePlatezhiPageTitle));
        Assert.assertEquals("Заголовок страницы не корректен", kommunalniePlatezhiPageTitle.getText(), s);
    }

    public KommunalniePlatezhiPage veryfythatregionisCorrect(String name) {
        if (paymentsCatalogHeader.getText().contains(name)) {
            return new KommunalniePlatezhiPage();
        } else {
            selectRegion(name);
            return new KommunalniePlatezhiPage();
        }
    }

    public KommunalniePlatezhiPage selectRegion(String name) {
        wait.until(elementToBeClickable(paymentsCatalogHeader));
        paymentsCatalogHeader.click();
        searchRegionField.click();
        searchRegionField.sendKeys(name);
        firstSearchResult.click();
        return new KommunalniePlatezhiPage();
    }

    public void selectOnFirstElementAndStorItTextValue() {
        wait.until(visibilityOfAllElements(scrolllistUIScrollList));
        setSAVEDVALUE(firstElementUILayoutSection.getText());
//        System.out.println("было сохранено значение первого элемента " + getSAVEDVALUE());
        firstElementUIScrollList.click();
    }

    public void insertSavedValueInSearchInput() {
        String string = getSAVEDVALUE();
        wait.until(visibilityOf(searchInput));
        searchInput.click();
        searchInput.sendKeys(string);
        firstSearchSuggestedelEment.click();
    }
}
