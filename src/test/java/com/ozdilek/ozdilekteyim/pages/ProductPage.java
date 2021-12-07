package com.ozdilek.ozdilekteyim.pages;

import com.ozdilek.ozdilekteyim.base.BasePage;
import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ProductPage extends BasePage {

    public static final By selectorContainer = By.id("com.ozdilek.ozdilekteyim:id/categoryTab");
    public static final By selectorProducts = By.id("com.ozdilek.ozdilekteyim:id/imageView");

    @Step("Sayfanın en aşagasına doğru iki kere scrol edilir.")
    public void scrollTwice() throws InterruptedException {
        waitForLoad(selectorContainer);

        for (int i = 0; i < 2; i++) {

            TouchAction t = new TouchAction(appiumDriver);
            t.press(PointOption.point(537, 1860))
                    .moveTo(PointOption.point(537, 310))
                    .release().perform().wait(500);
        }
    }

    @Step("Ürünlerden rasgele bir ürün seçilir.")
    public void selectRandomProduct() throws InterruptedException {
        Random rng = new Random();
        int size  = appiumDriver.findElements(selectorProducts).size();
        int index = rng.nextInt(size);
        clickById(getElementFromList(selectorProducts,index));
        TimeUnit.SECONDS.sleep(2);
    }



}
