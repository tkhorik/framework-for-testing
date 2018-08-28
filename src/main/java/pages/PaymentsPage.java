package pages;

import core.WebDriverSingleton;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class PaymentsPage extends AbstractPage {
    WebDriverWait wait = new WebDriverWait(WebDriverSingleton.getDriver(), 5);

    @FindBy(xpath = "//DIV[@data-qa-file='IconWithText'][text()='ЖКХ']")
    public Button jkhButton;

    @FindBy(xpath = "//*[@data-qa-file='Search']")
    public Button searchButton;

    @FindBy(xpath = "(//*[@data-qa-file='GridColumn'])")
    public HtmlElement SearchSuggest__blockContent_2s0YS;

    public PaymentsPage selecRegion(String region) {
        return new PaymentsPage();
    }

    public void verifyPageTitleIs(String title) {
        Assert.assertEquals("заголовки страниц не соответсвуют", searchButton.getLocation(), title);
    }

    public void setSearchField(String str) {
        searchInput.sendKeys(str);
    }

    public KommunalniePlatezhiPage clickOnKommunalniePlatezhi() {
        jkhButton.click();
        return new KommunalniePlatezhiPage();
    }

    public void clickOnSegestionLIstByInedex(int index) {
        wait.until(visibilityOf(SearchSuggest__blockContent_2s0YS));
        WebDriverSingleton.getDriver()
                .findElement(By.xpath("(//*[@data-qa-file='GridColumn'])" + "[" + index + "]" + ""))
                .click();
    }
}