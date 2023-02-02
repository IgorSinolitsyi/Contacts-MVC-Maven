package com.sample.app.models;

import com.sample.app.controllers.MessageController;
import com.sample.app.database.DBCheck;
import com.sample.app.database.DBConn;
import com.sample.app.database.entities.Contact;
import com.sample.app.utils.Constants;
import com.sample.app.utils.IdValidator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContactUpdateModel {

    public String updateContact(Contact contact) {
        // Проверяем на наличие файла БД.
        // Если ДА, обновляем данные и уведомляем об этом,
        // НЕТ - уведомление об отсутствии БД.
        if (DBCheck.isDBExists()) {
            return updateData(contact);
        } else {
            return Constants.DB_ABSENT_MSG;
        }
    }

    // Обновление по id, при условии его наличия в БД.
    // Если ДА - обновляем и выводим сообщение об удалении,
    // НЕТ - выводим сообщение об отсутствии id.
    private String updateData(Contact contact) {

        if (IdValidator.isIdExists(contact)) {

            String sql = "UPDATE " + Constants.TABLE_NAME + " SET phone = ? WHERE id = ?";

            try (Connection connection = DBConn.connect();
                 // PreparedStatement - подготовленное выражение,
                 // чтобы избежать SQL-инъекций
                 PreparedStatement pstmt = connection.prepareStatement(sql)
            ) {
                pstmt.setString(1, contact.getPhone());
                pstmt.setInt(2, contact.getId());
                pstmt.executeUpdate();
                return Constants.DATA_UPDATE_MSG;
            } catch (SQLException e) {
                return e.getMessage();
            }
        } else {
            return Constants.WRONG_ID_MSG;
        }
    }
}
