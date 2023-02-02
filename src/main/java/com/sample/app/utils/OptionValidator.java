package com.sample.app.utils;

import com.sample.app.controllers.MessageController;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class OptionValidator {

    // Валидация ввода номера опции действия
    public static int validateOptionInput(Scanner scanner) {

        //Коллекция для выбора действий
        Set<Integer> options = new HashSet<>(Arrays.asList(1, 2, 3, 4, 0));

        while (!scanner.hasNextInt()) {
            String str = scanner.nextLine().trim();
            MessageController.out(String.format(Constants.NAN_NUMBER_MSG, str));
        }

        int inputData = scanner.nextInt();

        while (!options.contains(inputData)) {
            MessageController.out("\n"+Constants.NO_SUCH_OPTION_MSG);
            while (!scanner.hasNextInt()) {
                String str = scanner.next().trim();
                MessageController.out(String.format(Constants.NAN_NUMBER_MSG, str));
            }
            inputData = scanner.nextInt();
        }
        return inputData;
    }
}
