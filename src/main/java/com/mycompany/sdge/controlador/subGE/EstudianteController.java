package com.mycompany.sdge.controlador.subGE;

import com.mycompany.sdge.modelo.estudiante.estudiante;
import com.mycompany.sdge.modelo.estudiante.estudianteDAO;
import java.util.List;

public class EstudianteController {

    private estudianteDAO estudianteDAO;

    public EstudianteController() {
        estudianteDAO = new estudianteDAO();
    }

    // Método para agregar un estudiante
    public void agregarEstudiante(estudiante estudiante) {
        estudianteDAO.insertarEstudiante(estudiante);
    }

    // Método para obtener un estudiante por su ID
    public estudiante obtenerEstudiante(int id) {
        return estudianteDAO.getEstudiante(id);
    }

    // Método para actualizar un estudiante
    public void actualizarEstudiante(estudiante estudiante) {
        estudianteDAO.actualizarEstudiante(estudiante);
    }

    // Método para eliminar un estudiante
    public void eliminarEstudiante(int id) {
        estudianteDAO.eliminarEstudiante(id);
    }

    public estudiante buscarEstudiante(int id) {
        return estudianteDAO.getEstudiante(id);
    }

    public List<estudiante> obtenerEstudiantes() {
        return estudianteDAO.obtenerTodosLosEstudiantes();  // Asumiendo que este método devuelve List<Estudiante>
    }
    
    public List<estudiante> obtenerPrimero(){
        return estudianteDAO.primerGrado();
    }
    
    public List<estudiante> obtenerSegundo(){
        return estudianteDAO.segundoGrado();
    }
    
    public List<estudiante> obtenerTercero(){
        return estudianteDAO.terceroGrado();
    }
    
    public List<estudiante> obtenerCuarto(){
        return estudianteDAO.cuartoGrado();
    }
    
    public List<estudiante> obtenerQuinto(){
        return estudianteDAO.quintoGrado();
    }
}
