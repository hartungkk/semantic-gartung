package Tabs;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class QualityManagmentTab {

    public SelenideElement projectQualityForm = $(byId("ProjectQualityReport"));
    public SelenideElement currentStatusLabel = $(byXpath("//div[@id='ProjectQualityReport']//span"));
    public SelenideElement generateButton = $(byXpath("//div[@id='ProjectQualityReport']//button"));
    public SelenideElement generateAlert = $(byXpath("//td[@id='dialogHeader']"));
    public SelenideElement generatedSuccessfulAlert = $(byId("progressPercent")); // i think if we have this locator on page, we have success generate
    public ElementsCollection listOfReports = $$(byXpath("//ul[@id='issueReports']//li/a"));

    public ElementsCollection subListFromReport = $$(byId("issuePerConcept"));

    public void waitVisibleQualityReportTab()
    {
        projectQualityForm.waitUntil(Condition.visible,10000L);
        currentStatusLabel.waitUntil(Condition.visible,10000L);
        generateButton.waitUntil(Condition.visible,10000L);
    }
}
