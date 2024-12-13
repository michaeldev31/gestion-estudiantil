
package com.mycompany.sdge.vistas.subGE;

import com.mycompany.sdge.controlador.subGE.EstudianteController;
import com.mycompany.sdge.modelo.estudiante.estudiante;


public class EstudianteApp {
     private EstudianteController controller;
    private EstudianteView view;

    public EstudianteApp(EstudianteView view) {
        this.view = view;
        this.controller = new EstudianteController();
    }

    public void agregarEstudiante() {
        estudiante nuevoEstudiante = view.obtenerDatosEstudiante();
        controller.agregarEstudiante(nuevoEstudiante);
        view.mostrarMensaje("Estudiante agregado correctamente");
    }

    public void buscarEstudiante() {
        int id = view.obtenerIdEstudiante();
        estudiante encontrado = controller.obtenerEstudiante(id);
        if (encontrado != null) {
            view.mostrarEstudiante(encontrado);
        } else {
            view.mostrarMensaje("Estudiante no encontrado");
        }
    }

    public void actualizarEstudiante() {
        estudiante estudianteActualizado = view.obtenerDatosEstudiante();
        controller.actualizarEstudiante(estudianteActualizado);
        view.mostrarMensaje("Estudiante actualizado correctamente");
    }

    public void eliminarEstudiante() {
        int id = view.obtenerIdEstudiante();
        controller.eliminarEstudiante(id);
        view.mostrarMensaje("Estudiante eliminado correctamente");
    }
}