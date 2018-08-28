package pages;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class KommunalniePlatezhiPage extends AbstractPage {

    @FindBy(xpath = ".//*[@class='PaymentsCatalogHeader__header_1vwKb']/span")
    public HtmlElement kommunalniePlatezhi;

    @FindBy(xpath = "//*[@class='Link__link_dvp7e Link__link_theme_default_PBgyj']//div[contains(text(),'ЖКХ')]")
    public Button buttonJKH;
}
