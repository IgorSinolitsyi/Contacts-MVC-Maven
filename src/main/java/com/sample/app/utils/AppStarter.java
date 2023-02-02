package com.sample.app.utils;

import com.sample.app.controllers.AppController;
import com.sample.app.models.AppModel;
import com.sample.app.views.AppView;

public class AppStarter {

    public static void startApp() {
        AppModel appModel = new AppModel();
        AppView appView = new AppView();
        AppController controller = new AppController(appModel, appView);
        controller.runApp();
    }
}
