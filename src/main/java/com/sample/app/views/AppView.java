package com.sample.app.views;

import com.sample.app.utils.OptionValidator;

import java.util.Scanner;

public class AppView {

    Scanner scanner;

    public int chooseOption() {

        scanner = new Scanner(System.in);

        System.out.print("""
                --------------------------
                Choose an option:
                1 - Add a contact.
                2 - View contacts.
                3 - Update the contact's phone number.
                4 - Delete contact.
                0 - Close the app.
                """);

        return OptionValidator.validateOptionInput(scanner);
    }

    public void getOutput(String output, int choice) {
        if (choice == 0) System.out.println(output);
        // Scanner лучше закрыть здесь,
        // т.к. в этом методе завершаем программу.
        scanner.close();
        System.exit(0);
    }
}
