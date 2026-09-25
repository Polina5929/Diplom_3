package ru.stellar.api;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import ru.stellar.model.User;
import ru.stellar.util.AppConfig;

import static io.restassured.RestAssured.given;

public class StellarApiClient {

    private static final String REGISTER = "/api/auth/register";
    private static final String USER = "/api/auth/user";

    @Step("Создание пользователя через API с email={user.email}")
    public String createUser(User user) {
        Response response = given()
                .baseUri(AppConfig.getBaseUrl())
                .contentType("application/json")
                .body(user)
                .when()
                .post(REGISTER);

        if (response.statusCode() == 200) {
            return response.then().extract().path("accessToken");
        }
        return null;
    }

    @Step("Удаление пользователя через API")
    public void deleteUser(String accessToken) {
        if (accessToken == null) {
            return;
        }
        given()
                .baseUri(AppConfig.getBaseUrl())
                .contentType("application/json")
                .header("Authorization", accessToken)
                .when()
                .delete(USER);
    }
}