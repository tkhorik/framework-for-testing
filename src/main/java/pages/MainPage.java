package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;

public class MainPage extends AbstractPage {

    @Name("Search request input")
    @FindBy(id = "searchInput")
    public Button requestInput;

    @Name("payments-menu")
    @FindBy(xpath = ".//*[@data-qa-file='Footer']//*[text() ='Платежи']")
    public Button paymentsButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }
}
