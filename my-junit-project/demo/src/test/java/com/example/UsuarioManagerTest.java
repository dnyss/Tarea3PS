package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

public class UsuarioManagerTest {
    private UsuarioManager usuarioManager;

    @Before
    public void setUp() {
        usuarioManager = new UsuarioManager();
    }

    @Test
    public void testAgregarUsuario() {
        Usuario usuario = new Usuario("001", "Juan", "IT", "Desarrollador");
        usuarioManager.agregarUsuario(usuario);
        assertEquals(1, usuarioManager.obtenerUsuarios().size());
    }

    @Test
    public void testEliminarUsuario() {
        Usuario usuario = new Usuario("001", "Juan", "IT", "Desarrollador");
        usuarioManager.agregarUsuario(usuario);
        usuarioManager.eliminarUsuario("001");
        assertEquals(0, usuarioManager.obtenerUsuarios().size());
    }

    @Test
    public void testActualizarUsuario() {
        Usuario usuario = new Usuario("001", "Juan", "IT", "Desarrollador");
        usuarioManager.agregarUsuario(usuario);

        Usuario usuarioActualizado = new Usuario("001", "Juan Actualizado", "HR", "Gerente");
        usuarioManager.actualizarUsuario(usuarioActualizado);

        Usuario usuarioObtenido = usuarioManager.obtenerUsuarioPorId("001");
        assertEquals("Juan Actualizado", usuarioObtenido.getNombre());
        assertEquals("HR", usuarioObtenido.getDepartamento());
        assertEquals("Gerente", usuarioObtenido.getDescripcion());
    }

    @Test
    public void testObtenerUsuarioPorId() {
        Usuario usuario = new Usuario("001", "Juan", "IT", "Desarrollador");
        usuarioManager.agregarUsuario(usuario);

        Usuario usuarioObtenido = usuarioManager.obtenerUsuarioPorId("001");
        assertNotNull(usuarioObtenido);
        assertEquals("Juan", usuarioObtenido.getNombre());
        assertEquals("IT", usuarioObtenido.getDepartamento());
        assertEquals("Desarrollador", usuarioObtenido.getDescripcion());
    }
}
