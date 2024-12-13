package com.mycompany.sdge.modelo.asignaturas;

/**
id INT AUTO_INCREMENT PRIMARY KEY,
nombre varchar(100) not null,
descripcion varchar(255)
 */
public class asignaturas implements Prototype{
    private int id;
    private String nombre;
    private String descripcion;

    public asignaturas(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public asignaturas() {
        this.id = 0;
        this.nombre = "";
        this.descripcion ="";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    // Implementación del método clone (para el patrón Prototype)
    @Override
    public asignaturas clone() {
        return new asignaturas(this.id, this.nombre, this.descripcion);
    }
    
}
