package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class InsideProjectPage {
    public SelenideElement centralPanel = $(byId("centertable"));
    public ElementsCollection menuTabs = $$(byXpath("//div[@id='centertable']//li"));
    public SelenideElement labelProject = $(byXpath("//tbody//tr/td/h1"));
    public SelenideElement skosTab = $(byId("tab_skos"));

    public void waitVisible()
    {
        centralPanel.waitUntil(Condition.visible,10000L);
        menuTabs.first().waitUntil(Condition.visible,10000L);
        labelProject.waitUntil(Condition.visible,10000L);
        skosTab.waitUntil(Condition.visible,10000L);
    }
}

