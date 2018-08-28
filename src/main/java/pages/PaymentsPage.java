package pages;

import core.WebDriverSingleton2;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class PaymentsPage extends AbstractPage {

    @FindBy(xpath = "//DIV[@data-qa-file='IconWithText'][text()='ЖКХ']")
    public Button jkhButton;

    @FindBy(xpath = "//*[@data-qa-file='Search']")
    public Button searchButton;

    @FindBy(xpath = "//input[@placeholder='Название или ИНН получателя платежа']")
    public TextInput searchInput;

    @FindBy(xpath = "(//*[@data-qa-file='SearchSuggested']//*[@data-qa-node='Tag'])[1]")
    public TextInput firstSearchSuggestedelEment;

    public PaymentsPage selecRegion(String region) {
        return new PaymentsPage();
    }

    public void verifyPageTitleIs(String title) {
        Assert.assertEquals("заголовки страниц не соответсвуют", searchButton.getLocation(), title);
    }

//    public void verifyThatelementEbsent (SavedElement element){
//        Assert.assertTrue("проверяем элеме нт пристусвуте на странице",searchInput.isDisplayed(),false);
//    }

    public void setSearchField(String str) {
        searchInput.sendKeys(str);
    }

    public void insertSavedValueInSearchInput() {
        String string = ZhkuMoskvaPage.getSAVEDVALUE();
        WebDriverWait wait = new WebDriverWait(WebDriverSingleton2.getDriver(), 5);
        wait.until(visibilityOf(searchInput));
        searchInput.click();
        searchInput.sendKeys(string);
        firstSearchSuggestedelEment.click();
    }

    public ZhkuMoskvaPage clickOnKommunalniePlatezhi() {
        jkhButton.click();
        return new ZhkuMoskvaPage();
    }
}