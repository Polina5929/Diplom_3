package ru.stellar.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ru.stellar.pages.AuthPage;
import ru.stellar.pages.HomePage;
import ru.stellar.pages.SignUpPage;

import static org.junit.Assert.assertTrue;

public class AuthSteps {

    private final WebDriver driver;

    public AuthSteps(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть главную страницу")
    public HomePage openHomePage() {
        return new HomePage(driver).open();
    }

    @Step("Клик по кнопке «Войти в аккаунт» на главной")
    public void clickSignInOnHome(HomePage homePage) {
        homePage.clickSignIn();
    }

    @Step("Клик по ссылке «Личный Кабинет»")
    public void clickPersonalAccount(HomePage homePage) {
        homePage.clickPersonalAccount();
    }

    @Step("Перейти к форме входа из формы регистрации")
    public void goToSignInFromSignUp() {
        AuthPage authPage = new AuthPage(driver);
        authPage.goToSignUp();
        new SignUpPage(driver).goToSignIn();
    }

    @Step("Перейти к форме входа из формы восстановления пароля")
    public void goToSignInFromRecovery() {
        AuthPage authPage = new AuthPage(driver);
        authPage.goToPasswordRecovery();
        authPage.goToSignIn();
    }

    @Step("Авторизоваться с email={email}")
    public void login(String email, String password) {
        new AuthPage(driver).login(email, password);
    }

    @Step("Проверить, что авторизация прошла успешно")
    public void assertLoginSuccess(HomePage homePage) {
        assertTrue("Логин не выполнен — конструктор не отображается",
                homePage.isBurgerConstructorVisible());
    }
}