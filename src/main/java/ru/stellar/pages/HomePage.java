package ru.stellar.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.stellar.util.AppConfig;

public class HomePage extends BasePage {

    private final By signInButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By personalAccountLink = By.xpath("//p[text()='Личный Кабинет']");
    private final By bunsTab = By.xpath("//div[contains(@class,'tab_tab')][.//span[text()='Булки']]");
    private final By saucesTab = By.xpath("//div[contains(@class,'tab_tab')][.//span[text()='Соусы']]");
    private final By fillingsTab = By.xpath("//div[contains(@class,'tab_tab')][.//span[text()='Начинки']]");
    private final By activeTabText = By.xpath("//div[contains(@class,'tab_tab_type_current')]/span");
    private final By burgerTitle = By.xpath("//h1[text()='Соберите бургер']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Открыть главную страницу")
    public HomePage open() {
        super.open(AppConfig.getBaseUrl());
        return this;
    }

    @Step("Клик по кнопке «Войти в аккаунт»")
    public void clickSignIn() {
        click(signInButton);
    }

    @Step("Клик по ссылке «Личный Кабинет»")
    public void clickPersonalAccount() {
        click(personalAccountLink);
    }

    @Step("Перейти на вкладку «Булки»")
    public void clickBunsTab() {
        click(bunsTab);
        waitForActiveTab("Булки");
    }

    @Step("Перейти на вкладку «Соусы»")
    public void clickSaucesTab() {
        click(saucesTab);
        waitForActiveTab("Соусы");
    }

    @Step("Перейти на вкладку «Начинки»")
    public void clickFillingsTab() {
        click(fillingsTab);
        waitForActiveTab("Начинки");
    }

    @Step("Проверить, что заголовок конструктора отображается")
    public boolean isBurgerConstructorVisible() {
        return isDisplayed(burgerTitle);
    }

    @Step("Получить название активной вкладки")
    public String getActiveTabName() {
        return getText(activeTabText);
    }

    @Step("Дождаться, что активна вкладка «{tabName}»")
    public void waitForActiveTab(String tabName) {
        By activeTabByText = By.xpath(String.format(
                "//div[contains(@class,'tab_tab')][contains(@class,'tab_tab_type_current')][.//span[text()='%s']]",
                tabName));
        wait.until(ExpectedConditions.visibilityOfElementLocated(activeTabByText));
    }
}