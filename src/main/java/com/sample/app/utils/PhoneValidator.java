package com.sample.app.utils;

import com.sample.app.controllers.MessageController;

import java.util.Scanner;

public class PhoneValidator {

    // Валидация ввода телефона
    public static String validatePhoneInput(Scanner scanner) {
        String input = scanner.nextLine().trim();
        while (input.isEmpty() || !input.matches(Constants.PHONE_RGX)) {
            MessageController.out("Constants.WRONG_PHONE_MSG");
            input = scanner.nextLine().trim();
        }
        return input;
    }
}
