package com.sample.app.controllers;

import com.sample.app.models.ContactDeleteModel;
import com.sample.app.utils.AppStarter;
import com.sample.app.utils.Constants;
import com.sample.app.views.ContactDeleteView;

public class ContactDeleteController {

    ContactDeleteModel model;
    ContactDeleteView view;

    public ContactDeleteController(ContactDeleteModel model, ContactDeleteView view) {
        this.model = model;
        this.view = view;
    }

    public void deleteContact() {

        // Вносим данные и получаем сообщение.
        String str = model.deleteContact(view.doInput());
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
