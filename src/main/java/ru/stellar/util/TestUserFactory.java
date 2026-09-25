package ru.stellar.util;

import java.util.UUID;

public final class TestUserFactory {

    private TestUserFactory() {
    }

    public static String uniqueEmail() {
        long stamp = System.currentTimeMillis();
        String uid = UUID.randomUUID().toString().substring(0, 8);
        return "polina_" + stamp + "_" + uid + "@stellar.test";
    }

    public static String uniqueName() {
        return "Polina_" + System.currentTimeMillis();
    }

    public static String validPassword() {
        return "StellarPass_" + System.currentTimeMillis();
    }

    public static String shortPassword() {
        return "abc";
    }
}