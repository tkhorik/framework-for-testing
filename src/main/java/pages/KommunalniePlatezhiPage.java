package pages;

import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class KommunalniePlatezhiPage extends AbstractPage {
    static String getSAVEDVALUE() {
        return SAVEDVALUE;
    }

    private static void setSAVEDVALUE(String SAVEDVALUE) {
        KommunalniePlatezhiPage.SAVEDVALUE = SAVEDVALUE;
    }

    private static String SAVEDVALUE;

    @FindBy(xpath = ".//*[@data-qa-file='Footer']//*[text() ='Платежи']")
    public Button paymentsButton;

    @FindBy(xpath = ".//*[@class='PaymentsCatalogHeader__header_1vwKb']/span")
    public Button paymentsCatalogHeader;

    @FindBy(xpath = ".//*[@class='PaymentsCatalogHeader__header_1vwKb']/span")
    public HtmlElement kommunalniePlatezhi;

    @FindBy(xpath = "//input[@class = 'ui-input__field']")
    public TextInput searchRegionField;

    @FindBy(xpath = "//*[@class='Link__link_dvp7e Link__link_theme_default_PBgyj']//div[contains(text(),'ЖКХ')]")
    public Button buttonJKH;

    @FindBy(xpath = "(//div[@class='UiRegions__uiRegions__layout_2wFF-']//a)[1]")
    public Link firstSearchResult;

    @FindBy(xpath = "(//*[@data-qa-file='UIScrollList']//span)[3]//span")
    public Button firstElementUIScrollList;

    @FindBy(xpath = "(//*[@data-qa-file=\"UILayoutSection\"]//a)[1]")
    public Button firstElementUILayoutSection;


    public void veryfythatregionisCorrect(String name) {
        if (paymentsCatalogHeader.getText().contains(name)) {
            String firstElement = firstElementUILayoutSection.getAttribute("title");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Assert.assertEquals("ЖКУ-Москва", firstElement);
//            firstElementUILayoutSection.click();
            selectOnFirstElementAndStorItTextValue();
        } else {
            selectRegion("Москва");
            String firstElement = kommunalniePlatezhi.getAttribute("title");
            Assert.assertEquals("ЖКУ-Москва", firstElement);
//            kommunalniePlatezhi.click();
            selectOnFirstElementAndStorItTextValue();
        }
    }

    public void selectRegion(String name) {
        paymentsCatalogHeader.click();
        searchRegionField.sendKeys(name);
        firstSearchResult.click();
    }

    public void selectOnFirstElementAndStorItTextValue() {
        setSAVEDVALUE(firstElementUIScrollList.getText());
        System.out.println("было сохранено значение первого элемента "+ getSAVEDVALUE());
        firstElementUIScrollList.click();
    }
}
