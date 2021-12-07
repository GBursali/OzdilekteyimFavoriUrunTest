package com.ozdilek.ozdilekteyim.base;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class BaseTest {
    protected static AndroidDriver<MobileElement> appiumDriver;
    protected static WebDriverWait appiumFluentWait;
    protected static Logger logger = Logger.getLogger(BaseTest.class);


    @BeforeScenario
    public void setUp() throws MalformedURLException {
        final String deviceName = "34cda0f";
        final String appPackage = "com.ozdilek.ozdilekteyim";
        final String appActivity = appPackage + ".MainActivity";
        final URL url = new URL("http://127.0.0.1:4723/wd/hub");

        System.out.println("Android  testi başlıyor");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,deviceName);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,appPackage);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,appActivity);
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 3000);
        appiumDriver = new AndroidDriver<>(url, desiredCapabilities);
        appiumFluentWait = new WebDriverWait(appiumDriver,10);

        DOMConfigurator.configure("log4j.xml");
        logger.info("-----Test flow started-------");
    }
    @AfterScenario
    public void afterScenario() {
        if(appiumDriver != null)
            appiumDriver.quit();
    }

}