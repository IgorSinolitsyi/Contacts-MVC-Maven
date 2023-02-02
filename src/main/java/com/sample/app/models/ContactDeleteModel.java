package com.sample.app.models;

import com.sample.app.database.DBCheck;
import com.sample.app.database.DBConn;
import com.sample.app.database.entities.Contact;
import com.sample.app.utils.Constants;
import com.sample.app.utils.IdValidator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContactDeleteModel {

    public String deleteContact(Contact contact) {
        // Проверяем на наличие файла БД.
        // Если ДА, удаляем данные и уведомляем об этом,
        // НЕТ - уведомление об отсутствии БД.
        if (DBCheck.isDBExists()) {
            return deleteData(contact);
        } else {
            return Constants.DB_ABSENT_MSG;
        }
    }

    // Удаление по id, при условии его наличия в БД.
    // Если ДА - удаляем и выводим сообщение об удалении,
    // НЕТ - выводим сообщение об отсутствии id.
    private String deleteData(Contact contact) {

        if (IdValidator.isIdExists(contact)) {

            String sql = "DELETE FROM " + Constants.TABLE_NAME + " WHERE id = ?";

            try (Connection connection = DBConn.connect();
                 // PreparedStatement - подготовленное выражение,
                 // чтобы избежать SQL-инъекций
                 PreparedStatement stmt = connection.prepareStatement(sql)
            ) {
                // установка соответствующих параметров
                stmt.setInt(1, contact.getId());
                // выполнение запроса в БД
                stmt.executeUpdate();
                return Constants.DATA_DELETE_MSG;
            } catch (SQLException e) {
                return e.getMessage();
            }
        } else {
            return Constants.WRONG_ID_MSG;
        }
    }
}
