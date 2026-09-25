package ru.stellar.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends BasePage {

    private final By nameField = By.xpath("//input[@name='name']");
    private final By emailField = By.xpath("//label[text()='Email']/following-sibling::input");
    private final By passwordField = By.xpath("//input[@name='Пароль']");
    private final By signUpButton = By.xpath("//button[text()='Зарегистрироваться']");
    private final By passwordError = By.xpath("//p[text()='Некорректный пароль']");
    private final By signInLink = By.xpath("//a[text()='Войти']");

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @Step("Ввести имя: {name}")
    public void enterName(String name) {
        type(nameField, name);
    }

    @Step("Ввести email: {email}")
    public void enterEmail(String email) {
        type(emailField, email);
    }

    @Step("Ввести пароль")
    public void enterPassword(String password) {
        type(passwordField, password);
    }

    @Step("Клик по кнопке «Зарегистрироваться»")
    public void clickSignUp() {
        click(signUpButton);
    }

    @Step("Заполнить и отправить форму регистрации")
    public void fillAndSubmit(String name, String email, String password) {
        enterName(name);
        enterEmail(email);
        enterPassword(password);
        clickSignUp();
    }

    @Step("Проверить, что ошибка «Некорректный пароль» отображается")
    public boolean isPasswordErrorVisible() {
        return isDisplayed(passwordError);
    }

    @Step("Перейти по ссылке «Войти»")
    public void goToSignIn() {
        click(signInLink);
    }
}