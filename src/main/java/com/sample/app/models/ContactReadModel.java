package com.sample.app.models;

import com.sample.app.database.DBCheck;
import com.sample.app.database.DBConn;
import com.sample.app.database.entities.Contact;
import com.sample.app.utils.Constants;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContactReadModel {

    List<Contact> list;

    public List<Contact> readContacts() {
        // Проверяем на наличие файла БД.
        // Если ДА, читаем данные,
        // НЕТ - устанавливаем коллекцию в null.
        if (DBCheck.isDBExists()) {
            list = readData();
        } else {
            list = null;
        }
        return list;
    }

    private List<Contact> readData() {

        String sql = "SELECT id, name, phone FROM " + Constants.TABLE_NAME;

        try (Connection connection = DBConn.connect();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)
        ) {
            list = new ArrayList<>();

            while (rs.next()) {
                list.add(new Contact(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("phone")
                        )
                );
            }
            // Возвращаем коллекцию данных
            return list;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            // Если ошибка - возвращаем пустую коллекцию
            return Collections.emptyList();
        }
    }
}
