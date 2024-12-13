
package com.mycompany.sdge.controlador.subGE;

import com.mycompany.sdge.modelo.estudiante.estudiante;

public class EstudiantesPermissionDecorator extends EstudianteController {

    private EstudianteController controller;

    // Lista de DNI que tienen permisos para ser agregados
    private static final String[] DNI_PERMITIDOS = {"12345678", "87654321", "11223344"};

    public EstudiantesPermissionDecorator(EstudianteController controller) {
        this.controller = controller;
    }

    // Método que valida si el estudiante tiene permisos para ser agregado
    private boolean tienePermiso(estudiante estudiante) {
        for (String dni : DNI_PERMITIDOS) {
            if (estudiante.getDni().equals(dni)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void agregarEstudiante(estudiante estudiante) {
        if (tienePermiso(estudiante)) {
            // Si tiene permiso, delega la acción al controlador base
            controller.agregarEstudiante(estudiante);
            System.out.println("Estudiante agregado correctamente: " + estudiante.getNombre());
        } else {
            // Si no tiene permiso, muestra un mensaje de error
            System.out.println("Permiso denegado para agregar al estudiante: " + estudiante.getNombre());
        }
    }
}
