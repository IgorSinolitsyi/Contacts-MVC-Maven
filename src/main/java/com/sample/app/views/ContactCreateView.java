package com.sample.app.views;

import com.sample.app.database.entities.Contact;
import com.sample.app.utils.NameValidator;
import com.sample.app.utils.PhoneValidator;

import java.util.Scanner;

public class ContactCreateView {

    Contact contact;
    String title;
    Scanner scanner;

    public Contact doInputs() {

        scanner = new Scanner(System.in);
        contact = new Contact();

        // Ввод и валидация данных

        title = "Name: ";
        System.out.print(title);
        contact.setName(NameValidator.validateNameInput(scanner));

        title = "Phone in format xxx xxx-xxxx: ";
        System.out.print(title);
        contact.setPhone(PhoneValidator.validatePhoneInput(scanner));

        return contact;
    }

    // Вывод уведомления
    public void getOutput(String output) {
        System.out.println(output);
    }
}
