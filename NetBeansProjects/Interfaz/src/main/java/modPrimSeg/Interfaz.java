/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package modPrimSeg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Interfaz extends JFrame {

    private final JTextField nombreCompletoCamp, fechaNacimientoCamp, direccionCamp, telefonoCamp, correoCamp;
    private JRadioButton generoHombre, generoMujer;

    public Interfaz() {
        // la ventana
        setTitle("Nuevo Cliente");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.RED); // Fondo rojo

        // Panel 
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setBackground(Color.WHITE);

        // campos de texto
        panelPrincipal.add(crearPanel("Nombre Completo:", nombreCompletoCamp = new JTextField()));
        panelPrincipal.add(crearPanel("Fecha de Nacimiento (dd/mm/yy):", fechaNacimientoCamp = new JTextField()));
        panelPrincipal.add(crearGeneroPanel());
        panelPrincipal.add(crearPanel("Dirección de Domicilio:", direccionCamp = new JTextField()));
        panelPrincipal.add(crearPanel("Número Telefónico:", telefonoCamp = new JTextField()));
        panelPrincipal.add(crearPanel("Correo Electrónico:", correoCamp = new JTextField()));

        // Botones  guardar y cancelar
        JButton guardarButton = new JButton("Guardar");
        guardarButton.addActionListener((ActionEvent e) -> {
            if (camposLlenos()) {
                // aquí se guardan los datos
                guardarDatos();
            } else {
                //  alerta de llenado
                JOptionPane.showMessageDialog(Interfaz.this, "Debe llenar todos los campos", "Alerta", JOptionPane.WARNING_MESSAGE);
            }
        });

        JButton cancelarButton = new JButton("Cancelar");
        cancelarButton.addActionListener((ActionEvent e) -> {
            // Cancelar y sale de la interfaz
            System.exit(0);
        });

        // Agregar componentes al contenedor principal
        add(panelPrincipal, BorderLayout.CENTER);

        // Panel  botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBotones.setBackground(Color.RED); // Fondo rojo
        panelBotones.add(guardarButton);
        panelBotones.add(cancelarButton);
        add(panelBotones, BorderLayout.SOUTH);

        
        setVisible(true);
    }

    private JPanel crearPanel(String label, JTextField textField) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBackground(Color.WHITE);

        JLabel etiqueta = new JLabel(label);
        etiqueta.setForeground(Color.BLACK);
        panel.add(etiqueta);

        textField.setPreferredSize(new Dimension(200, 25));
        panel.add(textField);

        return panel;
    }

    private JPanel crearGeneroPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBackground(Color.WHITE);

        JLabel etiqueta = new JLabel("Género:");
        etiqueta.setForeground(Color.BLACK);
        panel.add(etiqueta);

        generoHombre = new JRadioButton("Hombre");
        generoHombre.setBackground(Color.WHITE);
        generoMujer = new JRadioButton("Mujer");
        generoMujer.setBackground(Color.WHITE);

        ButtonGroup grupoGenero = new ButtonGroup();
        grupoGenero.add(generoHombre);
        grupoGenero.add(generoMujer);

        panel.add(generoHombre);
        panel.add(generoMujer);

        return panel;
    }

    private boolean camposLlenos() {
        return !nombreCompletoCamp.getText().isEmpty() &&
                !fechaNacimientoCamp.getText().isEmpty() &&
                (generoHombre.isSelected() || generoMujer.isSelected()) &&
                !direccionCamp.getText().isEmpty() &&
                !telefonoCamp.getText().isEmpty() &&
                !correoCamp.getText().isEmpty();
    }

    private void guardarDatos() {
        // Lógica para guardar los datos
        String nombreCompleto = nombreCompletoCamp.getText();
        String fechaNacimiento = fechaNacimientoCamp.getText();
        String genero = generoHombre.isSelected() ? "Hombre" : "Mujer";
        String direccion = direccionCamp.getText();
        String telefono = telefonoCamp.getText();
        String correo = correoCamp.getText();

        // Puedes realizar más acciones según tus necesidades

        // Ejemplo de impresión de datos
        System.out.println("Nombre Completo: " + nombreCompleto);
        System.out.println("Fecha de Nacimiento: " + fechaNacimiento);
        System.out.println("Género: " + genero);
        System.out.println("Dirección: " + direccion);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Correo Electrónico: " + correo);

        // Cierra la interfaz después de guardar los datos
        System.exit(0);
    }

    public static void main(String[] args) {
        // Utilizar el gestor de eventos de Swing en un hilo seguro
        SwingUtilities.invokeLater(Interfaz::new);
    }
}
