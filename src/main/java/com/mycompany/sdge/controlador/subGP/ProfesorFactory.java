
package com.mycompany.sdge.controlador.subGP;

import com.mycompany.sdge.modelo.profesor.profesor;


public class ProfesorFactory {
        // Método para crear un profesor con datos predefinidos
    public static profesor crearProfesor(int id, String nombre, String apellido, String email, String telefono) {
        profesor profesor = new profesor();
        profesor.setId(id);
        profesor.setNombre(nombre);
        profesor.setApellido(apellido);
        profesor.setEmail(email);
        profesor.setTelefono(telefono);
        return profesor;
    }
}
