/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author jainer Said Garcia Gonzalez
 */
public class Libro {

    private int idLibro;
    private String titulo;
    private Autor autor;
    private String genero;
    private int anno;
    private String ISBN;

    // Constructor
    public Libro(int idLibro, String titulo, Autor autor, String genero, int anno, String ISBN) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anno = anno;
        this.ISBN = ISBN;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }

    public void setAno(int ano) {
        this.anno = anno;
    }

    public int getAno() {
        return anno;
    }

    public void setIsbn(String isbn) {
        this.ISBN = ISBN;
    }

    public String getIsbn() {
        return ISBN;
    }

    @Override
    public String toString() {
        return titulo + " - " + autor.getNombre();
    }

}
