package com.mycompany.sdge.modelo.estudiante;

import com.mycompany.sdge.modelo.conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class estudianteDAO {

    //Metodo para obtener estudiante por id 
    public estudiante getEstudiante(int id) {
        estudiante estudiante = null;

        try (Connection connection = Conexion.getConexion()) {
            CallableStatement stmt = connection.prepareCall("{call getEstudiante(?)}");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                estudiante = new estudiante(
                        rs.getInt("id"),
                        rs.getString("dni"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("email"),
                        rs.getString("grado"),
                        rs.getDouble("promedio")
                );

                // Clonamos el estudiante para devolver una copia
                estudiante = estudiante.clone();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estudiante;
    }

    //Metodo para insertar estudiante
    public void insertarEstudiante(estudiante estudiante) {
        try (Connection connection = Conexion.getConexion()) {
            CallableStatement stmt = connection.prepareCall("{call InsertEstudiante(?,?,?,?,?,?)}");
            stmt.setString(1, estudiante.getDni());
            stmt.setString(2, estudiante.getNombre());
            stmt.setString(3, estudiante.getApellido());
            stmt.setString(4, estudiante.getEmail());
            stmt.setString(5, estudiante.getGrado());
            stmt.setDouble(6, estudiante.getPromedio());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Metodo para actualizar estudiante
    public void actualizarEstudiante(estudiante estudiante) {
        try (Connection connection = Conexion.getConexion()) {
            CallableStatement stmt = connection.prepareCall("{call UpdateEstudiante(?,?,?,?,?,?,?)}");
            stmt.setInt(1, estudiante.getId());
            stmt.setString(2, estudiante.getDni());
            stmt.setString(3, estudiante.getNombre());
            stmt.setString(4, estudiante.getApellido());
            stmt.setString(5, estudiante.getEmail());
            stmt.setString(6, estudiante.getGrado());
            stmt.setDouble(7, estudiante.getPromedio());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Metodo para eliminar estudiante
    public void eliminarEstudiante(int id) {
        try (Connection connection = Conexion.getConexion()) {
            CallableStatement stmt = connection.prepareCall("{call DeleteEstudiante(?)}");
            stmt.setInt(1, id);
            stmt.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<estudiante> obtenerTodosLosEstudiantes() {
        List<estudiante> estudiantes = new ArrayList<>();
        try (Connection connection = Conexion.getConexion()) {
            CallableStatement stmt = connection.prepareCall("{call GetAllEstudiantes()}");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                estudiante est = new estudiante(
                        rs.getInt("id"),
                        rs.getString("dni"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("email"),
                        rs.getString("grado"),
                        rs.getDouble("promedio")
                );
                estudiantes.add(est);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estudiantes;
    }
    
    public List<estudiante> primerGrado(){
        List<estudiante> estudiantes = new ArrayList<>();
        try (Connection connection = Conexion.getConexion()){
            CallableStatement stmt = connection.prepareCall("{call mostrarAlumnosPorGrado('PRIMERO')}");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                estudiante est = new estudiante(
                        rs.getInt("id"),
                        rs.getString("dni"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("email"),
                        rs.getString("grado"),
                        rs.getDouble("promedio")                      
                );
                estudiantes.add(est);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estudiantes;
    }
    
    public List<estudiante> segundoGrado(){
        List<estudiante> estudiantes = new ArrayList<>();
        try (Connection connection = Conexion.getConexion()){
            CallableStatement stmt = connection.prepareCall("{call mostrarAlumnosPorGrado('SEGUNDO')}");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                estudiante est = new estudiante(
                        rs.getInt("id"),
                        rs.getString("dni"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("email"),
                        rs.getString("grado"),
                        rs.getDouble("promedio")                      
                );
                estudiantes.add(est);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estudiantes;
    }
    
    public List<estudiante> terceroGrado(){
        List<estudiante> estudiantes = new ArrayList<>();
        try (Connection connection = Conexion.getConexion()){
            CallableStatement stmt = connection.prepareCall("{call mostrarAlumnosPorGrado('TERCERO')}");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                estudiante est = new estudiante(
                        rs.getInt("id"),
                        rs.getString("dni"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("email"),
                        rs.getString("grado"),
                        rs.getDouble("promedio")                      
                );
                estudiantes.add(est);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estudiantes;
    }
    
    public List<estudiante> cuartoGrado(){
        List<estudiante> estudiantes = new ArrayList<>();
        try (Connection connection = Conexion.getConexion()){
            CallableStatement stmt = connection.prepareCall("{call mostrarAlumnosPorGrado('CUARTO')}");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                estudiante est = new estudiante(
                        rs.getInt("id"),
                        rs.getString("dni"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("email"),
                        rs.getString("grado"),
                        rs.getDouble("promedio")                      
                );
                estudiantes.add(est);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estudiantes;
    }
    
    public List<estudiante> quintoGrado(){
        List<estudiante> estudiantes = new ArrayList<>();
        try (Connection connection = Conexion.getConexion()){
            CallableStatement stmt = connection.prepareCall("{call mostrarAlumnosPorGrado('QUINTO')}");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                estudiante est = new estudiante(
                        rs.getInt("id"),
                        rs.getString("dni"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("email"),
                        rs.getString("grado"),
                        rs.getDouble("promedio")                      
                );
                estudiantes.add(est);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estudiantes;
    }

}
