package pages;

import core.WebDriverSingleton;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.Button;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class PaymentsPage extends AbstractPage {

    WebDriverWait wait = new WebDriverWait(WebDriverSingleton.getDriver(), 5);

    @FindBy(xpath = "//DIV[@data-qa-file='IconWithText'][text()='ЖКХ']")
    public Button jkhButton;

    @FindBy(xpath = "//*[@data-qa-file='Search']")
    public Button searchButton;

    public PaymentsPage selecRegion(String region) {
        return new PaymentsPage();
    }

    public void verifyPageTitleIs(String title) {
        Assert.assertEquals("заголовки страниц не соответсвуют", searchButton.getLocation(), title);
    }

    public void setSearchField(String str) {
        searchInput.sendKeys(str);
    }

    public ZhkuMoskvaPage fillSearchInput(String str) {
        searchInput.sendKeys(str);
        return new ZhkuMoskvaPage();
    }

    public KommunalniePlatezhiPage clickOnKommunalniePlatezhi() {
        wait.until(elementToBeClickable(jkhButton)).click();
        return new KommunalniePlatezhiPage();
    }
}