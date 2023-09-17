package com.example.jetbrainstest.pages.rubypage;


import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.example.jetbrainstest.tests.AllureLogger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.net.URL;
import java.util.List;
import static com.codeborne.selenide.Selenide.*;
public class RubyPage {
    private final AllureLogger LOG = LoggerFactory.getLogger(RubyPage.class);

//    public RubyPage(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//    }

    private SelenideElement rubyMineButton = $(".menu-second-title-box__title.wt-h3");
    private SelenideElement downloadButton = $("a[data-test='button'][href ='/ruby/download/']");
    private SelenideElement promotionButton = $x("//a[contains(text(), 'Get free 30‐day trial')]");
    private SelenideElement firstScreenshot = $("img[src ='/ruby/img/screenshots/smart_editor@2x.png']")
    private List<SelenideElement> screenshotsInWhyBlock = $$x("//div[contains(@class,'wt-container wt-offset-top-96')]");
    private SelenideElement featureButton = $("a[data-test='button'][href = '/ruby/features/']");
    private SelenideElement newFeatureButton = $("a[data-test='button'][href = '/ruby/whatsnew/']");
    private SelenideElement statisticRubyBanner = $x("//a[contains(@class, " +
            "'in-place-banner in-place-banner_ruby wt-h3 wt-h3_theme_dark banner js-banner inplace-banner')]");
    private SelenideElement inputEmail = $x("//input[contains(@placeholder, 'Business email address')]");
    private SelenideElement buttonRequestACall = $x("//button[contains(text(), 'Request a call')]");
    private SelenideElement errorMessageInvalidEmail = $x("//div[contains(text(), " +
            "'Please enter a valid email address.')]");
    private SelenideElement errorMessageEmptyEmail = $x("//div[contains(text(), 'This field is required.')]");
    public Boolean checkIfDownloadButtonIsClickable() {
        LOG.info("Проверка активности кнопки загрузки");
        return downloadButton.isEnabled();
    }
    public RubyPage(String url){
        Selenide.open(url);
    }
    public void clickFeaturesButton() {
        LOG.info("Переход на страницу Features");
        featureButton.click();
    }

    public void clickRubyMineButton() {
        LOG.info("Клик по кнопке 'RubyMine'");
        rubyMineButton.click();
    }

    public String сheckUrl() {
        LOG.info("Проверка урла страницы");
        return URL;
    }
    /**
     * Не знаю как получить URL
     */
    public Boolean checkPromotionButtonIsClickable() {
        LOG.info("Проверка активности кнопки акции");
        return promotionButton.isEnabled();
    }

    public Boolean checkFirstScreenshotIsVisible() {
        LOG.info("Проверка отображения первого скриншота");
        return firstScreenshot.isDisplayed();
    }

    public Integer getCountOfScreenshotsInWhyBlock() {
        LOG.info("Проверка количества скриншотов в блоке Why Ruby");
        return screenshotsInWhyBlock.size();
    }

    public Boolean checkFeatureButtonIsClickable() {
        LOG.info("Проверка активности кнопки 'See All Features'");
        return featureButton.isEnabled();
    }

    public String clickFeatureButtonCheckUrl() {
        featureButton.click();
        LOG.info("Проверка урла страницы при переходе по кнопке 'See all feature'");
        return driver.getCurrentUrl();
    }

    public Boolean checkNewFeatureButtonIsClickable() {
        LOG.info("Проверка активности кнопки 'Discover All the New Features'");
        return newFeatureButton.isEnabled();
    }

    public String clickNewFeatureButtonCheckUrl() {
        newFeatureButton.click();
        LOG.info("Проверка урла страницы при переходе по кнопке 'Discover All the New Features'");
        return driver.getCurrentUrl();
    }

    public Boolean checkStatisticBannerIsClickable() {
        LOG.info("Проверка активности кнопки 'Nearly half of Ruby developers use RubyMine'");
        return statisticRubyBanner.isEnabled();
    }

    public Boolean checkStatisticBannerIsVisible() {
        LOG.infoWithScreenshot("Проверка видимости баннера, переводящего на страницу со статистикой использования разработчиками");
        return statisticRubyBanner.isDisplayed();
    }

    public String clickStatisticBannerCheckUrl() {
        statisticRubyBanner.click();
        LOG.info("Проверка урла страницы при переходе по кнопке 'Nearly half of Ruby developers use RubyMine'");
        return driver.getCurrentUrl();
    }

    public void enterBussinesEmail(String email) {
        LOG.infoWithScreenshot("Ввод email");
        inputEmail.sendKeys(email);
        buttonRequestACall.click();
    }

    public String enterInvalidBussinesEmailAndGetWarning(String email) {
        enterBussinesEmail(email);
        LOG.infoWithScreenshot("Получение сообщения при вводе невалидного email");
        return errorMessageInvalidEmail.getText();
    }

    public String enterEmptyBussinesEmailAndGetWarning(String email) {
        enterBussinesEmail(email);
        LOG.infoWithScreenshot("Получение сообщения при вводе пустого email");
        return errorMessageEmptyEmail.getText();
    }


}
