package pages;

import core.WebDriverSingleton;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class AbstractPage extends HtmlElement {


    public AbstractPage() {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(WebDriverSingleton.getInstance())), this);
    }
}
