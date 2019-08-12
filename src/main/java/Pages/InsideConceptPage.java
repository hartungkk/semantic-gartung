package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class InsideConceptPage {

    public ElementsCollection menuTabs = $$(byXpath("//div[@id='centertable']//li"));
    public SelenideElement titleConcept = $(byClassName("resourceLabel"));

    public void waitVisible() {
        titleConcept.waitUntil(Condition.visible, 10000L);
    }
}
