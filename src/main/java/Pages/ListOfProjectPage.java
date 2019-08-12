package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class ListOfProjectPage {

    public SelenideElement profileIcon = $(byAttribute("data-menu","pp-user-menu"));
    public SelenideElement centralPanel = $(byId("centertable"));
    public SelenideElement searchInputByCentralPanel = $(byId("openProject_projects_filter2"));


    public SelenideElement getRowByTextFromTable(String value) {
        SelenideElement result = $(byXpath("//tbody//tr//div/div[contains(text(),'".concat(value).concat("')]")));
        return result;
    }

    public void waitVisible() {
        profileIcon.waitUntil(Condition.visible, 10000L);
        centralPanel.waitUntil(Condition.visible, 10000L);
        searchInputByCentralPanel.waitUntil(Condition.visible, 10000L);
    }
}

