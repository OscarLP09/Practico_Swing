package org.example;

import java.util.ArrayList;

/**
 * La clase {@code Array} contiene una lista estática de objetos {@code Datos}.
 * Esta clase inicializa una lista predefinida de usuarios con información
 * sobre su correo, país y plataforma.
 */
public class Array {
    /**
     * Una lista estática de objetos {@code Datos} que contiene los datos predefinidos.
     */
    public static ArrayList<Datos> datos;

    /**
     * Bloque estático que inicializa la lista {@code datos} con usuarios predefinidos.
     * Los usuarios contienen información de correo, país y plataforma.
     */
    static {
        datos = new ArrayList<>();
        datos.add(new Datos("juan@example.com", "España", "Escritorio"));
        datos.add(new Datos("maria@example.com", "Francia", "Móvil"));
        datos.add(new Datos("pedro@example.com", "Italia", "Desconocido"));
    }
}
