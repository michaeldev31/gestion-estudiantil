
package com.mycompany.sdge.controlador.subRAC;

import com.mycompany.sdge.modelo.recursoEducativo.recursosEducativos;


public class RecursosEducativosPermissionDecorator extends RecursosEducativosController {

    private RecursosEducativosController controller;

    public RecursosEducativosPermissionDecorator(RecursosEducativosController controller) {
        this.controller = controller;
    }

    // Agregar permisos antes de realizar la acción
    private void verificarPermisos() {
        // Lógica para verificar permisos del usuario
        System.out.println("Verificando permisos para acceder a los recursos educativos...");
    }

    @Override
    public void agregarRecursoEducativo(recursosEducativos recurso) {
        verificarPermisos();
        controller.agregarRecursoEducativo(recurso);
    }

    @Override
    public void actualizarRecursoEducativo(recursosEducativos recurso) {
        verificarPermisos();
        controller.actualizarRecursoEducativo(recurso);
    }

    @Override
    public void eliminarRecursoEducativo(int id) {
        verificarPermisos();
        controller.eliminarRecursoEducativo(id);
    }
}