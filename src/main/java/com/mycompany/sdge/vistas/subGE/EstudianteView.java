
package com.mycompany.sdge.vistas.subGE;

import com.mycompany.sdge.modelo.estudiante.estudiante;
import java.util.List;


public interface EstudianteView {
    void mostrarEstudiantes(List<estudiante> estudiantes);
    void mostrarEstudiante(estudiante estudiante);
    void mostrarMensaje(String mensaje);
    void mostrarError(String error);
    estudiante obtenerDatosEstudiante();
    int obtenerIdEstudiante(); 
}
