package ru.stellar.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import ru.stellar.pages.HomePage;
import ru.stellar.steps.MenuTabsSteps;

public class MenuTabsTest extends BaseTest {

    private MenuTabsSteps menuTabsSteps;

    @Before
    public void initSteps() {
        menuTabsSteps = new MenuTabsSteps(driver);
    }

    @Test
    @DisplayName("Переход на вкладку «Булки»")
    @Description("Проверяет переключение на вкладку «Булки»")
    public void switchToBuns() {
        HomePage homePage = menuTabsSteps.openHomePage();
        menuTabsSteps.switchToTab(homePage, "Булки");
        menuTabsSteps.assertTabActive(homePage, "Булки");
    }

    @Test
    @DisplayName("Переход на вкладку «Соусы»")
    @Description("Проверяет переключение на вкладку «Соусы»")
    public void switchToSauces() {
        HomePage homePage = menuTabsSteps.openHomePage();
        menuTabsSteps.switchToTab(homePage, "Соусы");
        menuTabsSteps.assertTabActive(homePage, "Соусы");
    }

    @Test
    @DisplayName("Переход на вкладку «Начинки»")
    @Description("Проверяет переключение на вкладку «Начинки»")
    public void switchToFillings() {
        HomePage homePage = menuTabsSteps.openHomePage();
        menuTabsSteps.switchToTab(homePage, "Начинки");
        menuTabsSteps.assertTabActive(homePage, "Начинки");
    }
}