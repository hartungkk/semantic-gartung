package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class LeftSkosMenuPage {
    public SelenideElement mainRepository= $(byId("urn:repositorynode"));

    public void waitVisible()
    {
        mainRepository.waitUntil(Condition.visible,10000L);
    }

}
