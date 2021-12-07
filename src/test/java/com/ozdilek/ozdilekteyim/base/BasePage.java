package com.ozdilek.ozdilekteyim.base;

import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage extends BaseTest {

    public static final By selectorGoBack = By.id("com.ozdilek.ozdilekteyim:id/ivBack");

    public WebElement waitForLoad(By selector) {
        try {
            appiumFluentWait.until(ExpectedConditions.elementToBeClickable(selector));
            return appiumDriver.findElement(selector);
        } catch (TimeoutException te) {
            logger.info(String.format("%s elemanı bulunanadı", selector.toString()));
            return null;
        }
    }

    public MobileElement waitForLoad(MobileElement selector) {
        try {
            appiumFluentWait.until(ExpectedConditions.elementToBeClickable(selector));
            return selector;
        } catch (TimeoutException te) {
            logger.info(String.format("%s elemanı bulunanadı", selector.toString()));
            return null;
        }
    }

    public void clickById(By selector) {
        waitForLoad(selector).click();
        logger.info(String.format("Clicked to the element with selector id: %s", selector));
    }

    public void clickById(MobileElement element) {
        MobileElement mobileElement = waitForLoad(element);
        String bounds = element.getAttribute("bounds");
        mobileElement.click();
        logger.info(String.format("Clicked to the element within the bounds: %s", bounds));
    }

    public void sendKeysBy(By selector, String keys) {
        waitForLoad(selector).sendKeys(keys);
        logger.info(String.format("Typed %s to the '%s'", keys, selector));
    }

    public void assertEqualsWithSelector(By selector, String expected) {
        String actual = getText(selector);
        Assertions.assertEquals(expected.toLowerCase(), actual.toLowerCase(), "Doğrulama başarısız");
        logger.info(String.format("%s metni bulundu @%s", expected, selector));
    }

    public MobileElement getElementFromList(By selector, int index) {
        List<MobileElement> elements = appiumDriver.findElements(selector);
        return waitForLoad(elements.get(index));
    }

    public boolean pageHasElementsWithBy(By selector) {
        try {
            waitForLoad(selector);
            return true;
        } catch (TimeoutException te) {
            return false;
        }
    }

    public String getText(By selector) {
        return waitForLoad(selector).getText();
    }

    @Step("Geri butonuna tıklanır")
    public void goBack() {
        clickById(selectorGoBack);
    }

    @Step("<seconds> saniye beklenir")
    public void wait(int seconds) throws InterruptedException {
        TimeUnit.SECONDS.sleep(seconds);
    }
}
