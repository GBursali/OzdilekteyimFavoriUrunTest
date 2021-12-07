package com.ozdilek.ozdilekteyim.pages;

import com.ozdilek.ozdilekteyim.base.BasePage;
import com.thoughtworks.gauge.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class ProductDetailPage extends BasePage {
    public static final By selectorProductDetailImage = By.id("com.ozdilek.ozdilekteyim:id/iv");
    public static final By selectorButtonFavourite = By.id("com.ozdilek.ozdilekteyim:id/imgFav");
    public static final By selectorButtonAddToCart = By.id("com.ozdilek.ozdilekteyim:id/relLayAddCartBtn");

    @Step("Ürün detay sayfası açıldığı kontrol edilir.")
    public void assertProductDetailPageOpened() {
        boolean hasElement = pageHasElementsWithBy(selectorProductDetailImage);
        Assertions.assertTrue(hasElement);
    }

    @Step("favoriler butonuna tıklanır.")
    public void clickOnFavorites() {
        clickById(selectorButtonFavourite);
    }

    @Step("Seçilen ürün sepete eklenir.")
    public void addToCart(){
        clickById(selectorButtonAddToCart);
    }
}

