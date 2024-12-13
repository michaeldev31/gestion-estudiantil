package com.mycompany.sdge.modelo.recursoEducativo;


public class recursosEducativos implements Prototype {
    private int id;
    private String titulo;
    private String tipo;
    private String contenido;
    private String nombre_asignatura;

    public recursosEducativos(int id, String titulo, String tipo, String contenido, String nombre_asignatura) {
        this.id = id;
        this.titulo = titulo;
        this.tipo = tipo;
        this.contenido = contenido;
        this.nombre_asignatura = nombre_asignatura;
    }

    public recursosEducativos() {
        this.id = 0;
        this.titulo = "";
        this.tipo = "";
        this.contenido = "";
        this.nombre_asignatura = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getNombre_asignatura() {
        return nombre_asignatura;
    }

    public void setNombre_asignatura(String nombre_asignatura) {
        this.nombre_asignatura = nombre_asignatura;
    }

    
    
    // Implementación del método clone
    @Override
    public recursosEducativos clone() {
        return new recursosEducativos(this.id, this.titulo, this.tipo, this.contenido, this.nombre_asignatura);
    }
    
}
