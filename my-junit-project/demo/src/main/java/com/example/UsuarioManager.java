package com.example;

import java.util.ArrayList;
import java.util.List;

public class UsuarioManager {
    private final List<Usuario> usuarios;

    public UsuarioManager() {
        usuarios = new ArrayList<>();
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public List<Usuario> obtenerUsuarios() {
        return usuarios;
    }

    public Usuario obtenerUsuarioPorId(String id) {
        return usuarios.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void actualizarUsuario(Usuario usuarioActualizado) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(usuarioActualizado.getId())) {
                if (usuarioActualizado.getNombre() != null && !usuarioActualizado.getNombre().isEmpty()) {
                    usuario.setNombre(usuarioActualizado.getNombre());
                }
                if (usuarioActualizado.getDepartamento() != null && !usuarioActualizado.getDepartamento().isEmpty()) {
                    usuario.setDepartamento(usuarioActualizado.getDepartamento());
                }
                if (usuarioActualizado.getDescripcion() != null && !usuarioActualizado.getDescripcion().isEmpty()) {
                    usuario.setDescripcion(usuarioActualizado.getDescripcion());
                }
                break;
            }
        }
    }

    public void eliminarUsuario(String id) {
        usuarios.removeIf(u -> u.getId().equals(id));
    }
}
