package com.ozdilek.ozdilekteyim.pages;

import com.ozdilek.ozdilekteyim.base.BasePage;
import com.thoughtworks.gauge.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class CategoryPage extends BasePage {

    public static final By selectorTabAssertionBrands = By.xpath("//*[@text='Markalar']");
    public static final By selectorListCategories = By.id("com.ozdilek.ozdilekteyim:id/relLayCategoriesItem");

    @Step("Kategoriler Sayfasının açıldığı doğrulanır")
    public void assertPageIsCategory() {
        String expected = "Markalar";
        assertEqualsWithSelector(selectorTabAssertionBrands,expected);
    }

    @Step("menüden “Kadın” Seçeneğine tıklanır")
    public void selectFromMenu() {
        clickById(getElementFromList(selectorListCategories,1));
    }

    @Step("“pantolon” kategorisi açılır")
    public void selectCategory() {
        clickById(getElementFromList(selectorListCategories,3));
    }
}
