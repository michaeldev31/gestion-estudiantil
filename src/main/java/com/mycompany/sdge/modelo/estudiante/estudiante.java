
package com.mycompany.sdge.modelo.estudiante;

public class estudiante implements Prototype{
    private int id;
    private String dni;
    private String nombre;
    private String apellido;
    private String email;
    private String grado;
    private double promedio;

    public estudiante(int id, String dni, String nombre, String apellido, String email, String grado, double promedio) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.grado = grado;
        this.promedio = promedio;
    }

   public estudiante() {
        this.id = 0; 
        this.dni = ""; 
        this.nombre = ""; 
        this.apellido = ""; 
        this.email = ""; 
        this.grado = ""; 
        this.promedio = 0.0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }
    
     // Implementación del método clone
    @Override
    public estudiante clone() {
        // Retornamos una nueva instancia de Estudiante con los mismos valores
        return new estudiante(this.id, this.dni, this.nombre, this.apellido, this.email, this.grado, this.promedio);
    }
}
