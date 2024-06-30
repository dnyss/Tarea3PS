package com.example;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class SalaManagerTest {
    private SalaManager salaManager;

    @Before
    public void setUp() {
        salaManager = new SalaManager();
    }

    @Test
    public void testAgregarSala() {
        Sala sala = new Sala("001", "Sala 1", "Planta Baja");
        salaManager.agregarSala(sala);
        assertEquals(1, salaManager.obtenerSalas().size());
    }

    @Test
    public void testEliminarSala() {
        Sala sala = new Sala("001", "Sala 1", "Planta Baja");
        salaManager.agregarSala(sala);
        salaManager.eliminarSala("001");
        assertEquals(0, salaManager.obtenerSalas().size());
    }

    @Test
    public void testActualizarSala() {
        Sala sala = new Sala("001", "Sala 1", "Planta Baja");
        salaManager.agregarSala(sala);

        Sala salaActualizada = new Sala("001", "Nueva Sala", "Primer Piso");
        salaManager.actualizarSala(salaActualizada);

        Sala salaObtenida = salaManager.obtenerSalaPorCodigo("001");
        assertEquals("Nueva Sala", salaObtenida.getNombre());
        assertEquals("Primer Piso", salaObtenida.getUbicacion());
    }
}
