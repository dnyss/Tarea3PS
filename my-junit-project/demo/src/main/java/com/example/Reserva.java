package com.example;

import java.time.LocalDate;

public class Reserva {
    private Sala sala;
    private Usuario usuario;
    private LocalDate fecha;
    private String detalleReserva;

    public Reserva(Sala sala, Usuario usuario, LocalDate fecha, String detalleReserva) {
        this.sala = sala;
        this.usuario = usuario;
        this.fecha = fecha;
        this.detalleReserva = detalleReserva;
    }

    // Getters y setters
    // Getter para sala
    public Sala getSala() {
        return sala;
    }

    // Setter para sala
    public void setSala(Sala sala) {
        this.sala = sala;
    }

    // Getter para usuario
    public Usuario getUsuario() {
        return usuario;
    }

    // Setter para usuario
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    // Getter para fecha
    public LocalDate getFecha() {
        return fecha;
    }

    // Setter para fecha
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    // Getter para detalleReserva
    public String getDetalle() {
        return detalleReserva;
    }

    // Setter para detalleReserva
    public void setDetalle(String detalleReserva) {
        this.detalleReserva = detalleReserva;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "sala=" + sala +
                ", usuario=" + usuario +
                ", fecha=" + fecha +
                ", detalleReserva='" + detalleReserva + '\'' +
                '}';
    }
}
