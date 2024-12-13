
package com.mycompany.sdge;



import com.mycompany.sdge.controlador.entrar.ControlLogin;
import com.mycompany.sdge.vistas.entrar.Login;
import com.mycompany.sdge.vistas.entrar.Menu;
import com.mycompany.sdge.modelo.estudiante.estudiante;
import com.mycompany.sdge.modelo.estudiante.estudianteDAO;


public class SDGE {

    public static void main(String[] args) {
        Login lo = new Login();
        ControlLogin  clog = new ControlLogin(lo);
        lo.setVisible(true);
        
        //estudianteDAO estDAO = new estudianteDAO();
        
        //estudiante estudiante = estDAO.getEstudiante(1);
        /*System.out.println("Estudiante obtenido: "+estudiante.getNombre());*/
        
        // Insertar un nuevo estudiante
        /*estudiante nuevoEstudiante = new estudiante(2,"87654321", "Ana", "Lopez", "ana@gmail.com", "Tercero", (float) 18.5);
        estDAO.insertarEstudiante(nuevoEstudiante);*/
        
        // Actualizar un estudiante
        //estudiante.setPromedio(19.5);
        //estDAO.actualizarEstudiante(estudiante);

        
    }
}
