
package com.mycompany.sdge.controlador.subRAC;

import com.mycompany.sdge.modelo.recursoEducativo.recursosEducativos;
import com.mycompany.sdge.modelo.recursoEducativo.recursosEducativosDAO;
import java.util.List;


public class RecursosEducativosController {

    private recursosEducativosDAO recursosDAO;

    public RecursosEducativosController() {
        recursosDAO = new recursosEducativosDAO();
    }

    public recursosEducativos obtenerRecursoEducativo(int id) {
        return recursosDAO.getRecursoEducativo(id);
    }

    public void agregarRecursoEducativo(recursosEducativos recurso) {
        recursosDAO.insertarRecursoEducativo(recurso);
    }

    public void actualizarRecursoEducativo(recursosEducativos recurso) {
        recursosDAO.actualizarRecursoEducativo(recurso);
    }

    public void eliminarRecursoEducativo(int id) {
        recursosDAO.eliminarRecursoEducativo(id);
    }
    
    public recursosEducativos buscarRecurso(int id){
        return recursosDAO.getRecursoEducativo(id);
    }

    public List<recursosEducativos> obtenerTodosLosRecursosEducativos() {
        return recursosDAO.getAllRecursosEducativos();
    }
}