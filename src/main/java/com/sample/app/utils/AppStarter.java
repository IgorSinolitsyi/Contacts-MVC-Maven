package com.sample.app.utils;

import com.sample.app.controllers.AppController;
import com.sample.app.controllers.ActionChoiceController;
import com.sample.app.views.AppView;

public class AppStarter {

    public static void startApp() {
        AppController appController = new AppController();
        AppView appView = new AppView();
        ActionChoiceController controller = new ActionChoiceController(appController, appView);
        controller.runApp();
    }
}
