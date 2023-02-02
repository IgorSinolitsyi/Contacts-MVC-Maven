package com.sample.app.controllers;

import com.sample.app.utils.Constants;
import com.sample.app.views.AppView;

public class ActionChoiceController {

    AppController controller;
        AppView view;

        public ActionChoiceController(AppController controller, AppView view) {
            this.controller = controller;
            this.view = view;
        }

        public void runApp() {
            filterChoice(view.chooseOption());
        }

        private void filterChoice(int choice) {
            switch (choice) {
                case 1 -> controller.createContact();
                case 2 -> controller.readContacts();
                case 3 -> controller.updateContact();
                case 4 -> controller.deleteContact();
                case 0 -> {
                    String output = Constants.APP_CLOSED_MSG;
                    view.getOutput(output, choice);
                }
                default -> throw new IllegalStateException("Unexpected value: " + choice);
            }
        }
    }

