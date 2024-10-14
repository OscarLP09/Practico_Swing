package org.example;

import javax.swing.*;

/**
 * La clase {@code Main} es el punto de entrada para la aplicación.
 * Esta clase inicializa una ventana de tipo {@code JFrame} y le asigna el contenido del formulario {@code Añadir_Usuario}.
 *
 * <p>El formulario se muestra centrado en la pantalla y es visible tras su inicialización.</p>
 */
public class Main {

    /**
     * El método principal que arranca la aplicación.
     *
     * @param args Los argumentos de línea de comandos (no utilizados en esta aplicación).
     */
    public static void main(String[] args) {
        // Crear un nuevo JFrame titulado "Formulario"
        JFrame frame = new JFrame("Formulario");

        // Asignar el panel principal del formulario 'Añadir_Usuario' al JFrame
        frame.setContentPane(new Añadir_Usuario().JPanel);

        // Configurar el cierre de la ventana cuando se presiona el botón cerrar
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Centrar la ventana en la pantalla
        frame.setLocationRelativeTo(null);

        // Ajustar el tamaño de la ventana según el contenido
        frame.pack();

        // Hacer visible la ventana
        frame.setVisible(true);
    }
}
