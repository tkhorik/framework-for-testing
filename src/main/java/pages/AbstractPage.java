package pages;

import core.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class AbstractPage extends HtmlElement {

    @FindBy(xpath = "//input[@class = 'ui-input__field']")
    public TextInput searchRegionField;

    @FindBy(xpath = "//input[@placeholder='Название или ИНН получателя платежа']")
    public TextInput searchInput;

    public void clickOn(String str) {
        WebDriver initialDriver = WebDriverSingleton.getDriver();
        Actions action = new Actions(initialDriver);
        WebDriverWait wait = new WebDriverWait(initialDriver, 5);
        String element = "//*[text()='" + str + "']//ancestor::*/a";
        WebElement until = wait.until(visibilityOf(initialDriver.findElement(By.xpath(element))));
        action.moveToElement(until).build().perform();
    }

    void clickOnButton(Button button) {
        WebDriver initialDriver = WebDriverSingleton.getDriver();
        WebDriverWait wait = new WebDriverWait(initialDriver,30);
        wait.until(elementToBeClickable(button)).click();
    }

    AbstractPage() {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(WebDriverSingleton.getInstance())), this);
    }
}