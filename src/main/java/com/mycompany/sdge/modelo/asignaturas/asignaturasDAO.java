package com.mycompany.sdge.modelo.asignaturas;

import com.mycompany.sdge.modelo.conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class asignaturasDAO {
    
    //metodo para obteher una asignatura por id
    
    public asignaturas getAsignaturas(int id){
        asignaturas asignatura = null;
        try (Connection connection = Conexion.getConexion()){
            CallableStatement stmt = connection.prepareCall("{call GetAsignatura(?)}");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                asignatura = new asignaturas(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("descripcion")
                );
                asignatura = asignatura.clone(); // Clonamos la asignatura
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return asignatura;
    }
    
    // Método para insertar una nueva asignatura
    public void insertarAsignatura(asignaturas asignatura) {
        try (Connection connection = Conexion.getConexion()) {
            CallableStatement stmt = connection.prepareCall("{call InsertAsignatura(?,?)}");
            stmt.setString(1, asignatura.getNombre());
            stmt.setString(2, asignatura.getDescripcion());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para actualizar una asignatura
    public void actualizarAsignatura(asignaturas asignatura) {
        try (Connection connection = Conexion.getConexion()) {
            CallableStatement stmt = connection.prepareCall("{call UpdateAsignatura(?,?,?)}");
            stmt.setInt(1, asignatura.getId());
            stmt.setString(2, asignatura.getNombre());
            stmt.setString(3, asignatura.getDescripcion());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar una asignatura
    public void eliminarAsignatura(int id) {
        try (Connection connection = Conexion.getConexion()) {
            CallableStatement stmt = connection.prepareCall("{call DeleteAsignatura(?)}");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
     // Método para obtener todas las asignaturas
    public List<asignaturas> getAllAsignaturas() {
        List<asignaturas> asignaturasList = new ArrayList<>();
        try (Connection connection = Conexion.getConexion()) {
            CallableStatement stmt = connection.prepareCall("{call GetAllAsignaturas()}");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                asignaturas asignatura = new asignaturas(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("descripcion")
                );
                asignaturasList.add(asignatura);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return asignaturasList;
    }
            
}
