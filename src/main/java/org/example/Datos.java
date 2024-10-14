package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * La clase {@code Datos} representa un objeto que almacena la información de un usuario,
 * incluyendo su correo electrónico, país y plataforma.
 *
 * <p>Esta clase utiliza las anotaciones de Lombok {@code @AllArgsConstructor} para generar
 * automáticamente un constructor con todos los campos, y {@code @Data} para generar
 * automáticamente los getters, setters, {@code toString()}, {@code equals()}, y {@code hashCode()}.</p>
 */
@AllArgsConstructor
@Data
public class Datos {

    /**
     * Correo electrónico del usuario.
     */
    private String correo;

    /**
     * País o idioma asociado al usuario.
     */
    private String pais;

    /**
     * Plataforma desde la que el usuario accede (Móvil, Escritorio, etc.).
     */
    private String plataforma;
}
