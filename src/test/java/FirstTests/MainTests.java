package FirstTests;

import Enums.UserData;
import Headers.MainHeader;
import Pages.*;
import Tabs.QualityManagmentTab;
import Tabs.SKOSTab;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import setUp.Settuper;

import java.util.ResourceBundle;

import static com.codeborne.selenide.Selenide.open;

public class MainTests {
    ResourceBundle bundle = ResourceBundle.getBundle("dictionary"); // load our properties file with const text, labels, etc

    @BeforeMethod
    public void setUp() {
        Settuper.setUp(); //setup pre-conditions
    }

    @AfterMethod
    public void tearDown() {
        WebDriverRunner.getWebDriver().close(); //after test method executed case close our instance Chrome
    }

    @Test
    public void FirstCase() {
        LoginPage loginPage = open("/", LoginPage.class);
        ListOfProjectPage listOfProjectPage = new ListOfProjectPage();
        MainHeader mainHeader = new MainHeader();
        InsideProjectPage insideProjectPage = new InsideProjectPage();
        QualityManagmentTab qualityManagmentTab = new QualityManagmentTab();
        ConceptsPage conceptsPage = new ConceptsPage();
        InsideConceptPage insideConceptPage = new InsideConceptPage();
        LeftSkosMenuPage leftSkosMenuPage = new LeftSkosMenuPage();
        SKOSTab skosTab = new SKOSTab();

        int expectedNumberOfRelationClashes = 8;

        loginPage.waitVisible();

        loginPage.emailHeader.waitUntil(Condition.text(bundle.getString("ourEmail")), 5000L);
        loginPage.phoneHeader.waitUntil(Condition.text(bundle.getString("ourPhones")), 5000L);

        loginPage.emailInput.setValue(UserData.USER_LOGIN.getValue());
        loginPage.passwordInput.setValue(UserData.USER_PASSWORD.getValue());

        loginPage.submitButton.click();

        listOfProjectPage.waitVisible();
        mainHeader.waitVisible();

        listOfProjectPage.getRowByTextFromTable(bundle.getString("titleTestProject")).waitUntil(Condition.enabled, 5000).doubleClick();

        leftSkosMenuPage.waitVisible();
        leftSkosMenuPage.mainRepository.click();

        insideProjectPage.waitVisible();
        insideProjectPage.menuTabs.find(Condition.text(bundle.getString("tabQualityManagment"))).click();
        insideProjectPage.menuTabs.find(Condition.text(bundle.getString("subTabQualityReport"))).waitUntil(Condition.visible,6000L).click();

        qualityManagmentTab.waitVisibleQualityReportTab();

        //if you don't rebuild state, you don't have label = 'Generate'
        qualityManagmentTab.generateButton.waitUntil(Condition.text(bundle.getString("labelForGenerateButton")),5000L);
        qualityManagmentTab.currentStatusLabel.waitUntil(Condition.text(bundle.getString("labelBeforeGenerateReport")),5000L);

        qualityManagmentTab.generateButton.click();

        qualityManagmentTab.generateAlert.waitUntil(Condition.visible, 10000L);
        qualityManagmentTab.generatedSuccessfulAlert.waitUntil(Condition.visible, 10000L);

        // qualityManagmentTab.currentStatusLabel.waitUntil(Condition.text(bundle.getString("labelAfterGenerateReport").concat(DateUtils.getCurrentDateAndTime())), 5000L); // method is not stable because we need use data form DB
        qualityManagmentTab.generateButton.waitUntil(Condition.text(bundle.getString("labelForGenerateButtonAfterGenerateReport")), 5000L);

        qualityManagmentTab.listOfReports.find(Condition.text(bundle.getString("titleRelation") + '(' + expectedNumberOfRelationClashes + ')')).click();

        qualityManagmentTab.subListFromReport.first().waitUntil(Condition.visible, 10000L);
        qualityManagmentTab.subListFromReport.shouldHaveSize(expectedNumberOfRelationClashes);
        qualityManagmentTab.subListFromReport.find(Condition.text(bundle.getString("labelPrincipleOfRelativity"))).waitUntil(Condition.visible, 10000L);


        mainHeader.searchInHeader.setValue(bundle.getString("conceptForSearch"));
        mainHeader.searchHints.find(Condition.text(bundle.getString("expectedSearchHint"))).waitUntil(Condition.visible, 10000L);
        mainHeader.searchInHeader.pressEnter();


        conceptsPage.waitVisibleAdvancedSearchTab();

        conceptsPage.matchResultLabel.waitUntil(Condition.visible, 5000L).waitUntil(Condition.text("1 matching concepts"), 5000L);
        conceptsPage.expectCountSearchResultsInTable(1);
        conceptsPage.getRowFromSearchResultsByText(bundle.getString("conceptForSearch")).
                waitUntil(Condition.visible, 5000L).click();

        insideConceptPage.waitVisible();
        insideConceptPage.titleConcept.waitUntil(Condition.text(bundle.getString("conceptForSearch")), 5000L);

        insideConceptPage.menuTabs.find(Condition.text(bundle.getString("tabDetails"))).click();
        insideConceptPage.menuTabs.find(Condition.text(bundle.getString("subTabSKOS"))).click();

        skosTab.waitVisible();
        skosTab.relatedConceptsItemsList.find(Condition.text(bundle.getString("expectedLableInRelatedConcepts"))).waitUntil(Condition.visible, 5000L);

        skosTab.getDeleteButtonByText(bundle.getString("expectedLableInRelatedConcepts")).click();

        skosTab.relatedConceptsItemsList.find(Condition.exactTextCaseSensitive(bundle.getString("expectedLableInRelatedConcepts"))).waitUntil(Condition.hidden, 5000L);

        leftSkosMenuPage.waitVisible();
        leftSkosMenuPage.mainRepository.click();


        insideProjectPage.waitVisible();
        insideProjectPage.menuTabs.find(Condition.text(bundle.getString("tabQualityManagment"))).click();
        insideProjectPage.menuTabs.find(Condition.text(bundle.getString("subTabQualityReport"))).click();

        qualityManagmentTab.waitVisibleQualityReportTab();
        qualityManagmentTab.generateButton.waitUntil(Condition.text(bundle.getString("labelForGenerateButtonAfterGenerateReport")), 5000L);
        qualityManagmentTab.generateButton.click();

        qualityManagmentTab.generateAlert.waitUntil(Condition.visible, 10000L);
        qualityManagmentTab.generatedSuccessfulAlert.waitUntil(Condition.visible, 10000L);

       // qualityManagmentTab.currentStatusLabel.waitUntil(Condition.text(bundle.getString("labelAfterGenerateReport").concat(DateUtils.getCurrentDateAndTime())), 5000L); // method is not stable because we need use data form DB

        qualityManagmentTab.listOfReports.find(Condition.text(bundle.getString("titleRelation") + '(' + (expectedNumberOfRelationClashes-1) + ')')).click();// check changed count

    }

}
