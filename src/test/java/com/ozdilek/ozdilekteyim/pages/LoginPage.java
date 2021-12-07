package com.ozdilek.ozdilekteyim.pages;

import com.ozdilek.ozdilekteyim.base.BasePage;
import com.thoughtworks.gauge.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    public static final By selectorButtonLogin = By.id("com.ozdilek.ozdilekteyim:id/btnLogin");
    public static final By selectorEmail = By.id("com.ozdilek.ozdilekteyim:id/etEposta");
    public static final By selectorPassword = By.id("com.ozdilek.ozdilekteyim:id/etPassword");

    @Step("Giriş yapma sayfasının açıldığı dogrulanır.")
    public void assertLoginPageOpened() {
        boolean hasElement = pageHasElementsWithBy(selectorButtonLogin);
        Assertions.assertTrue(hasElement);
    }

    @Step("Kullanıcı adı alanına <text> bilgisi girilir")
    public void submitUsername(String text) {
        sendKeysBy(selectorEmail,text);
    }

    @Step("Password alanına <passw> yazılır")
    public void submitPassword(String passw) {
        sendKeysBy(selectorPassword,passw);
    }

}
