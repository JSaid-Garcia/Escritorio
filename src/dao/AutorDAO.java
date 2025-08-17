/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dominio.Autor;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author jainer Said Garcia Gonzalez
 */

public class AutorDAO {
    public List<Autor> obtenerTodos() {
        List<Autor> autores = new ArrayList<>();
        String sql = "SELECT * FROM Autores";
        try (Connection conn = ConexionBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Autor autor = new Autor(
                    rs.getInt("IdAutor"),
                    rs.getString("Nombre"),
                    rs.getString("Nacionalidad")
                );
                autores.add(autor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return autores;
    }
}
