/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import dominio.Autor;
import dominio.Libro;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import servicios.BibliotecaService;

/**
 *
 * @author jaine
 */
public class VentanaPrincipal extends JFrame {
        
    private BibliotecaService service = new BibliotecaService();
    private JTable tablaLibros;

    public VentanaPrincipal() {
        setTitle(" Biblioteca Personal");
        setSize(700, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        
        JButton btnVerAutores = new JButton("Ver Autores");
        JButton btnVerLibros = new JButton("Ver Libros");
        JButton btnAgregarLibro = new JButton("Agregar Libro");

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnVerAutores);
        panelBotones.add(btnVerLibros);
        panelBotones.add(btnAgregarLibro);

       
        tablaLibros = new JTable();
        JScrollPane scrollPane = new JScrollPane(tablaLibros);

        
        setLayout(new BorderLayout());
        add(panelBotones, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        
        btnVerLibros.addActionListener(e -> mostrarLibros());
        btnVerAutores.addActionListener(e -> mostrarAutores());
        btnAgregarLibro.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, 
                "Aquí abrirías un formulario para agregar un libro");
            
            
            
            
            
            
        });
    }

    private void mostrarLibros() {
        List<Libro> libros = service.listarLibros();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Titulo");
        model.addColumn("Autor");
        model.addColumn("Genero");
        model.addColumn("Anno");
        model.addColumn("ISBN");

        for (Libro l : libros) {
            model.addRow(new Object[]{
                l.getIdLibro(), 
                l.getTitulo(),
                l.getAutor().getNombre(),
                l.getGenero(),
                l.getAnno(),
                l.getIsbn()
            });
        }

        tablaLibros.setModel(model);
    }

    private void mostrarAutores() {
        List<Autor> autores = service.listarAutores();
        StringBuilder sb = new StringBuilder("Autores:\n");
        for (Autor a : autores) {
            sb.append("- ").append(a.getNombre())
              .append(" (").append(a.getNacionalidad()).append(")\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString());
    }
}
