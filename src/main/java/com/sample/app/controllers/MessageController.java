package com.sample.app.controllers;

import com.sample.app.views.MessageView;

public class MessageController {
    public static void out(String message){
        MessageView.showMessage(message);
    }
}
