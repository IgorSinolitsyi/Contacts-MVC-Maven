package com.sample.app.utils;

public class Constants {

    // Регулярное выражение
    // для формата номера телефона xxx xxx-xxxx
    public final static String PHONE_RGX = "[0-9]{3}[\\ ][0-9]{3}-[0-9]{4}";

    public final static String DB_DRIVER = "jdbc:sqlite:";
    public final static String DB_BASE_URL = "src/main/resources/database/";
    public final static String DB_FILE = "contactsdb.db";
    public final static String TABLE_NAME = "contacts";
    public final static String DB_ABSENT_MSG = "\n>> No database!";
    public final static String DATA_ABSENT_MSG = "\n>> No data.";
    public final static String DATA_INSERT_MSG = "\n>> Data entered.";
    public final static String DATA_UPDATE_MSG = "\n>> Updated.";
    public final static String DATA_DELETE_MSG = "\n>> Deleted.";
    public final static String APP_CLOSED_MSG = "\n>> App closed.";
    public final static String NO_SUCH_OPTION_MSG = "There is no such option! Try again: ";
    public final static String NAME_EMPTY_MSG = "Empty! Please enter a name: ";
    public final static String WRONG_PHONE_MSG = "Wrong phone format! Try again: ";
    public final static String NAN_NUMBER_MSG = "\"%s\" - not a number!%nTry again: ";
    public final static String INCORRECT_VALUE_MSG = "Incorrect value! Try again: ";
    public final static String WRONG_ID_MSG = "\n>> Wrong ID!";
}
