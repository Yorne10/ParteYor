/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modPrimSeg;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Interfaz2 extends JFrame {

    private final JTable tablaPersonas;
    private final JTextField campBusq;

    public Interfaz2(List<Persona> personas) {
        // ventana
        setTitle("Mostar Cliente");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.RED); // Fondo rojo

        // Panel principal 
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBackground(Color.WHITE);

        // Panel de búsqueda
        JPanel panelBusqueda = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelBusqueda.setBackground(Color.RED); // Fondo rojo

        JLabel etiquetaBusqueda = new JLabel("Buscar:");
        etiquetaBusqueda.setForeground(Color.WHITE);
        panelBusqueda.add(etiquetaBusqueda);

        campBusq = new JTextField();
        campBusq.setPreferredSize(new Dimension(150, 25));
        panelBusqueda.add(campBusq);

        // Botón búsqueda
        JButton buscarButton = new JButton("Buscar");
        buscarButton.addActionListener(e -> buscarPersona());
        panelBusqueda.add(buscarButton);

        panelPrincipal.add(panelBusqueda, BorderLayout.NORTH);

        //  modelo  tabla
        String[] columnas = {"Nombre Completo", "Fecha de Nacimiento", "Género", "Dirección", "Teléfono", "Correo"};
        Object[][] datos = convertirDatos(personas);
        DefaultTableModel modeloTabla = new DefaultTableModel(datos, columnas);

        //  tabla
        tablaPersonas = new JTable(modeloTabla);
        tablaPersonas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //  JScrollPane para la tabla
        JScrollPane scroll = new JScrollPane(tablaPersonas);
        panelPrincipal.add(scroll, BorderLayout.CENTER);

        // Mostrar la ventana
        add(panelPrincipal);
        setVisible(true);
    }

    private Object[][] convertirDatos(List<Persona> personas) {
        Object[][] datos = new Object[personas.size()][6];

        for (int i = 0; i < personas.size(); i++) {
            Persona persona = personas.get(i);
            datos[i][0] = persona.getNombreCompleto();
            datos[i][1] = persona.getFechaNacimiento();
            datos[i][2] = persona.getGenero();
            datos[i][3] = persona.getDireccion();
            datos[i][4] = persona.getTelefono();
            datos[i][5] = persona.getCorreo();
        }

        return datos;
    }

    private void buscarPersona() {
        String textoBusqueda = campBusq.getText().toLowerCase();
        TableRowSorter<TableModel> clasificarFilas = new TableRowSorter<>(tablaPersonas.getModel());
        tablaPersonas.setRowSorter(clasificarFilas);

        if (textoBusqueda.trim().length() == 0) {
            clasificarFilas.setRowFilter(null);
        } else {
            clasificarFilas.setRowFilter(RowFilter.regexFilter(textoBusqueda));
        }
    }

    public static void main(String[] args) {

        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Juan Pérez", "01/01/1990", "Hombre", "Calle A", "123456789", "juan@gmail.com"));
        personas.add(new Persona("María López", "15/05/1985", "Mujer", "Calle B", "987654321", "maria@gmail.com"));

        // Crear la interfaz2 con la lista de personas
        SwingUtilities.invokeLater(() -> new Interfaz2(personas));
    }
}
