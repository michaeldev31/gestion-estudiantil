package com.mycompany.sdge.modelo.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3307/sdge";
    private static final String USER = "root";
    private static final String PASSWORD = "Reques123@";
    
    //instancia unica de la conexion con singleton
    private static Connection conexion;
    private static boolean estaConectado = false;

    private Conexion(){
        
    }
    
    //metodo que devuelve la conexion unica
    public static Connection getConexion(){
        if (conexion == null || !estaConectado){
            try {
                conexion = DriverManager.getConnection(URL,USER,PASSWORD);
                System.out.println("Conexion exitosa");
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Error al conectar con la base de datos");
            }
        }
        return conexion;
    }
    //metodo para cerrar la conexion
    public static void cerrarConexion(){
        if(conexion != null && estaConectado){
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
