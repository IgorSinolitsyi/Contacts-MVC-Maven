package com.sample.app.models;

import com.sample.app.controllers.ContactCreateController;
import com.sample.app.controllers.ContactDeleteController;
import com.sample.app.controllers.ContactReadController;
import com.sample.app.controllers.ContactUpdateController;
import com.sample.app.views.ContactCreateView;
import com.sample.app.views.ContactDeleteView;
import com.sample.app.views.ContactReadView;
import com.sample.app.views.ContactUpdateView;

public class AppModel {

    public void createContact() {
        ContactCreateModel model = new ContactCreateModel();
        ContactCreateView view = new ContactCreateView();
        ContactCreateController controller = new ContactCreateController(model, view);
        controller.addContact();
    }

    public void readContacts() {
        ContactReadModel model = new ContactReadModel();
        ContactReadView view = new ContactReadView();
        ContactReadController controller = new ContactReadController(model, view);
        controller.getContacts();
    }

    public void updateContact() {
        ContactUpdateModel model = new ContactUpdateModel();
        ContactUpdateView view = new ContactUpdateView();
        ContactUpdateController controller = new ContactUpdateController(model, view);
        controller.updateContact();
    }

    public void deleteContact() {
        ContactDeleteModel model = new ContactDeleteModel();
        ContactDeleteView view = new ContactDeleteView();
        ContactDeleteController controller = new ContactDeleteController(model, view);
        controller.deleteContact();
    }
}
