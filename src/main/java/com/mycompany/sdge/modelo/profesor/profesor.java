package com.mycompany.sdge.modelo.profesor;

/*id INT AUTO_INCREMENT PRIMARY KEY,
nombre varchar(100) not null,
apellido varchar(100) not null,
email varchar(100) unique,
telefono varchar(20)
 */
public class profesor implements Prototype {

    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

    public profesor(int id, String nombre, String apellido, String email, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }

    public profesor() {
        this.id = 0;
        this.nombre = "";
        this.apellido = "";
        this.email = "";
        this.telefono = "";
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Implementación del método clone() para Prototype
    @Override
    public profesor clone() {
        return new profesor(this.id, this.nombre, this.apellido, this.email, this.telefono);
    }
}
