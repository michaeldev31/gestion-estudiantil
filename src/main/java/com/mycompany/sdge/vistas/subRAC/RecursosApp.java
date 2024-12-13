
package com.mycompany.sdge.vistas.subRAC;

import com.mycompany.sdge.controlador.subRAC.RecursosEducativosController;
import com.mycompany.sdge.modelo.recursoEducativo.recursosEducativos;


public class RecursosApp {
    private RecursosEducativosController controller;
    private RecursosView view;
    
    public RecursosApp(RecursosView view){
         this.view = view;
        this.controller = new RecursosEducativosController();
    }
    
    public void agregarRecurso() {
        recursosEducativos nuevoRecurso = view.obtenerDatosRecurso();
        controller.agregarRecursoEducativo(nuevoRecurso);
        view.mostrarMensaje("Recurso agregado correctamente");
    }

    public void buscarRecurso() {
        int id = view.obtenerIdRecurso();
        recursosEducativos encontrado = controller.obtenerRecursoEducativo(id);
        if (encontrado != null) {
            view.mostrarRecurso(encontrado);
        } else {
            view.mostrarMensaje("Recurso no encontrado");
        }
    }

    public void actualizarRecurso() {
        recursosEducativos recursoActualizado = view.obtenerDatosRecurso();
        controller.actualizarRecursoEducativo(recursoActualizado);
        view.mostrarMensaje("Recurso actualizado correctamente");
    }

    public void eliminarRecurso() {
        int id = view.obtenerIdRecurso();
        controller.eliminarRecursoEducativo(id);
        view.mostrarMensaje("Recurso eliminado correctamente");
    }
}
