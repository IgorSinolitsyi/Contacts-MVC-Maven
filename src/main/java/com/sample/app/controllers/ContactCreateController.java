package com.sample.app.controllers;

import com.sample.app.database.entities.Contact;
import com.sample.app.models.ContactCreateModel;
import com.sample.app.utils.AppStarter;
import com.sample.app.utils.Constants;
import com.sample.app.views.ContactCreateView;

public class ContactCreateController {

    ContactCreateModel model;
    ContactCreateView view;
    Contact contact;

    public ContactCreateController(ContactCreateModel model, ContactCreateView view) {
        this.model = model;
        this.view = view;
    }

    public void addContact() {

        contact = view.doInputs();
        // Вносим данные и получаем сообщение.
        String str = model.createContact(contact);
        // Проверяем сообщение на внесение данных.
        // Если БД отсутствует, выводим сообщение об этом
        // и закрываем приложение.
        // Иначе выводим сообщение и перезапускаем приложение.
        if (str.equals(Constants.DB_ABSENT_MSG)) {
            // Выводим уведомление.
            view.getOutput(str);
            // Закрываем приложение.
            System.exit(0);
        } else {
            // Выводим уведомление.
            view.getOutput(str);
            // Перезапускаем приложение.
            AppStarter.startApp();
        }
    }
}
