package com.example;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

public class ReservaManagerTest {
    private ReservaManager reservaManager;
    private Sala sala;
    private Usuario usuario;

    @Before
    public void setUp() {
        reservaManager = new ReservaManager();
        sala = new Sala("001", "Sala 1", "Planta Baja");
        usuario = new Usuario("001", "Juan", "IT", "Desarrollador");
    }

    @Test
    public void testAgregarReserva() {
        Reserva reserva = new Reserva(sala, usuario, LocalDate.now(), "Reunión de equipo");
        reservaManager.agregarReserva(reserva);
        assertEquals(1, reservaManager.obtenerReservas().size());
    }

    @Test
    public void testEliminarReserva() {
        Reserva reserva = new Reserva(sala, usuario, LocalDate.now(), "Reunión de equipo");
        reservaManager.agregarReserva(reserva);
        reservaManager.eliminarReserva("001", LocalDate.now());
        assertEquals(0, reservaManager.obtenerReservas().size());
    }

    @Test
    public void testActualizarReserva() {
        Reserva reserva = new Reserva(sala, usuario, LocalDate.now(), "Reunión de equipo");
        reservaManager.agregarReserva(reserva);

        Sala nuevaSala = new Sala("002", "Sala 2", "Primer Piso");
        Usuario nuevoUsuario = new Usuario("002", "Maria", "Finanzas", "Analista");
        LocalDate nuevaFecha = LocalDate.now().plusDays(1);
        String nuevoDetalleReserva = "Reunión de proyecto";

        reservaManager.actualizarReserva("001", LocalDate.now(), nuevaSala, nuevoUsuario, nuevaFecha, nuevoDetalleReserva);

        Reserva reservaActualizada = reservaManager.obtenerReservaPorSalaYFecha("002", nuevaFecha);
        assertNotNull(reservaActualizada);
        assertEquals("Sala 2", reservaActualizada.getSala().getNombre());
        assertEquals("Maria", reservaActualizada.getUsuario().getNombre());
        assertEquals(nuevaFecha, reservaActualizada.getFecha());
        assertEquals(nuevoDetalleReserva, reservaActualizada.getDetalle());
    }

    @Test
    public void testObtenerReservas() {
        // reservas de ejemplo
        Reserva reserva1 = new Reserva(sala, usuario, LocalDate.now(), "Reunión de equipo");
        Reserva reserva2 = new Reserva(sala, usuario, LocalDate.now().plusDays(1), "Entrevista");
        reservaManager.agregarReserva(reserva1);
        reservaManager.agregarReserva(reserva2);

        List<Reserva> reservas = reservaManager.obtenerReservas();

        assertEquals(2, reservas.size());

        assertEquals("Reunión de equipo", reservas.get(0).getDetalle());
        assertEquals("Entrevista", reservas.get(1).getDetalle());
    }
}
