package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La clase {@code Añadir_Usuario} representa un formulario para añadir usuarios,
 * con opciones para especificar el correo, país, plataforma, y si el usuario es administrador.
 * También carga una lista de usuarios predefinidos en una tabla al iniciar la ventana.
 */
public class Añadir_Usuario {
    private JTextField correo; // Campo de texto para ingresar el correo
    private JLabel titulo; // Etiqueta que muestra el título del formulario
    private JButton volverbtn; // Botón para regresar o cerrar el formulario
    private JButton confbtn; // Botón para confirmar la creación de un nuevo usuario
    private JTable table1; // Tabla que muestra los usuarios registrados
    private JTextField correoField; // Campo de texto para ingresar el correo
    private JComboBox<String> pais; // ComboBox para seleccionar el país (idioma)
    private JComboBox<String> plataforma; // ComboBox para seleccionar la plataforma (Móvil, Escritorio, etc.)
    javax.swing.JPanel JPanel; // Panel principal que contiene todos los componentes
    private JLabel label; // Etiqueta para mostrar mensajes de error o éxito
    private JCheckBox adminCheckBox; // Checkbox para indicar si el usuario es administrador
    private DefaultTableModel tableModel; // Modelo para gestionar los datos de la tabla

    /**
     * Constructor de la clase {@code Añadir_Usuario}.
     * Inicializa los componentes de la interfaz gráfica, configura los ComboBoxes,
     * carga los datos iniciales predefinidos y añade el listener para el botón Confirmar.
     */
    public Añadir_Usuario() {
        // Configura las opciones disponibles en el JComboBox de pais (idioma)
        pais.addItem("Español");
        pais.addItem("Inglés");
        pais.addItem("Francés");
        pais.addItem("Alemán");
        pais.addItem("Portugués");

        // Configura las opciones disponibles en el JComboBox de plataforma
        plataforma.addItem("Móvil");
        plataforma.addItem("Escritorio");
        plataforma.addItem("Desconocido");

        // Inicializa el modelo de la tabla con los nombres de las columnas
        String[] columnNames = {"Correo", "País", "Plataforma", "Administrador"};
        tableModel = new DefaultTableModel(null, columnNames);
        table1.setModel(tableModel);

        // Carga los datos iniciales de la clase Array al iniciar la ventana
        cargarDatosIniciales();

        // Añade la acción al botón Confirmar
        confbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmarUsuario();
            }
        });
    }

    /**
     * Método que carga los datos iniciales predefinidos de la clase {@code Array} en la tabla.
     * Añade cada usuario a la tabla con las columnas correspondientes.
     */
    private void cargarDatosIniciales() {
        // Recorre los datos predefinidos de la clase Array y los añade a la tabla
        for (Datos dato : Array.datos) {
            String correo = dato.getCorreo();
            String pais = dato.getPais();
            String plataforma = dato.getPlataforma();
            // Agrega la fila a la tabla con "Administrador" marcado como "No"
            tableModel.addRow(new Object[]{correo, pais, plataforma, "No"});
        }
    }

    /**
     * Método que se ejecuta al pulsar el botón Confirmar.
     * Valida si todos los campos están completos, añade el nuevo usuario a la tabla,
     * y muestra un mensaje de confirmación. Si algún campo está vacío, muestra un mensaje de error.
     */
    private void confirmarUsuario() {
        // Obtiene los valores de los campos
        String correoText = correo.getText(); // Correo ingresado
        String paisSeleccionado = (String) pais.getSelectedItem(); // País seleccionado
        String plataformaSeleccionada = (String) plataforma.getSelectedItem(); // Plataforma seleccionada
        boolean esAdmin = adminCheckBox.isSelected(); // Verifica si el checkbox de administrador está marcado

        // Validación: comprueba si algún campo está vacío
        if (correoText.isEmpty() || paisSeleccionado == null || plataformaSeleccionada == null) {
            label.setText("Falta algún campo por completar."); // Mensaje de error
        } else {
            // Agrega los datos del nuevo usuario a la tabla
            String adminText = esAdmin ? "Sí" : "No";
            tableModel.addRow(new Object[]{correoText, paisSeleccionado, plataformaSeleccionada, adminText});

            // Muestra un mensaje de confirmación
            String tipoUsuario = esAdmin ? "Administrador" : "No Administrador";
            JOptionPane.showMessageDialog(JPanel, "Usuario " + tipoUsuario + " almacenado correctamente: " + correoText);

            // Reinicia los campos del formulario
            reiniciarCampos();
        }
    }

    /**
     * Método que reinicia los campos del formulario después de almacenar un usuario.
     * Vacía el campo de correo, resetea los ComboBoxes y el checkbox de administrador.
     */
    private void reiniciarCampos() {
        correo.setText(""); // Vacía el campo de correo
        pais.setSelectedIndex(0); // Resetea el combo de país al primer elemento
        plataforma.setSelectedIndex(0); // Resetea el combo de plataforma al primer elemento
        adminCheckBox.setSelected(false); // Desmarca el checkbox de administrador
        label.setText(""); // Limpia el mensaje de error o éxito
    }
}
