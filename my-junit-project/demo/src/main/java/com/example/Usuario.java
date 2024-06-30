package com.example;

public class Usuario {
    private String id;
    private String nombre;
    private String departamento;
    private String descripcion;

    public Usuario(String id, String nombre, String departamento, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.departamento = departamento;
        this.descripcion = descripcion;
    }

     // Getter para id
     public String getId() {
        return id;
    }

    // Setter para id
    public void setId(String id) {
        this.id = id;
    }

    // Getter para nombre
    public String getNombre() {
        return nombre;
    }

    // Setter para nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter para departamento
    public String getDepartamento() {
        return departamento;
    }

    // Setter para departamento
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    // Getter para descripcion
    public String getDescripcion() {
        return descripcion;
    }

    // Setter para descripcion
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", departamento='" + departamento + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
    
}
