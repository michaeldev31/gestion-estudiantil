package com.mycompany.sdge.vistas.subRAC;

import com.mycompany.sdge.modelo.recursoEducativo.recursosEducativos;
import java.util.List;


public interface RecursosView {
    void mostrarRecursos(List<recursosEducativos> recursosEducativos);
    void mostrarRecurso(recursosEducativos recursosEducativos);
    void mostrarMensaje(String mensaje);
    void mostrarError(String error);
    recursosEducativos obtenerDatosRecurso();
    int obtenerIdRecurso();
}
