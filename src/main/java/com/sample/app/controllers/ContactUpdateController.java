package com.sample.app.controllers;

import com.sample.app.models.ContactUpdateModel;
import com.sample.app.utils.AppStarter;
import com.sample.app.utils.Constants;
import com.sample.app.views.ContactUpdateView;

public class ContactUpdateController {

    ContactUpdateModel model;
    ContactUpdateView view;

    public ContactUpdateController(ContactUpdateModel model, ContactUpdateView view) {
        this.model = model;
        this.view = view;
    }

    public void updateContact() {

        // Вносим данные и получаем сообщение.
        String str = model.updateContact(view.doInputs());
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
