package com.sample.app.views;

import com.sample.app.database.entities.Contact;
import com.sample.app.utils.IdValidator;
import com.sample.app.utils.PhoneValidator;

import java.util.Scanner;


// Здесь применено решение для чтения String после int.
// scanner.nextLine();
//
// Scanner не видит ввод в виде нескольких строк, как мы.
// Вместо этого он получает «поток символов».
// Когда вызываем nextInt, он считывает символы, пока не дойдет
// до нецифры.
// Например, int id = 2, String phone = 555 123-4567.
// Scanner читает  2\n555 123-4567\n
//
// nextInt возвращает 2.
// Затем программа отображает "Enter new phone: "
// и вызывает nextLine, который считывает символы,
// пока не дойдет до новой строки.
// Но так как следующий символ уже является новой строкой,
// nextLine возвращает пустую строку "".
//
// Чтобы решить эту проблему, нужна дополнительная nextLine
// после nextInt.
public class ContactUpdateView {

    Contact contact;
    String title;
    Scanner scanner;

    public Contact doInputs() {

        scanner = new Scanner(System.in);
        contact = new Contact();

        // Ввод и валидация данных

        title = "Contact's ID: ";
        System.out.print(title);
        contact.setId(IdValidator.validateIdInput(scanner));

        scanner.nextLine();

        title = "New phone: ";
        System.out.print(title);
        contact.setPhone(PhoneValidator.validatePhoneInput(scanner));

        return contact;
    }

    // Вывод уведомления
    public void getOutput(String output) {
        System.out.println(output);
    }
}
