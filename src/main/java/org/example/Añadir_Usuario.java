package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Añadir_Usuario {
    private JLabel titulo; // JLabel para el título
    private JButton volverbtn; // Botón para volver
    private JButton confbtn; // Botón para confirmar
    private JTable table1; // Tabla para mostrar los usuarios
    private JComboBox<String> pais; // ComboBox para seleccionar el país (idioma)
    private JComboBox<String> plataforma; // ComboBox para seleccionar la plataforma
    javax.swing.JPanel JPanel; // JPanel principal
    private JLabel label; // JLabel para mostrar mensajes de error o éxito
    private JTextField correo;
    private JCheckBox adminCheckBox; // Checkbox para indicar si el usuario es administrador

    private DefaultTableModel tableModel; // Modelo de la tabla

    public Añadir_Usuario() {
        // Configuramos el JComboBox de pais con los idiomas
        pais.addItem("Español");
        pais.addItem("Inglés");
        pais.addItem("Francés");
        pais.addItem("Alemán");
        pais.addItem("Portugués");

        //Configuro el ComboBox de las plataformas
        plataforma.addItem("Escritorio");
        plataforma.addItem("Móvil");
        plataforma.addItem("Desconocido");

        // Inicializamos la tabla con columnas
        String[] columnNames = {"Correo", "País", "Plataforma", "Administrador"};
        tableModel = new DefaultTableModel(null, columnNames);
        table1.setModel(tableModel);

        // Acción del botón Confirmar
        confbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmarUsuario();
            }
        });
    }

    private void confirmarUsuario() {
        // Obtengo los valores de los campos
        String correoText = correo.getText(); // Correo ingresado
        String paisSeleccionado = (String) pais.getSelectedItem(); // País (idioma) seleccionado
        String plataformaSeleccionada = (String) plataforma.getSelectedItem(); // Plataforma seleccionada
        boolean esAdmin = adminCheckBox.isSelected();  // Si está seleccionado es administrador

        // Validación: comprobar si algún campo está vacío
        if (correoText.isEmpty() || paisSeleccionado == null || plataformaSeleccionada == null) {
            label.setText("Falta algún campo por completar.");
        } else {
            // Agregar los datos a la tabla
            String adminText = esAdmin ? "Sí" : "No";
            tableModel.addRow(new Object[]{correoText, paisSeleccionado, plataformaSeleccionada, adminText});

            // Mostrar ventana modal con mensaje de confirmación
            String tipoUsuario = esAdmin ? "Administrador" : "No Administrador";
            JOptionPane.showMessageDialog(JPanel, "Usuario " + tipoUsuario + " almacenado correctamente: " + correoText);

            // Reiniciar campos
            reiniciarCampos();
        }
    }

    private void reiniciarCampos() {
        correo.setText(""); // Vaciar el campo de correo
        pais.setSelectedIndex(0); // Reiniciar el combo de país
        plataforma.setSelectedIndex(0); // Reiniciar el combo de plataforma
        adminCheckBox.setSelected(false);  // Reiniciar el checkbox
        label.setText(""); // Limpiar el mensaje de estado
    }
}