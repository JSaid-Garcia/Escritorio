/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import dominio.Autor;
import dominio.Libro;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author jainer Said Garcia 
 */

public class LibroDAO {

    // INSERTAR un libro
    public void insertar(Libro libro) {
        String sql = "INSERT INTO Libros (Titulo, IdAutor, Genero, Ano, ISBN) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, libro.getTitulo());
            stmt.setInt(2, libro.getAutor().getIdAutor());
            stmt.setString(3, libro.getGenero());
            stmt.setInt(4, libro.getAnno());
            stmt.setString(5, libro.getIsbn());

            stmt.executeUpdate();
            System.out.println("Libro insertado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // OBTENER todos los libros
    public List<Libro> obtenerTodos() {
        List<Libro> libros = new ArrayList<>();
        String sql = "SELECT l.IdLibro, l.Titulo, l.Genero, l.Anno, l.ISBN, " +
                     "a.IdAutor, a.Nombre, a.Nacionalidad " +
                     "FROM Libros l " +
                     "INNER JOIN Autores a ON l.IdAutor = a.IdAutor";

        try (Connection conn = ConexionBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Autor autor = new Autor(
                        rs.getInt("IdAutor"),
                        rs.getString("Nombre"),
                        rs.getString("Nacionalidad")
                );

                Libro libro = new Libro(
                        rs.getInt("IdLibro"),
                        rs.getString("Titulo"),
                        autor,
                        rs.getString("Genero"),
                        rs.getInt("Anno"),
                        rs.getString("ISBN")
                );

                libros.add(libro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return libros;
    }

    // ACTUALIZAR un libro
    public void actualizar(Libro libro) {
        String sql = "UPDATE Libros SET Titulo=?, IdAutor=?, Genero=?, Anno=?, ISBN=? WHERE IdLibro=?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, libro.getTitulo());
            stmt.setInt(2, libro.getAutor().getIdAutor());
            stmt.setString(3, libro.getGenero());
            stmt.setInt(4, libro.getAnno());
            stmt.setString(5, libro.getIsbn());
            stmt.setInt(6, libro.getIdLibro());

            stmt.executeUpdate();
            System.out.println(" Libro actualizado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ELIMINAR un libro
    public void eliminar(int idLibro) {
        String sql = "DELETE FROM Libros WHERE IdLibro=?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idLibro);
            stmt.executeUpdate();
            System.out.println("Libro eliminado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void guardarLibro(String titulo, String autor, int anio) {
    String sql = "INSERT INTO Libro (titulo, autor, anio) VALUES (?, ?, ?)";
    try (Connection conn = ConexionBD.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, titulo);
        ps.setString(2, autor);
        ps.setInt(3, anio);

        ps.executeUpdate();
        System.out.println("✅ Libro guardado correctamente!");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    
    
    
    
    
    
    
    
    
    
    
}

