package ru.stellar.api;

import com.google.gson.Gson;
import io.restassured.response.Response;
import ru.stellar.util.AppConfig;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class StellarApiClient {

    private static final String REGISTER = "/api/auth/register";
    private static final String USER = "/api/auth/user";

    private final Gson gson = new Gson();

    public String createUser(String email, String password, String name) {
        Map<String, String> payload = new HashMap<>();
        payload.put("email", email);
        payload.put("password", password);
        payload.put("name", name);

        Response response = given()
                .baseUri(AppConfig.getBaseUrl())
                .contentType("application/json")
                .body(gson.toJson(payload))
                .when()
                .post(REGISTER);

        if (response.statusCode() == 200) {
            return response.then().extract().path("accessToken");
        }
        return null;
    }

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