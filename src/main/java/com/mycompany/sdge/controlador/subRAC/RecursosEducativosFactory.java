
package com.mycompany.sdge.controlador.subRAC;

import com.mycompany.sdge.modelo.recursoEducativo.recursosEducativos;


public class RecursosEducativosFactory {

    // Método para crear un recurso educativo con datos predefinidos
    public static recursosEducativos crearRecursoEducativo(int id, String titulo, String tipo, String contenido, String nombre_asignatura) {
        recursosEducativos recurso = new recursosEducativos();
        recurso.setId(id);
        recurso.setTitulo(titulo);
        recurso.setTipo(tipo);
        recurso.setContenido(contenido);
        recurso.setNombre_asignatura(nombre_asignatura);
        return recurso;
    }

    // Método para crear un recurso educativo con valores predeterminados
    public static recursosEducativos crearRecursoEducativoPorDefecto() {
        return crearRecursoEducativo(1, "Recurso Educativo Básico", "Teoría", "Contenido introductorio", "101");
    }
}