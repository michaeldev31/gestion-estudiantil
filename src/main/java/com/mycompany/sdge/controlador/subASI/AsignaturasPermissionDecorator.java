
package com.mycompany.sdge.controlador.subASI;

import com.mycompany.sdge.modelo.asignaturas.asignaturas;


public class AsignaturasPermissionDecorator extends AsignaturasController {

    private AsignaturasController controller;

    public AsignaturasPermissionDecorator(AsignaturasController controller) {
        this.controller = controller;
    }

    // Agregar permisos antes de realizar la acción
    private void verificarPermisos() {
        // Lógica para verificar permisos del usuario
        System.out.println("Verificando permisos...");
    }

    @Override
    public void agregarAsignatura(asignaturas asignatura) {
        verificarPermisos();
        controller.agregarAsignatura(asignatura);
    }

    @Override
    public void actualizarAsignatura(asignaturas asignatura) {
        verificarPermisos();
        controller.actualizarAsignatura(asignatura);
    }

    @Override
    public void eliminarAsignatura(int id) {
        verificarPermisos();
        controller.eliminarAsignatura(id);
    }
}