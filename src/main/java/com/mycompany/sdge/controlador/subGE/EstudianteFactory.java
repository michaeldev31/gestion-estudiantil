
package com.mycompany.sdge.controlador.subGE;

import com.mycompany.sdge.modelo.estudiante.estudiante;


class EstudianteFactory {
     // Factory para crear estudiantes con un conjunto de parámetros
    public static estudiante crearEstudiante(int id, String nombre,String apellido,String dni, String email, String grado, double promedio) {
        estudiante estudiante = new  estudiante();
        estudiante.setId(id);
        estudiante.setNombre(nombre);
        estudiante.setApellido(apellido);
        estudiante.setDni(dni);
        estudiante.setEmail(email);
        estudiante.setGrado(grado);
        estudiante.setPromedio(promedio);
        return estudiante;
    }
}
