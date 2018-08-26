package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.TextBlock;

public class ZhkuMoskvaPage extends AbstractPage {

    @FindBy(xpath = "//DIV[@class='Text__text_1yBRv Text__text_size_21_3OIp0 Text__text_sizeDesktop_40_O_1Sl Text__text_align_center_1gFso Text__text_alignDesktop_left_1xu1i'][text()='Узнайте задолженность по ЖКУ в Москве']")
    public TextBlock zhkuMoskvaPageTitle;


    public ZhkuMoskvaPage(WebDriver driver) {
        super(driver);
    }

    public void verifyPageTitle(String s) {
        Assert.assertEquals("Заголовок страницы не корректен", zhkuMoskvaPageTitle.getText(), s);
    }
}
