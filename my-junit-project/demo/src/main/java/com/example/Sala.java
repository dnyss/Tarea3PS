package com.example;

public class Sala {
    private String codigo;
    private String nombre;
    private String ubicacion;
    private boolean reservada;

    public Sala(String codigo, String nombre, String ubicacion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.reservada = false;
    }
    // Getters y setters
    // Getter para codigo
    public String getCodigo() {
        return codigo;
    }

    // Setter para codigo
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    // Getter para nombre
    public String getNombre() {
        return nombre;
    }

    // Setter para nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter para ubicacion
    public String getUbicacion() {
        return ubicacion;
    }

    // Setter para ubicacion
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    // Getter para reservada
    public boolean isReservada() {
        return reservada;
    }

    // Setter para reservada
    public void setReservada(boolean reservada) {
        this.reservada = reservada;
    }


    @Override
    public String toString() {
        return "Sala{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", reservada=" + reservada +
                '}';
    }
    
}
