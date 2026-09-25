package ru.stellar.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import ru.stellar.pages.HomePage;
import ru.stellar.steps.AuthSteps;
import ru.stellar.util.TestUserFactory;

public class AuthTest extends BaseTest {

    private AuthSteps authSteps;
    private String email;
    private String password;

    @Before
    public void initUser() {
        authSteps = new AuthSteps(driver);
        email = TestUserFactory.uniqueEmail();
        password = TestUserFactory.validPassword();
        String name = TestUserFactory.uniqueName();
        createdUserToken = apiClient.createUser(email, password, name);
    }

    @Test
    @DisplayName("Вход через кнопку «Войти в аккаунт» на главной")
    @Description("Проверяет вход через кнопку «Войти в аккаунт»")
    public void signInViaHomeButton() {
        HomePage homePage = authSteps.openHomePage();
        authSteps.clickSignInOnHome(homePage);
        authSteps.login(email, password);
        authSteps.assertLoginSuccess(homePage);
    }

    @Test
    @DisplayName("Вход через ссылку «Личный Кабинет»")
    @Description("Проверяет вход через ссылку «Личный Кабинет»")
    public void signInViaPersonalAccount() {
        HomePage homePage = authSteps.openHomePage();
        authSteps.clickPersonalAccount(homePage);
        authSteps.login(email, password);
        authSteps.assertLoginSuccess(homePage);
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    @Description("Проверяет вход через кнопку в форме регистрации")
    public void signInViaSignUpForm() {
        HomePage homePage = authSteps.openHomePage();
        authSteps.clickPersonalAccount(homePage);
        authSteps.goToSignInFromSignUp();
        authSteps.login(email, password);
        authSteps.assertLoginSuccess(homePage);
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Description("Проверяет вход через кнопку в форме восстановления пароля")
    public void signInViaRecoveryForm() {
        HomePage homePage = authSteps.openHomePage();
        authSteps.clickPersonalAccount(homePage);
        authSteps.goToSignInFromRecovery();
        authSteps.login(email, password);
        authSteps.assertLoginSuccess(homePage);
    }
}