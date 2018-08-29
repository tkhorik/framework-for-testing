package pages;

import core.WebDriverSingleton;

public class MainPage extends AbstractPage {

    public MainPage getUrl(String url){
        WebDriverSingleton.getDriver().get(url);
        return this;
    }


}
