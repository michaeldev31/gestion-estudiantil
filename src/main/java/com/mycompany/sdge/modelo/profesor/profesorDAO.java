package com.mycompany.sdge.modelo.profesor;

import com.mycompany.sdge.modelo.conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class profesorDAO {
    
    //metodo para obtener profedor por id
    public profesor getProfesor(int id){
        profesor profesor = null;
        try (Connection connection = Conexion.getConexion()){
           CallableStatement stmt = connection.prepareCall("{call GetProfesor(?)}");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                profesor = new profesor(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("email"),
                        rs.getString("telefono")
                );

                // Clonamos el profesor para devolver una copia
                profesor = profesor.clone();
            } 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return profesor;
    }
    
    //metodo para insertar profesor
    public void insertarProgesor(profesor profesor){
       try (Connection connection = Conexion.getConexion()) {
            CallableStatement stmt = connection.prepareCall("{call InsertProfesor(?,?,?,?)}");
            stmt.setString(1, profesor.getNombre());
            stmt.setString(2, profesor.getApellido());
            stmt.setString(3, profesor.getEmail());
            stmt.setString(4, profesor.getTelefono());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    
    // Método para actualizar profesor
    public void actualizarProfesor(profesor profesor) {
        try (Connection connection = Conexion.getConexion()) {
            CallableStatement stmt = connection.prepareCall("{call UpdateProfesor(?,?,?,?,?)}");
            stmt.setInt(1, profesor.getId());
            stmt.setString(2, profesor.getNombre());
            stmt.setString(3, profesor.getApellido());
            stmt.setString(4, profesor.getEmail());
            stmt.setString(5, profesor.getTelefono());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Método para eliminar profesor
    public void eliminarProfesor(int id) {
        try (Connection connection = Conexion.getConexion()) {
            CallableStatement stmt = connection.prepareCall("{call DeleteProfesor(?)}");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
     // Método para obtener todos los profesores
    public List<profesor> getAllProfesores() {
        List<profesor> profesores = new ArrayList<>();
        
        try (Connection connection = Conexion.getConexion()) {
            CallableStatement stmt = connection.prepareCall("{call GetAllProfesores()}");
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                profesor profesor = new profesor(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("email"),
                        rs.getString("telefono")
                );
                profesores.add(profesor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return profesores;
    }
}
