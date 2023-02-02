package com.sample.app.models;

import com.sample.app.database.DBCheck;
import com.sample.app.database.DBConn;
import com.sample.app.database.entities.Contact;
import com.sample.app.utils.Constants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ContactCreateModel {

    public String createContact(Contact contact) {
        // Проверяем на наличие файла БД.
        // Если ДА, вносим данные и уведомляем об этом,
        // НЕТ - уведомление об отсутствии БД.
        if (DBCheck.isDBExists()) {
            return addData(contact);
        } else {
            return Constants.DB_ABSENT_MSG;
        }
    }

    private String addData(Contact contact) {

        String sql = "INSERT INTO " + Constants.TABLE_NAME + "(name, phone) VALUES(?, ?)";

        try ( Connection connection = DBConn.connect();
              // PreparedStatement - подготовленное выражение,
              // чтобы избежать SQL-инъекций
              PreparedStatement pstmt = connection.prepareStatement(sql)
        ) {
            pstmt.setString(1, contact.getName());
            pstmt.setString(2, contact.getPhone());
            pstmt.executeUpdate();
            return Constants.DATA_INSERT_MSG;
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
}
