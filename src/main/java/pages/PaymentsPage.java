package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class PaymentsPage {

    @Name("JKHbutton")
    @FindBy(xpath = "//*[@class='Link__link_dvp7e Link__link_theme_default_PBgyj']//div[contains(text(),'ЖКХ')]")
    public Button JKHbutton;

    @FindBy(xpath = "//*[@data-qa-file='Search']")
    public Button searchButton;

//    @FindBy(xpath = "//*[@data-qa-file='SearchInput']")
    @FindBy(xpath = "//input[@placeholder='Название или ИНН получателя платежа']")
    public TextInput searchInput;

    @FindBy(xpath = "(//*[@data-qa-file='SearchSuggested']//*[@data-qa-node='Tag'])[1]")
    public TextInput firstSearchSuggestedelEment;


    public PaymentsPage clickOnKommunalniePlatezhi() {
        JKHbutton.click();
        return this;
    }

    public PaymentsPage(WebDriver driver) {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }

    public void InsertSavedValueInSearchInput(WebDriver driver) {
        String string = KommunalniePlatezhiPage.getSAVEDVALUE();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(visibilityOf(searchInput));
        searchInput.click();
        searchInput.sendKeys(string);
        firstSearchSuggestedelEment.click();
    }
}
