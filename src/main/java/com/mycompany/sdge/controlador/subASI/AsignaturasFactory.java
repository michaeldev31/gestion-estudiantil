
package com.mycompany.sdge.controlador.subASI;

import com.mycompany.sdge.modelo.asignaturas.asignaturas;


public class AsignaturasFactory {

    // Método para crear una asignatura con datos predefinidos
    public static asignaturas crearAsignatura(int id, String nombre, String descripcion) {
        asignaturas asignatura = new asignaturas();
        asignatura.setId(id);
        asignatura.setNombre(nombre);
        asignatura.setDescripcion(descripcion);
        return asignatura;
    }

    // Método para crear una asignatura con valores predeterminados
    public static asignaturas crearAsignaturaPorDefecto() {
        return crearAsignatura(1, "Matemáticas", "Curso básico de matemáticas");
    }
}