/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import dao.AutorDAO;
import dao.LibroDAO;
import dominio.Autor;
import dominio.Libro;
import java.util.List;

/**
 *
 * @author jaine
 */
public class BibliotecaService {

    private AutorDAO autorDAO = new AutorDAO();
    private LibroDAO libroDAO = new LibroDAO();
     
    public List<Autor> listarAutores() {
        return autorDAO.obtenerTodos();
    }

    public List<Libro> listarLibros() {
        return libroDAO.obtenerTodos();
    }

    public void agregarLibro(Libro libro) throws Exception {
       
        if (libro.getIsbn() == null || libro.getIsbn().isBlank()) {
            throw new Exception("El ISBN no puede estar vacío.");
        }

        libroDAO.insertar(libro);
    }

    public void actualizarLibro(Libro libro) throws Exception {
        if (libro.getIdLibro() <= 0) {
            throw new Exception("El ID del libro no es válido.");
        }
        libroDAO.actualizar(libro);
    }

    public void eliminarLibro(int idLibro) throws Exception {
        if (idLibro <= 0) {
            throw new Exception("El ID del libro no es válido.");
        }
        libroDAO.eliminar(idLibro);
    }
    
    
    public void guardarLibro(int id, String titulo, String autor, int anio) throws Exception {
        if (titulo == null || titulo.isEmpty()) {
            throw new Exception("El título no puede estar vacío");
        }
        if (autor == null || autor.isEmpty()) {
            throw new Exception("El autor no puede estar vacío");
        }
        if (anio <= 0) {
            throw new Exception("El año debe ser mayor a 0");
        }
    }
}
    
    
    
    
    
    
    
    
    
    


