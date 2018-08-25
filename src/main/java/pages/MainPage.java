package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;

public class MainPage extends AbstractPage {

    @Name("Search request input")
    @FindBy(id = "searchInput")
    public Button requestInput;

    @Name("Search button")
    @FindBy(id = "searchButton")
    public Button searchButton;

    public void search(String request) {
        requestInput.sendKeys(request);
        searchButton.click();
    }

    public MainPage(WebDriver driver) {
        super(driver);
    }
}
