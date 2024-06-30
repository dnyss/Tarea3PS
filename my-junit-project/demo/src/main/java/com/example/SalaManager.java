package com.example;

import java.util.ArrayList;
import java.util.List;

public class SalaManager {
    private final List<Sala> salas;

    public SalaManager() {
        salas = new ArrayList<>();
    }

    public void agregarSala(Sala sala) {
        salas.add(sala);
    }

    public List<Sala> obtenerSalas() {
        return salas;
    }

    public Sala obtenerSalaPorCodigo(String codigo) {
        return salas.stream()
                .filter(s -> s.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);
    }

    public void actualizarSala(Sala salaActualizada) {
        for (Sala sala : salas) {
            if (sala.getCodigo().equals(salaActualizada.getCodigo())) {
                if (salaActualizada.getNombre() != null && !salaActualizada.getNombre().isEmpty()) {
                    sala.setNombre(salaActualizada.getNombre());
                }
                if (salaActualizada.getUbicacion() != null && !salaActualizada.getUbicacion().isEmpty()) {
                    sala.setUbicacion(salaActualizada.getUbicacion());
                }
                break;
            }
        }
    }

    public void eliminarSala(String codigo) {
        salas.removeIf(s -> s.getCodigo().equals(codigo));
    }
}
