package com.udemy.java.assertj.test;

import org.testng.annotations.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

public class PasswordValidator {

//    public static void main(String[] args) {
//        String pass = generatePassword(8);
//        passwordValidation(pass);
//    }

    @Test
    public void checkPassword() {
        String pass = generatePassword(8);
        passwordValidation(pass);
    }

    private static String generatePassword(int length) {
        StringBuilder password = new StringBuilder(length);
        Random random = new Random(System.nanoTime());

        for (int i = 0; i < length; i++) {
            String charCategory = charCategories[random.nextInt(charCategories.length)];
            int position = random.nextInt(charCategory.length());
            password.append(charCategory.charAt(position));
        }

        return new String(password);
    }

    private static final String[] charCategories = new String[]{
            "abcdefghijklmnopqrstuvwxyz",
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
            "0123456789"
    };

    public static String provideValidPassword(int length) {

        String initPass;
        boolean flag;

        do {
            initPass = generatePassword(length);
            flag = isPasswordValid(initPass);
        } while (!flag);

        return initPass;
    }


    private static void passwordValidation(String password) {
        assertSoftly(softAssertions -> {
            softAssertions.assertThat(password.chars())
            .hasSize(8)
            .anyMatch(Character::isUpperCase)
            .anyMatch(Character::isLowerCase)
            .anyMatch(Character::isDigit);
        });
    }


    private static boolean isPasswordValid(String password) {
        boolean upperCase = !password.equals(password.toLowerCase());
        boolean lowerCase = !password.equals(password.toUpperCase());
        boolean isAtLeast8 = password.length() >= 8;
        boolean hasNumber = password.matches(".*\\d+.*");

        if (!isAtLeast8) {
            return false;
        } else if (!upperCase) {
            return false;
        } else if (!lowerCase) {
            return false;
        } else if (!hasNumber) {
            return false;
        } else {
            return true;
        }
    }
}
