package ru.stellar.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthPage extends BasePage {

    private final By emailField = By.xpath("//input[@name='name']");
    private final By passwordField = By.xpath("//input[@name='Пароль']");
    private final By signInButton = By.xpath("//button[text()='Войти']");
    private final By signUpLink = By.xpath("//a[text()='Зарегистрироваться']");
    private final By restorePasswordLink = By.xpath("//a[text()='Восстановить пароль']");
    private final By signInLink = By.xpath("//a[text()='Войти']");

    public AuthPage(WebDriver driver) {
        super(driver);
    }

    @Step("Ввести email: {email}")
    public void enterEmail(String email) {
        type(emailField, email);
    }

    @Step("Ввести пароль")
    public void enterPassword(String password) {
        type(passwordField, password);
    }

    @Step("Клик по кнопке «Войти»")
    public void clickSignIn() {
        click(signInButton);
    }

    @Step("Авторизоваться с email={email}")
    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickSignIn();
    }

    @Step("Перейти на форму регистрации")
    public void goToSignUp() {
        click(signUpLink);
    }

    @Step("Перейти на форму восстановления пароля")
    public void goToPasswordRecovery() {
        click(restorePasswordLink);
    }

    @Step("Перейти по ссылке «Войти»")
    public void goToSignIn() {
        click(signInLink);
    }

    @Step("Проверить, что страница входа открыта")
    public boolean isOpened() {
        return isDisplayed(signInButton);
    }
}