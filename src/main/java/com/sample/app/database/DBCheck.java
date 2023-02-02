package com.sample.app.database;

import com.sample.app.utils.Constants;

import java.io.File;

// Класс-проверка наличия файла БД.
public class DBCheck {

    public static boolean isDBExists() {
        String filePath = Constants.DB_BASE_URL + Constants.DB_FILE;
        File dbFilePath = new File(filePath);
        return dbFilePath.exists();
    }
}
