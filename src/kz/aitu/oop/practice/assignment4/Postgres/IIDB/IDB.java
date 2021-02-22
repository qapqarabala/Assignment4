package kz.aitu.oop.practice.assignment4.Postgres.IIDB;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDB {
    Connection getConnection() throws SQLException, ClassNotFoundException;
}
