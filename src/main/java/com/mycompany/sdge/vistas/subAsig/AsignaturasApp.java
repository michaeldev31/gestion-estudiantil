
package com.mycompany.sdge.vistas.subAsig;

import com.mycompany.sdge.controlador.subASI.AsignaturasController;
import com.mycompany.sdge.modelo.asignaturas.asignaturas;


public class AsignaturasApp {
    private  AsignaturasController controller;
    private AsignaturasVIew view;
    
    public AsignaturasApp(AsignaturasVIew view){
        this.view = view;
        this.controller = controller;
    }
    
    public void agregarAsignatura(){
        asignaturas nuevaAsignatura = view. obtenerDatosAsignatura();
        controller.agregarAsignatura(nuevaAsignatura);
        view.mostrarMensaje("Asignatura agregada correctamente");
    }
    
    public void buscarAsignatura(){
        int id = view.obtenetIdAsignatura();
        asignaturas encontrado = controller.obtenerAsignatura(id);
        if(encontrado != null){
            view.mostrarAsignatura(encontrado);
        }else{
            view.mostrarMensaje("Asignatura no encontrada");
        }
    }
    
    public void actualizarAsignatura(){
        asignaturas asignaturaActualizada = view.obtenerDatosAsignatura();
        controller.actualizarAsignatura(asignaturaActualizada);
        view.mostrarMensaje("Asignatura actualizada correctamente");
    }
    
    public void eliminarAsignatura(){
        int id = view.obtenetIdAsignatura();
        controller.eliminarAsignatura(id);
        view.mostrarMensaje("Asignatura eliminada correctamente");
    }
    
}
