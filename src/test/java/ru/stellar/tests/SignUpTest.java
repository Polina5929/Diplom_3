package ru.stellar.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import ru.stellar.pages.HomePage;
import ru.stellar.steps.SignUpSteps;
import ru.stellar.util.TestUserFactory;

public class SignUpTest extends BaseTest {

    private SignUpSteps signUpSteps;

    @Before
    public void initSteps() {
        signUpSteps = new SignUpSteps(driver);
    }

    @Test
    @DisplayName("Успешная регистрация нового пользователя")
    @Description("Новый пользователь может зарегистрироваться с валидными данными")
    public void successfulSignUp() {
        String email = TestUserFactory.uniqueEmail();
        String name = TestUserFactory.uniqueName();
        String password = TestUserFactory.validPassword();

        HomePage homePage = signUpSteps.openHomePage();
        signUpSteps.goToSignUpForm(homePage);
        signUpSteps.fillAndSubmit(name, email, password);
        signUpSteps.assertAuthPageOpened();
    }

    @Test
    @DisplayName("Ошибка при пароле короче 6 символов")
    @Description("Если пароль короче 6 символов, появляется сообщение об ошибке")
    public void shortPasswordError() {
        String email = TestUserFactory.uniqueEmail();
        String name = TestUserFactory.uniqueName();
        String shortPassword = TestUserFactory.shortPassword();

        HomePage homePage = signUpSteps.openHomePage();
        signUpSteps.goToSignUpForm(homePage);
        signUpSteps.fillAndSubmit(name, email, shortPassword);
        signUpSteps.assertPasswordErrorShown();
    }
}