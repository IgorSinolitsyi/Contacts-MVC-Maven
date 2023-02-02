Contacts-MVC-Maven
=========================
Проект использует паттерн MVC.
В проекте реализованы базовые CRUD операции
по работе с локальной SQLite БД.

1) Создаем Maven-проект.
В Advanced Settings можем оставить так или прописать
com.sample.app

2) В pom.xml добавляем зависимость SQLite JDBC Driver
https://mvnrepository.com/artifact/org.xerial/sqlite-jdbc
Проект SQLite JDBC Driver
https://github.com/xerial/sqlite-jdbc

3) В src/main/resources создаем папку database

4) Через DB Browser for SQLite (https://sqlitebrowser.org/),
в src/main/resources/database, создаем файл БД (contactsdb.db).

5) Через DB Browser for SQLite создаем таблицу в БД (contacts)

SQL-запрос на создание таблицы:

CREATE TABLE contacts (
  id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  name TEXT NOT NULL,
  phone TEXT NOT NULL
)

ВНИМАНИЕ. После манипуляций в базе данных,
в DB Browser for SQLite, записываем изменения.

6) В src/main/java/com/sample/app создаем пакеты, классы.
Пишем код.

7) Проверяем функционал проекта.

