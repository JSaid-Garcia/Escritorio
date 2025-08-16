/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author jainer Said Garcia
 */
public class Autor {
    private int idAutor;
    private String nombre;
    private String nacionalidad;

    // Constructor
    public Autor(int idAutor, String nombre, String nacionalidad) {
        this.idAutor = idAutor;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

  /**
     * @Override Method of toString() of Java Library
     *  toString Method
     * @return String
   **/

    @Override
    public String toString() {
        return nombre + " (" + nacionalidad + ")";
    }
}




