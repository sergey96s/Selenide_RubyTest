package com.example.jetbrainstest.tests;

import com.example.jetbrainstest.tests.tests.BaseTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class AllureAttachmentsManager {

    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] screenshot() {
        BaseTest baseTest = new BaseTest();
        return ((TakesScreenshot) BaseTest.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
    /**
     * Опять же getDriver, который больше не используется. Чем заменить?
     */
}
