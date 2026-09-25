package ru.stellar.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ru.stellar.pages.HomePage;

import static org.junit.Assert.assertEquals;

public class MenuTabsSteps {

    private final WebDriver driver;

    public MenuTabsSteps(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть главную страницу")
    public HomePage openHomePage() {
        return new HomePage(driver).open();
    }

    @Step("Перейти на вкладку «{tabName}»")
    public void switchToTab(HomePage homePage, String tabName) {
        switch (tabName) {
            case "Булки":
                homePage.clickBunsTab();
                break;
            case "Соусы":
                homePage.clickSaucesTab();
                break;
            case "Начинки":
                homePage.clickFillingsTab();
                break;
            default:
                throw new IllegalArgumentException("Неизвестная вкладка: " + tabName);
        }
    }

    @Step("Проверить, что вкладка «{tabName}» активна")
    public void assertTabActive(HomePage homePage, String tabName) {
        assertEquals("Активная вкладка не совпадает с ожидаемой",
                tabName, homePage.getActiveTabName());
    }
}