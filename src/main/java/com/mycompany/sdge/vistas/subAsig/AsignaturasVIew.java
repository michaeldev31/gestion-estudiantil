
package com.mycompany.sdge.vistas.subAsig;

import com.mycompany.sdge.modelo.asignaturas.asignaturas;
import java.util.List;


public interface AsignaturasVIew {
    void mostrarAsignaturas(List<asignaturas> asignaturas);
    void mostrarAsignatura(asignaturas asignaturas);
    void mostrarMensaje(String mensaje);
    void mostrarError(String error);
    asignaturas obtenerDatosAsignatura();
    int obtenetIdAsignatura();
}
