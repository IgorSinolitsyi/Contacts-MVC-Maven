package com.sample.app.controllers;

import com.sample.app.models.AppModel;
import com.sample.app.utils.Constants;
import com.sample.app.views.AppView;

public class AppController {

    AppModel model;
    AppView view;

    public AppController(AppModel model, AppView view) {
        this.model = model;
        this.view = view;
    }

    public void runApp() {
        filterChoice(view.chooseOption());
    }

    private void filterChoice(int choice) {
        switch (choice) {
            case 1 -> model.createContact();
            case 2 -> model.readContacts();
            case 3 -> model.updateContact();
            case 4 -> model.deleteContact();
            case 0 -> {
                String output = Constants.APP_CLOSED_MSG;
                view.getOutput(output, choice);
            }
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        }
    }
}
