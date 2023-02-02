package com.sample.app.utils;

import com.sample.app.database.DBConn;
import com.sample.app.database.entities.Contact;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class IdValidator {

    // Валидация ввода ID
    public static int validateIdInput(Scanner scanner) {

        int id;
        String str1 = null;

        while (!scanner.hasNextInt()) {
            String str = scanner.nextLine().trim();
            System.out.printf(Constants.NAN_NUMBER_MSG, str);
        }
        id = scanner.nextInt();
        while (id <= 0) {
            System.out.println(Constants.INCORRECT_VALUE_MSG);
            while (!scanner.hasNextInt()) {
                try {
                    str1 = scanner.next().trim();
                } catch (InputMismatchException ime) {
                    System.out.printf(Constants.NAN_NUMBER_MSG, str1);
                }
            }
            id = scanner.nextInt();
        }
        return id;
    }

    // проверка наличия ID в БД
    public static boolean isIdExists(Contact contact) {

        try {
            String query = "SELECT COUNT(id) FROM " + Constants.TABLE_NAME + " WHERE id = ?";
            PreparedStatement pst = DBConn.connect().prepareStatement(query);
            pst.setInt(1, contact.getId());

            try (ResultSet rs = pst.executeQuery()) {
                // Ожидаем только один результат
                if (rs.next()) {
                    return rs.getBoolean(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
