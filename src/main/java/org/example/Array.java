package org.example;

import java.util.ArrayList;

public class Array {
    public static ArrayList<Datos> datos;

    static {
        datos = new ArrayList<>();
        datos.add(new Datos("juan@example.com", "España", "Escritorio"));
        datos.add(new Datos("maria@example.com", "Francia", "Móvil"));
        datos.add(new Datos("pedro@example.com", "Italia", "Desconocido"));
    }
}
