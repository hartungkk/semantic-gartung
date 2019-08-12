package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public SelenideElement emailHeader = $(byClassName("header-contacts-email"));
    public SelenideElement phoneHeader = $(byClassName("header-contacts-phone"));
    public SelenideElement loginForm = $(byClassName("loginForm"));
    public SelenideElement emailInput = $(byId("pptusername"));
    public SelenideElement passwordInput = $(byId("pptpassword"));
    public SelenideElement submitButton = $(byClassName("loginForm-submit"));


    public void waitVisible() {
        emailHeader.waitUntil(Condition.visible, 10000L);
        phoneHeader.waitUntil(Condition.visible, 10000L);
        loginForm.waitUntil(Condition.visible, 10000L);
        emailInput.waitUntil(Condition.visible, 10000L);
        passwordInput.waitUntil(Condition.visible, 10000L);
        submitButton.waitUntil(Condition.visible, 10000L);
    }
}
