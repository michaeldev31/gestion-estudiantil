package com.mycompany.sdge.controlador.subASI;

import com.mycompany.sdge.modelo.asignaturas.asignaturas;
import com.mycompany.sdge.modelo.asignaturas.asignaturasDAO;
import java.util.List;

public class AsignaturasController {

    private asignaturasDAO asignaturasDao;

    public AsignaturasController() {
        asignaturasDao = new asignaturasDAO();
    }
    
    //agregar asignatura
    public void agregarAsignatura(asignaturas asignatura) {
        asignaturasDao.insertarAsignatura(asignatura);
    }
    
    //obtener asignatura por id
    public asignaturas obtenerAsignatura(int id) {
        return asignaturasDao.getAsignaturas(id);
    }

   //actualizar asignatura
    public void actualizarAsignatura(asignaturas asignatura) {
        asignaturasDao.actualizarAsignatura(asignatura);
    }

    //eliminar asignatura
    public void eliminarAsignatura(int id) {
        asignaturasDao.eliminarAsignatura(id);
    }
    
    //buscar asignatura
    public  asignaturas buscarAsignatura(int id){
        return asignaturasDao.getAsignaturas(id);
    }
    
    //obtener todas las asigntaruras
    public List<asignaturas> obtenerTodasLasAsignaturas() {
        return asignaturasDao.getAllAsignaturas();
    }
    
}