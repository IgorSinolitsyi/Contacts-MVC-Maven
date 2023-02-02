package com.sample.app.views;

import com.sample.app.database.entities.Contact;
import com.sample.app.utils.IdValidator;

import java.util.Scanner;

public class ContactDeleteView {

    public Contact doInput() {

        Scanner scanner = new Scanner(System.in);
        Contact contact = new Contact();

        // Ввод и валидация данных
        String title = "Contact's ID: ";
        System.out.print(title);
        contact.setId(IdValidator.validateIdInput(scanner));

        return contact;
    }

    // Вывод уведомления
    public void getOutput(String output) {
        System.out.println(output);
    }
}
