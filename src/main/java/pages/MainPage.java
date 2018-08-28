package pages;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;

public class MainPage extends AbstractPage {

    @Name("Search request input")
    @FindBy(id = "searchInput")
    public Button requestInput;

    @Name("footer-menu")
    @FindBy(xpath = ".//*[@data-qa-file='Footer']//*[text() ='Платежи']")
    private Button paymentsButton;

    public PaymentsPage clickOnPaymentsButton() {
        paymentsButton.click();
        return new PaymentsPage();
    }
}
