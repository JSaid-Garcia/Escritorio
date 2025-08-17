/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import dominio.Autor;
import dominio.Libro;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import servicios.BibliotecaService;

/**
 *
 * @author jainer Said Garcia 
 */
public class LibroForm extends JDialog {

    private BibliotecaService service = new BibliotecaService();

    private JTextField txtTitulo = new JTextField(20);
    private JComboBox<Autor> comboAutores = new JComboBox<>();
    private JTextField txtGenero = new JTextField(20);
    private JTextField txtAno = new JTextField(5);
    private JTextField txtISBN = new JTextField(15);

    private JButton btnGuardar = new JButton("Guardar");
    private JButton btnCancelar = new JButton("Cancelar");

    public LibroForm(JFrame parent) {
        super(parent, "Agregar Libro", true);
        setSize(400, 300);
        setLayout(new GridLayout(6, 2, 5, 5));
        setLocationRelativeTo(parent);

       
        List<Autor> autores = service.listarAutores();
        for (Autor a : autores) {
            comboAutores.addItem(a);
        }

        
        add(new JLabel("Titulo:"));
        add(txtTitulo);

        add(new JLabel("Autor:"));
        add(comboAutores);

        add(new JLabel("Genero:"));
        add(txtGenero);

        add(new JLabel("Anno:"));
        add(txtAno);

        add(new JLabel("ISBN:"));
        add(txtISBN);

        add(btnGuardar);
        add(btnCancelar);

       
        btnGuardar.addActionListener(e -> guardarLibro());
        btnCancelar.addActionListener(e -> dispose());
    }

    private void guardarLibro() {
        try {
            String titulo = txtTitulo.getText().trim();
            Autor autor = (Autor) comboAutores.getSelectedItem();
            String genero = txtGenero.getText().trim();
            int ano = Integer.parseInt(txtAno.getText().trim());
            String isbn = txtISBN.getText().trim();

            // Validaciones básicas
            if (titulo.isEmpty() || isbn.isEmpty()) {
                throw new Exception("El título y el ISBN son obligatorios.");
            }

            Libro libro = new Libro(0, titulo, autor, genero, ano, isbn);
            service.agregarLibro(libro);

            JOptionPane.showMessageDialog(this, " Libro agregado correctamente.");
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, " Error: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}