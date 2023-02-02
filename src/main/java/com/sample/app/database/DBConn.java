package com.sample.app.database;

import com.sample.app.utils.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Класс-коннектор к БД.
public class DBConn {

    private static Connection connection = null;

    public static Connection connect() {

        try {
            connection = DriverManager.getConnection(Constants.DB_DRIVER +
                    Constants.DB_BASE_URL + Constants.DB_FILE);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
