package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ConceptsPage {

    public SelenideElement matchResultLabel = $(byXpath("//div[@id='advancedThesaurusSearch']//div[@class='padding20']"));
    public SelenideElement historyTable = $(byId("historyFilterViewTable"));

    public SelenideElement getRowFromSearchResultsByText(String value) {
        SelenideElement result = $(byXpath("//div[@id='concept-search']//tbody//tr//div//a[contains(text(),'".concat(value).concat("')]")));
        return result;
    }

    public void expectCountSearchResultsInTable(int expectCount) {
        ElementsCollection searchResults = $$(byXpath("//div[@id='concept-search']//tbody//tr//td[1]//a"));
        searchResults.shouldHaveSize(expectCount);
    }

    public void waitVisibleAdvancedSearchTab() {
        historyTable.waitUntil(Condition.visible, 10000L);
    }
}
