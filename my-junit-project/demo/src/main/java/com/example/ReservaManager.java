package com.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservaManager {
    private final List<Reserva> reservas;

    public ReservaManager() {
        reservas = new ArrayList<>();
    }

    public List<Reserva> obtenerTodasLasReservas() {
        return new ArrayList<>(reservas);
    }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public List<Reserva> obtenerReservas() {
        return reservas;
    }

    public Reserva obtenerReservaPorSalaYFecha(String codigoSala, LocalDate fecha) {
        return reservas.stream()
                .filter(r -> r.getSala().getCodigo().equals(codigoSala) && r.getFecha().equals(fecha))
                .findFirst()
                .orElse(null);
    }

    public void actualizarReserva(String codigoSala, LocalDate fecha, Sala nuevaSala, Usuario nuevoUsuario, LocalDate nuevaFecha, String nuevoDetalle) {
        for (Reserva reserva : reservas) {
            if (reserva.getSala().getCodigo().equals(codigoSala) && reserva.getFecha().equals(fecha)) {
                if (nuevaSala != null) {
                    reserva.setSala(nuevaSala);
                }
                if (nuevoUsuario != null) {
                    reserva.setUsuario(nuevoUsuario);
                }
                if (nuevaFecha != null) {
                    reserva.setFecha(nuevaFecha);
                }
                if (nuevoDetalle != null) {
                    reserva.setDetalle(nuevoDetalle);
                }
                break; 
            }
        }
    }

    public void eliminarReserva(String codigoSala, LocalDate fecha) {
        reservas.removeIf(r -> r.getSala().getCodigo().equals(codigoSala) && r.getFecha().equals(fecha));
    }
}
