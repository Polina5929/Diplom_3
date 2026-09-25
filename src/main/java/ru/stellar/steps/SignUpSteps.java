package ru.stellar.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ru.stellar.pages.AuthPage;
import ru.stellar.pages.HomePage;
import ru.stellar.pages.SignUpPage;

import static org.junit.Assert.assertTrue;

public class SignUpSteps {

    private final WebDriver driver;

    public SignUpSteps(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть главную страницу")
    public HomePage openHomePage() {
        return new HomePage(driver).open();
    }

    @Step("Перейти на форму регистрации")
    public void goToSignUpForm(HomePage homePage) {
        homePage.clickSignIn();
        new AuthPage(driver).goToSignUp();
    }

    @Step("Заполнить и отправить форму регистрации")
    public void fillAndSubmit(String name, String email, String password) {
        new SignUpPage(driver).fillAndSubmit(name, email, password);
    }

    @Step("Проверить, что после регистрации открылась форма входа")
    public void assertAuthPageOpened() {
        assertTrue("Форма входа не открылась после регистрации",
                new AuthPage(driver).isOpened());
    }

    @Step("Проверить, что показана ошибка про некорректный пароль")
    public void assertPasswordErrorShown() {
        assertTrue("Сообщение об ошибке пароля не появилось",
                new SignUpPage(driver).isPasswordErrorVisible());
    }
}