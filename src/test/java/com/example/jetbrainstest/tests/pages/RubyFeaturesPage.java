package com.example.jetbrainstest.tests.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.example.jetbrainstest.tests.AllureLogger;
import com.example.jetbrainstest.tests.tests.BaseTest;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class RubyFeaturesPage extends BaseTest {
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(RubyFeaturesPage.class));

    public RubyFeaturesPage(String url) {
        Selenide.open(url);
    }

    private List<SelenideElement> sideBar = $$x("//li/a[contains(@data-test,'toc-item')]");
    private SelenideElement exeListButton = $x("//button[contains(@class,'_main_12yxkch_17 _modeClassic_12yxkch_135 _sizeM_12yxkch_99 _alignIconRight_12yxkch_81 _light_12yxkch_59 _flatLeft_12yxkch_130 _withIcon_12yxkch_119 _wtDownloadButton__right_7zoad _wtDownloadButton__right_95rvc')]");
    private SelenideElement exeWindowsDownloadButton = $x("//span[contains(text(), '.exe (Windows)')]");
    private List<SelenideElement> imgFeatures = $$x("//div[contains(@class, 'f-img')]");
    private SelenideElement buttonMoreIsAutocomplete = $x("//a[contains(@href, 'https://www.jetbrains.com/help/ruby/auto-completing-code.html')]");
    private SelenideElement exeWindowsArm64DownloadButton = $x("//span[contains(text(), '.exe (Windows ARM64)')]");

    public Integer getCountOfPointsSideBar() {
        LOG.info("Проверка, что на боковой панели 10 заголовков");
        return sideBar.size();
    }

    public void clickListExe() {
        LOG.info("Клик по выпадающему списку .exe");
        exeListButton.click();
    }

    public boolean checkWindowsExeDownloadButton() {
        LOG.info("Проверка работоспособности кнопки '.exe (Windows)' в выпадающем списке");
        return exeWindowsDownloadButton.isEnabled();
    }

    public Integer getCountOfImgFeatures() {
        LOG.info("Проверка количества изображений на странице");
        return imgFeatures.size();
    }

    public boolean checkButtonMoreIsAutocomplete() {
        LOG.info("Проверка работоспособности кнопки 'More' в блоке 'Autocomplete'");
        return buttonMoreIsAutocomplete.isEnabled();
    }

    public boolean checkVisibledButtonMoreIsAutocomplete() {
        LOG.info("Проверка видимости кнопки 'More' в блоке 'Autocomplete'");
        return buttonMoreIsAutocomplete.isDisplayed();
    }

    public boolean checkWindowsArm64ExeDownloadButton() {
        LOG.info("Проверка видимости кнопки '.exe (Windows ARM64)' в выпадающем списке");
        return exeWindowsArm64DownloadButton.isDisplayed();
    }
}
