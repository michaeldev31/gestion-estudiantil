
package com.mycompany.sdge.vistas.subGP;

import com.mycompany.sdge.modelo.profesor.profesor;
import java.util.List;


public interface ProfesorView {
    
    void mostrarProfesores(List<profesor> profesores);
    void mostrarProfesor(profesor profesor);
    void mostrarMensaje(String mensaje);
    void mostrarError (String error);
    profesor obtenerDatosProfesor();
    int obtenerIdProfesor();
}
