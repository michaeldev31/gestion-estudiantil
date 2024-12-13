
package com.mycompany.sdge.controlador.subGP;

import com.mycompany.sdge.modelo.profesor.profesor;
import java.util.Arrays;
import java.util.List;

public class ProfesorPermissionDecorator extends ProfesorController {

    private ProfesorController controller;

    // Lista de IDs de profesores que tienen permisos para ser gestionados
    private static final List<Integer> IDS_PERMITIDOS = Arrays.asList(1, 2, 3, 4, 5);

    public ProfesorPermissionDecorator(ProfesorController controller) {
        this.controller = controller;
    }

    // Método para validar si un profesor tiene permiso para ser gestionado
    private boolean tienePermiso(profesor profesor) {
        return IDS_PERMITIDOS.contains(profesor.getId());
    }

    @Override
    public void agregarProfesor(profesor profesor) {
        if (tienePermiso(profesor)) {
            controller.agregarProfesor(profesor);
            System.out.println("Profesor agregado correctamente: " + profesor.getNombre());
        } else {
            System.out.println("Permiso denegado para agregar al profesor: " + profesor.getNombre());
        }
    }

    @Override
    public void actualizarProfesor(profesor profesor) {
        if (tienePermiso(profesor)) {
            controller.actualizarProfesor(profesor);
            System.out.println("Profesor actualizado correctamente: " + profesor.getNombre());
        } else {
            System.out.println("Permiso denegado para actualizar al profesor: " + profesor.getNombre());
        }
    }

    @Override
    public void eliminarProfesor(int id) {
        if (IDS_PERMITIDOS.contains(id)) {
            controller.eliminarProfesor(id);
            System.out.println("Profesor eliminado correctamente con ID: " + id);
        } else {
            System.out.println("Permiso denegado para eliminar al profesor con ID: " + id);
        }
    }

    @Override
    public List<profesor> obtenerTodosLosProfesores() {
        return controller.obtenerTodosLosProfesores();
    }

    @Override
    public profesor obtenerProfesor(int id) {
        return controller.obtenerProfesor(id);
    }
}