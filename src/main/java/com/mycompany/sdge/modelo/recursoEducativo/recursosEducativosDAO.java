package com.mycompany.sdge.modelo.recursoEducativo;

import com.mycompany.sdge.modelo.conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class recursosEducativosDAO {
    
    //metodo para obtener por id
    public recursosEducativos getRecursoEducativo(int id){
        recursosEducativos recurso = null;
        try (Connection connection = Conexion.getConexion()){
            CallableStatement stmt = connection.prepareCall("{call GetRecursoEducativo(?)}");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                recurso = new recursosEducativos(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("tipo"),
                        rs.getString("contenido"),
                        rs.getString("nombre_asignatura")
                );
                recurso = recurso.clone(); // Clonamos el recurso educativo
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recurso;
    }
    
    // Método para insertar un recurso educativo
    public void insertarRecursoEducativo(recursosEducativos recurso) {
        try (Connection connection = Conexion.getConexion()) {
            CallableStatement stmt = connection.prepareCall("{call InsertRecursoEducativo(?,?,?,?)}");
            stmt.setString(1, recurso.getTitulo());
            stmt.setString(2, recurso.getTipo());
            stmt.setString(3, recurso.getContenido());
            stmt.setString(4, recurso.getNombre_asignatura());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Método para actualizar un recurso educativo
    public void actualizarRecursoEducativo(recursosEducativos recurso) {
        try (Connection connection = Conexion.getConexion()) {
            CallableStatement stmt = connection.prepareCall("{call UpdateRecursoEducativo(?,?,?,?,?)}");
            stmt.setInt(1, recurso.getId());
            stmt.setString(2, recurso.getTitulo());
            stmt.setString(3, recurso.getTipo());
            stmt.setString(4, recurso.getContenido());
            stmt.setString(5, recurso.getNombre_asignatura());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar un recurso educativo
    public void eliminarRecursoEducativo(int id) {
        try (Connection connection = Conexion.getConexion()) {
            CallableStatement stmt = connection.prepareCall("{call DeleteRecursoEducativo(?)}");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Método para obtener todos los recursos educativos
    public List<recursosEducativos> getAllRecursosEducativos() {
        List<recursosEducativos> recursos = new ArrayList<>();
        try (Connection connection = Conexion.getConexion()) {
            CallableStatement stmt = connection.prepareCall("{call GetAllRecursosEducativos()}");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                recursosEducativos recurso = new recursosEducativos(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("tipo"),
                        rs.getString("contenido"),
                        rs.getString("nombre_asignatura")
                );
                recursos.add(recurso);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recursos;
    }
    
    //Metodo que ayuda a la vista a seleccionar el curso
    public ArrayList<String> obtenerCursos() throws SQLException{
        ArrayList<String> asignaturas = new ArrayList<>();
        String sql = "SELECT nombre FROM asignaturas";
        
        try (Connection connection = Conexion.getConexion();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
            
            while(rs.next()){
                asignaturas.add(rs.getString("nombre"));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return asignaturas;
    }
}
