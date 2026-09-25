package ru.stellar.util;

import ru.stellar.model.User;

import java.util.UUID;

public final class TestUserFactory {

    private TestUserFactory() {
    }

    public static String uniqueEmail() {
        return "polina_" + UUID.randomUUID().toString().substring(0, 8) + "@stellar.test";
    }

    public static String uniqueName() {
        return "Polina_" + UUID.randomUUID().toString().substring(0, 6);
    }

    public static String validPassword() {
        return "StellarPass_" + UUID.randomUUID().toString().substring(0, 6);
    }

    public static String shortPassword() {
        return "abc";
    }

    public static User randomUser() {
        return new User(uniqueEmail(), validPassword(), uniqueName());
    }
}