
package com.mycompany.sdge.vistas.subGP;

import com.mycompany.sdge.controlador.subGP.ProfesorController;
import com.mycompany.sdge.modelo.profesor.profesor;
import com.mycompany.sdge.modelo.profesor.profesorDAO;
import java.util.ArrayList;
import java.util.List;


public class ProfesorApp {
    private ProfesorController controller;
    private ProfesorView view;
    
    public ProfesorApp(ProfesorView view){
        this.view = view;
        this.controller = controller;
    }
    
    public void agregarProfesor(){
        profesor nuevoProfesor = view.obtenerDatosProfesor();
        controller.agregarProfesor(nuevoProfesor);
        view.mostrarMensaje("Profesor agregado correctamente");
    }
    
    public void buscarEstProfesor() {
        int id = view.obtenerIdProfesor();
        profesor encontrado = controller.obtenerProfesor(id);
        if (encontrado != null) {
            view.mostrarProfesor(encontrado);
        } else {
            view.mostrarMensaje("Profesor no encontrado");
        }
    }

    public void actualizarProfesor() {
        profesor profesorActualizado = view.obtenerDatosProfesor();
        controller.actualizarProfesor(profesorActualizado);
        view.mostrarMensaje("Profesor actualizado correctamente");
    }

    public void eliminarProfesor() {
        int id = view.obtenerIdProfesor();
        controller.eliminarProfesor(id);
        view.mostrarMensaje("Profesor eliminado correctamente");
    }
    
}
