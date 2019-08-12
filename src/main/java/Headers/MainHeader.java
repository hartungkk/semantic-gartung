package Headers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainHeader {
    public SelenideElement menuBar = $(byId("menuBar"));
    public SelenideElement searchInHeader = $(byId("SearchAutoCompleteInput"));
    public ElementsCollection menuItems = $$(byXpath("//div[@id='menuBar']//div[@class='menuBarItem-icon']"));
    public ElementsCollection searchHints = $$(byXpath("//div[@id='SearchAutoComplete']//ul//li"));


    public void waitVisible() {
        menuBar.waitUntil(Condition.visible, 10000L);
        menuItems.first().waitUntil(Condition.visible, 10000L);
    }
}
