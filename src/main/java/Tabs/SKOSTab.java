package Tabs;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SKOSTab {

    public SelenideElement skosTable = $(byId("skosDetails"));
    public ElementsCollection relatedConceptsItemsList = $$(byXpath("//div[contains(@id,'related')]//div[@id='list_related']//div[@class='element_of_predicate']//a"));
    public SelenideElement blueTable = $(byClassName("tableBlue"));
    public SelenideElement greenTable = $(byClassName("tableGreen"));

    public SelenideElement getDeleteButtonByText(String value) {
        SelenideElement result = $(byXpath("//div[contains(@id,'related')]/div[@id='list_related']/div[@class='element_of_predicate']//a[contains(text(),'".concat(value).concat("')]/parent::*//a[@class='buttonDelete']")));
        return result;
    }

    public void waitVisible() {
        skosTable.waitUntil(Condition.visible, 10000L);
        blueTable.waitUntil(Condition.visible, 10000L);
        greenTable.waitUntil(Condition.visible, 10000L);
    }

}
