/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jainer Said Garcia Gonzalez
 */
public class ConexionBD {

    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=Biblioteca;encrypt=true;trustServerCertificate=true;";
    private static final String USER = "Said";
    private static final String PASSWORD = "123456";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
