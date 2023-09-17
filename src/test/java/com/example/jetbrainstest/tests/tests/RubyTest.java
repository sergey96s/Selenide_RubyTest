package com.example.jetbrainstest.tests.tests;
// page_url = https://www.jetbrains.com/ruby/

import com.example.jetbrainstest.pages.rubypage.RubyPage;
import com.example.jetbrainstest.tests.MyExtension;
import com.example.jetbrainstest.tests.pages.RubyFeaturesPage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MyExtension.class)
public class RubyTest extends BaseTest {
    private final static String BASE_URL = "https://www.jetbrains.com/ruby/";
    RubyPage getRubyPage = new RubyPage(BASE_URL);
    RubyFeaturesPage getRubyFeaturesPage = new RubyFeaturesPage(BASE_URL);

    @BeforeEach
    @Override
    @Step
    public void setUp() {
        super.setUp();
        open("https://www.jetbrains.com/ruby/");
    }

    @Test
    @DisplayName("Проверка, что кнопка скачивания активна")
    public void buttonCheck() {
        assertTrue(getRubyPage.checkIfDownloadButtonIsClickable(), "Кнопка скачивания не активна");
    }

    @Test
    @DisplayName("Проверка урла после клика по кнопке 'RubyMine'")
    public void checkUrlAfterClickRubyMineButton() {
        getRubyPage.clickRubyMineButton();
        assertEquals(getRubyPage.сheckUrl(), "https://www.jetbrains.com/ruby/", "Урл не тот");
    }

    @Test
    @DisplayName("Проверка активности кнопки акции на бесплатные 30 дней")
    public void buttonPromotionCheck() {
        assertTrue(getRubyPage.checkPromotionButtonIsClickable(), "Кнопка акции не активна");
    }

    @Test
    @DisplayName("Проверка видимости первого скриншота")
    public void firstScreenshotIsVisible() {
        assertTrue(getRubyPage.checkFirstScreenshotIsVisible(), "Первый скриншот не виден");
    }

    @Test
    @DisplayName("Проверка, что в разделе 'Why Ruby' 6 фото")
    public void checkScreenshotInWhyBlock() {
        assertEquals(getRubyPage.getCountOfScreenshotsInWhyBlock(), 6, "Количество скриншотов в блоке 'Why Ruby' не равно 6");
    }

    @Test
    @DisplayName("Проверка активности кнопки 'See all feature'")
    public void buttonFeatureCheck() {
        assertTrue(getRubyPage.checkFeatureButtonIsClickable(), "Кнопка 'See all feature' не активна");
    }

    @Test
    @DisplayName("Проверка урла после клика по кнопке 'See all feature'")
    public void checkUrlAfterClickFeatureButton() {
        assertEquals(getRubyPage.clickFeatureButtonCheckUrl(), "https://www.jetbrains.com/ruby/features/", "Урл не тот");
    }

    @Test
    @DisplayName("Проверка активности кнопки 'Discover All the New Features'")
    public void buttonNewFeatureCheck() {
        assertTrue(getRubyPage.checkNewFeatureButtonIsClickable(), "Кнопка 'See all feature' не активна");
    }

    @Test
    @DisplayName("Проверка урла после клика по кнопке 'Discover All the New Features'")
    public void checkUrlAfterClickNewFeatureButton() {
        assertEquals(getRubyPage.clickNewFeatureButtonCheckUrl(), "https://www.jetbrains.com/ruby/whatsnew/", "Урл не тот");
    }

    @Test
    @DisplayName("Проверка видимости баннера, переводящего на страницу со статистикой использования разработчиками")
    public void statisticBannerIsVisible() {
        assertTrue(getRubyPage.checkStatisticBannerIsVisible(), ",Баннер не виден");
    }

    @Test
    @DisplayName("Проверка активности кнопки-баннера 'Nearly half of Ruby developers use RubyMine'")
    public void bannerStatisticCheck() {
        assertTrue(getRubyPage.checkStatisticBannerIsClickable(), "Баннер 'Nearly half of Ruby developers use RubyMine' не кликабелен");
    }

    @Test
    @DisplayName("Проверка урла после клика по кнопке-баннеру 'Nearly half of Ruby developers use RubyMine'")
    public void checkUrlAfterClickStatisticBanner() {
        assertEquals(getRubyPage.clickStatisticBannerCheckUrl(), "https://www.jetbrains.com/lp/devecosystem-2021/ruby/", "Урл не тот");
    }

    @Test
    @DisplayName("Проверка, количества заголовков на боковой панели")
    public void checkPointsSideBar() {
        getRubyPage.clickFeaturesButton();
        assertEquals(getRubyFeaturesPage.getCountOfPointsSideBar(), 10, "Заголовков в боковой панели не 10");
    }

    @Test
    @DisplayName("Проверка доступности кнопки скачивания в формате .exe(Windows)")
    public void checkEnabledDownloadExeButton() {
        getRubyPage.clickFeaturesButton();
        getRubyFeaturesPage.clickListExe();
        assertTrue(getRubyFeaturesPage.checkWindowsExeDownloadButton(), "Кнопка скачивания в формате .exe (Windows) недоступна");
    }

    @Test
    @DisplayName("Проверка количества скриншотов на странице Features")
    public void checkCountOfImgFeatures() {
        getRubyPage.clickFeaturesButton();
        assertEquals(getRubyFeaturesPage.getCountOfImgFeatures(), 48, "Изображений не 48");
    }

    @Test
    @DisplayName("Проверка видимости кнопки 'More' в блоке 'Autocomplete'")
    public void checkIsDisplayedButtonMoreIsAutocomplete() {
        getRubyPage.clickFeaturesButton();
        assertTrue(getRubyFeaturesPage.checkVisibledButtonMoreIsAutocomplete(), "Кнопка 'More' в блоке 'Autocomplete' не отображается");
    }

    @Test
    @DisplayName("Проверка доступности кнопки 'More' в блоке 'Autocomplete'")
    public void checkEnabledButtonMoreIsAutocomplete() {
        getRubyPage.clickFeaturesButton();
        assertTrue(getRubyFeaturesPage.checkButtonMoreIsAutocomplete(), "Кнопка 'More' в блоке 'Autocomplete' недоступна");
    }

    @Test
    @DisplayName("Проверка видимости кнопки '.exe (Windows ARM64)' в выпадающем списке")
    public void checkIfDisplayedWindowsArm64ExeDownloadButton() {
        getRubyPage.clickFeaturesButton();
        getRubyFeaturesPage.clickListExe();
        assertTrue(getRubyFeaturesPage.checkWindowsArm64ExeDownloadButton(), "Кнопка '.exe (Windows ARM64)' в выпадающем списке не отображается");
    }

    @ParameterizedTest(name = "#{index} - проверка на невалидность email {0}")
    @CsvSource({"rtfg", "vcb@sd", "sd.2e@d"})
    @DisplayName("Проверка сообщения при вводе невалидного email")
    public void enterInvalidBussinesEmail(String email) {
        String invalidBussinesEmailMessage = getRubyPage.enterInvalidBussinesEmailAndGetWarning(email);
        assertEquals(invalidBussinesEmailMessage, "Please enter a valid email address.", "Сообщение о необходимости ввести валидный email не соответствует ожидаемому");
    }

    @Test
    @DisplayName("Проверка сообщения при вводе пустого email")
    public void enterEmptyBussinesEmail() {
        String emptyBussinesEmailMessage = getRubyPage.enterEmptyBussinesEmailAndGetWarning("");
        assertEquals(emptyBussinesEmailMessage, "This field is required.", "Сообщение о необходимости заполнить поле email не соответствует ожидаемому");
    }
}