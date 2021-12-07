package com.ozdilek.ozdilekteyim.pages;

import com.ozdilek.ozdilekteyim.base.BasePage;
import com.thoughtworks.gauge.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    public static final By selectorButtonStartShopping = By.id("com.ozdilek.ozdilekteyim:id/tv_startShoppingStore");
    public static final By selectorNavHomePage = By.id("com.ozdilek.ozdilekteyim:id/largeLabel");
    public static final By selectorNavigateCategories = By.id("com.ozdilek.ozdilekteyim:id/nav_categories");

    @Step("Uygulamanın açıldığı kontrol edilir")
    public void startTheApp() {
        final String expected = "Alışverişe Başla";
        assertEqualsWithSelector(selectorButtonStartShopping, expected);
    }

    @Step("Alışverişe başla butonuna tıklanır")
    public void clickStartShopping() {
        clickById(selectorButtonStartShopping);
    }

    @Step("Alışveriş sayfasının açıldığı doğrulanır")
    public void assertShoppingPage() {
        final String expected = "Anasayfa";
        assertEqualsWithSelector(selectorNavHomePage, expected);
    }

    @Step("Kategoriler Sayfası Açılır")
    public void navigateToCategories() {
        clickById(selectorNavigateCategories);
    }
}
