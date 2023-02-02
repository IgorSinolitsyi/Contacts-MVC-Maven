package com.sample.app.utils;

import com.sample.app.controllers.MessageController;

import java.util.Scanner;

public class NameValidator {

    // Валидация ввода имени
    public static String validateNameInput(Scanner scanner) {
        String str = scanner.nextLine().trim();
        while (str.isEmpty()) {
            MessageController.out(Constants.NAME_EMPTY_MSG);
            str = scanner.nextLine().trim();
        }
        return str;
    }
}
