package com.sample.app.utils;

import java.util.Scanner;

public class NameValidator {

    // Валидация ввода имени
    public static String validateNameInput(Scanner scanner) {
        String str = scanner.nextLine().trim();
        while (str.isEmpty()) {
            System.out.print(Constants.NAME_EMPTY_MSG);
            str = scanner.nextLine().trim();
        }
        return str;
    }
}
