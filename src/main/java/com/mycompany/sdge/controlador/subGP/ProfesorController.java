
package com.mycompany.sdge.controlador.subGP;

import com.mycompany.sdge.modelo.profesor.profesor;
import com.mycompany.sdge.modelo.profesor.profesorDAO;
import java.util.List;

public class ProfesorController {

    private profesorDAO profesorDAO;

    public ProfesorController() {
        profesorDAO = new profesorDAO();
    }
    
    // Método para insertar un profesor
    public void agregarProfesor(profesor profesor) {
        profesorDAO.insertarProgesor(profesor);
    }
    
    // Método para obtener un profesor por su ID
    public profesor obtenerProfesor(int id) {
        return profesorDAO.getProfesor(id);
    }

   
    // Método para actualizar un profesor  
    public void actualizarProfesor(profesor profesor) {
        profesorDAO.actualizarProfesor(profesor);
    }

    // Método para eliminar un profesor
    public void eliminarProfesor(int id) {
        profesorDAO.eliminarProfesor(id);
    }
    
    //Metodo para buscar profesor
    public profesor buscarProfesor(int id){
        return profesorDAO.getProfesor(id);
    }

    // Método para obtener todos los profesores
    public List<profesor> obtenerTodosLosProfesores() {
        return profesorDAO.getAllProfesores();
    }
}
