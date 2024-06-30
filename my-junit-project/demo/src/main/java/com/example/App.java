package com.example;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class App {
    private static final SalaManager salaManager = new SalaManager();
    private static final UsuarioManager usuarioManager = new UsuarioManager();
    private static final ReservaManager reservaManager = new ReservaManager();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menú Principal:");
            System.out.println("1. Gestión de Usuarios");
            System.out.println("2. Gestión de Salas");
            System.out.println("3. Gestión de Reservas");
            System.out.println("4. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    gestionUsuarios(scanner);
                    break;
                case 2:
                    gestionSalas(scanner);
                    break;
                case 3:
                    gestionReservas(scanner);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void gestionUsuarios(Scanner scanner) {
        System.out.println("Gestión de Usuarios:");
        System.out.println("1. Crear Usuario");
        System.out.println("2. Actualizar Usuario");
        System.out.println("3. Eliminar Usuario");
        System.out.println("4. Ver Usuario por ID");
        System.out.println("5. Volver al Menú Principal");
        int opcion = scanner.nextInt();
        scanner.nextLine();
    
        switch (opcion) {
            case 1:
                crearUsuario(scanner);
                break;
            case 2:
                actualizarUsuario(scanner);
                break;
            case 3:
                eliminarUsuario(scanner);
                break;
            case 4:
                verUsuarioPorId(scanner); 
                break;
            case 5:
                return; 
            default:
                System.out.println("Opción no válida.");
        }
    }
    
    private static void verUsuarioPorId(Scanner scanner) {
        System.out.println("Ingrese el ID del usuario:");
        String id = scanner.nextLine().trim();
    
        Usuario usuario = usuarioManager.obtenerUsuarioPorId(id);
        if (usuario == null) {
            System.out.println("No existe un usuario con ese ID.");
        } else {
            System.out.println("Usuario encontrado:");
            System.out.println("ID: " + usuario.getId());
            System.out.println("Nombre: " + usuario.getNombre());
            System.out.println("Departamento: " + usuario.getDepartamento());
            System.out.println("Descripción: " + usuario.getDescripcion());
        }
    }

    private static void crearUsuario(Scanner scanner) {
        System.out.println("Ingrese el ID del usuario:");
        String id = scanner.nextLine().trim();

        // Verificar si el usuario ya existe
        if (usuarioManager.obtenerUsuarioPorId(id) != null) {
            System.out.println("Ya existe un usuario con ese ID.");
            return;
        }

        // Leer otros datos del usuario
        System.out.println("Ingrese el nombre del usuario:");
        String nombre = scanner.nextLine().trim();
        System.out.println("Ingrese el departamento del usuario:");
        String departamento = scanner.nextLine().trim();
        System.out.println("Ingrese la descripción del usuario:");
        String descripcion = scanner.nextLine().trim();

        // Crear el objeto Usuario y agregarlo
        Usuario nuevoUsuario = new Usuario(id, nombre, departamento, descripcion);
        usuarioManager.agregarUsuario(nuevoUsuario);
        System.out.println("Usuario creado correctamente.");
    }

    private static void actualizarUsuario(Scanner scanner) {
        System.out.println("Ingrese el ID del usuario a actualizar:");
        String id = scanner.nextLine().trim();

        Usuario usuarioExistente = usuarioManager.obtenerUsuarioPorId(id);
        if (usuarioExistente == null) {
            System.out.println("No existe un usuario con ese ID.");
            return;
        }

        // Leer nuevos datos del usuario
        System.out.println("Ingrese el nuevo nombre del usuario (dejar vacío para mantener):");
        String nuevoNombre = scanner.nextLine().trim();
        if (!nuevoNombre.isEmpty()) {
            usuarioExistente.setNombre(nuevoNombre);
        }

        System.out.println("Ingrese el nuevo departamento del usuario (dejar vacío para mantener):");
        String nuevoDepartamento = scanner.nextLine().trim();
        if (!nuevoDepartamento.isEmpty()) {
            usuarioExistente.setDepartamento(nuevoDepartamento);
        }

        System.out.println("Ingrese la nueva descripción del usuario (dejar vacío para mantener):");
        String nuevaDescripcion = scanner.nextLine().trim();
        if (!nuevaDescripcion.isEmpty()) {
            usuarioExistente.setDescripcion(nuevaDescripcion);
        }

        // Actualizar usuario en el usuarioManager
        usuarioManager.actualizarUsuario(usuarioExistente);
        System.out.println("Usuario actualizado correctamente.");
    }

    private static void eliminarUsuario(Scanner scanner) {
        System.out.println("Ingrese el ID del usuario a eliminar:");
        String id = scanner.nextLine().trim();

        Usuario usuarioExistente = usuarioManager.obtenerUsuarioPorId(id);
        if (usuarioExistente == null) {
            System.out.println("No existe un usuario con ese ID.");
            return;
        }

        // Eliminar usuario del usuarioManager
        usuarioManager.eliminarUsuario(id);
        System.out.println("Usuario eliminado correctamente.");
    }
    
    private static void gestionSalas(Scanner scanner) {
        System.out.println("Gestión de Salas:");
        System.out.println("1. Crear Sala");
        System.out.println("2. Actualizar Sala");
        System.out.println("3. Eliminar Sala");
        System.out.println("4. Ver Sala por Código");
        System.out.println("5. Volver al Menú Principal");
    
        int opcion = scanner.nextInt();
        scanner.nextLine(); 
    
        switch (opcion) {
            case 1:
                crearSala(scanner);
                break;
            case 2:
                actualizarSala(scanner);
                break;
            case 3:
                eliminarSala(scanner);
                break;
            case 4:
                verSalaPorCodigo(scanner);
                break;
            case 5:
                return; 
            default:
                System.out.println("Opción no válida.");
        }
    }
    
    private static void verSalaPorCodigo(Scanner scanner) {
        System.out.println("Ingrese el código de la sala:");
        String codigo = scanner.nextLine().trim();
    
        Sala sala = salaManager.obtenerSalaPorCodigo(codigo);
        if (sala == null) {
            System.out.println("No existe una sala con ese código.");
        } else {
            System.out.println("Detalles de la Sala:");
            System.out.println("Código: " + sala.getCodigo());
            System.out.println("Nombre: " + sala.getNombre());
            System.out.println("Ubicación: " + sala.getUbicacion());
        }
    }    

    private static void crearSala(Scanner scanner) {
        System.out.println("Ingrese el código de la sala:");
        String codigo = scanner.nextLine().trim();

        // Verificar si la sala ya existe
        if (salaManager.obtenerSalaPorCodigo(codigo) != null) {
            System.out.println("Ya existe una sala con ese código.");
            return;
        }

        // Leer otros datos de la sala
        System.out.println("Ingrese el nombre de la sala:");
        String nombre = scanner.nextLine().trim();
        System.out.println("Ingrese la ubicación de la sala:");
        String ubicacion = scanner.nextLine().trim();

        // Crear el objeto Sala y agregarlo
        Sala nuevaSala = new Sala(codigo, nombre, ubicacion);
        salaManager.agregarSala(nuevaSala);
        System.out.println("Sala creada correctamente.");
    }

    private static void actualizarSala(Scanner scanner) {
        System.out.println("Ingrese el código de la sala a actualizar:");
        String codigo = scanner.nextLine().trim();

        Sala salaExistente = salaManager.obtenerSalaPorCodigo(codigo);
        if (salaExistente == null) {
            System.out.println("No existe una sala con ese código.");
            return;
        }

        // Leer nuevos datos de la sala
        System.out.println("Ingrese el nuevo nombre de la sala (dejar vacío para mantener):");
        String nuevoNombre = scanner.nextLine().trim();
        if (!nuevoNombre.isEmpty()) {
            salaExistente.setNombre(nuevoNombre);
        }

        System.out.println("Ingrese la nueva ubicación de la sala (dejar vacío para mantener):");
        String nuevaUbicacion = scanner.nextLine().trim();
        if (!nuevaUbicacion.isEmpty()) {
            salaExistente.setUbicacion(nuevaUbicacion);
        }

        // Actualizar sala en el salaManager
        salaManager.actualizarSala(salaExistente);
        System.out.println("Sala actualizada correctamente.");
    }

    private static void eliminarSala(Scanner scanner) {
        System.out.println("Ingrese el código de la sala a eliminar:");
        String codigo = scanner.nextLine().trim();

        Sala salaExistente = salaManager.obtenerSalaPorCodigo(codigo);
        if (salaExistente == null) {
            System.out.println("No existe una sala con ese código.");
            return;
        }

        // Eliminar sala del salaManager
        salaManager.eliminarSala(codigo);
        System.out.println("Sala eliminada correctamente.");
    }

    private static void gestionReservas(Scanner scanner) {
        System.out.println("Gestión de Reservas:");
        System.out.println("1. Crear Reserva");
        System.out.println("2. Actualizar Reserva");
        System.out.println("3. Eliminar Reserva");
        System.out.println("4. Ver todas las reservas");
        System.out.println("5. Volver al Menú Principal");
        int opcion = scanner.nextInt();
        scanner.nextLine(); 

        switch (opcion) {
            case 1:
                crearReserva(scanner);
                break;
            case 2:
                actualizarReserva(scanner);
                break;
            case 3:
                eliminarReserva(scanner);
                break;
            case 4:
                verTodasLasReservas();
                break;
            case 5:
                return; 
            default:
                System.out.println("Opción no válida.");
        }
    }

    private static void crearReserva(Scanner scanner) {
        System.out.println("Ingrese el código de la sala:");
        String codigoSala = scanner.nextLine().trim();

        Sala sala = salaManager.obtenerSalaPorCodigo(codigoSala);
        if (sala == null) {
            System.out.println("No existe una sala con ese código.");
            return;
        }

        System.out.println("Ingrese el ID del usuario:");
        String idUsuario = scanner.nextLine().trim();

        Usuario usuario = usuarioManager.obtenerUsuarioPorId(idUsuario);
        if (usuario == null) {
            System.out.println("No existe un usuario con ese ID.");
            return;
        }

        System.out.println("Ingrese la fecha de la reserva (AAAA-MM-DD):");
        LocalDate fechaReserva = LocalDate.parse(scanner.nextLine().trim());

        System.out.println("Ingrese el detalle de la reserva:");
        String detalleReserva = scanner.nextLine().trim();

        // Crear la reserva y agregarla
        Reserva reserva = new Reserva(sala, usuario, fechaReserva, detalleReserva);
        reservaManager.agregarReserva(reserva);
        System.out.println("Reserva creada correctamente.");
    }

    private static void verTodasLasReservas() {
    List<Reserva> reservas = reservaManager.obtenerTodasLasReservas();
    if (reservas.isEmpty()) {
        System.out.println("No hay reservas registradas.");
    } else {
        System.out.println("Lista de Reservas:");
        for (Reserva reserva : reservas) {
            System.out.println(reserva);
        }
    }
}

    private static void actualizarReserva(Scanner scanner) {
        System.out.println("Ingrese el código de la sala de la reserva:");
        String codigoSala = scanner.nextLine().trim();

        System.out.println("Ingrese la fecha de la reserva (AAAA-MM-DD):");
        LocalDate fechaReserva = LocalDate.parse(scanner.nextLine().trim());

        Sala nuevaSala = null;
        Usuario nuevoUsuario = null;
        LocalDate nuevaFecha = null;
        String nuevoDetalleReserva = null;

        // Obtener la reserva a actualizar
        Reserva reserva = reservaManager.obtenerReservaPorSalaYFecha(codigoSala, fechaReserva);
        if (reserva == null) {
            System.out.println("No existe una reserva con ese código de sala y fecha.");
            return;
        }

        System.out.println("Desea actualizar la sala de la reserva? (S/N)");
        String respuesta = scanner.nextLine().trim();
        if (respuesta.equalsIgnoreCase("S")) {
            System.out.println("Ingrese el nuevo código de la sala:");
            String nuevoCodigoSala = scanner.nextLine().trim();
            nuevaSala = salaManager.obtenerSalaPorCodigo(nuevoCodigoSala);
            if (nuevaSala == null) {
                System.out.println("No existe una sala con ese nuevo código.");
                return;
            }
        }

        System.out.println("Desea actualizar el usuario de la reserva? (S/N)");
        respuesta = scanner.nextLine().trim();
        if (respuesta.equalsIgnoreCase("S")) {
            System.out.println("Ingrese el nuevo ID del usuario:");
            String nuevoIdUsuario = scanner.nextLine().trim();
            nuevoUsuario = usuarioManager.obtenerUsuarioPorId(nuevoIdUsuario);
            if (nuevoUsuario == null) {
                System.out.println("No existe un usuario con ese nuevo ID.");
                return;
            }
        }

        System.out.println("Desea actualizar la fecha de la reserva? (S/N)");
        respuesta = scanner.nextLine().trim();
        if (respuesta.equalsIgnoreCase("S")) {
            System.out.println("Ingrese la nueva fecha de la reserva (AAAA-MM-DD):");
            nuevaFecha = LocalDate.parse(scanner.nextLine().trim());
        }

        System.out.println("Desea actualizar el detalle de la reserva? (S/N)");
        respuesta = scanner.nextLine().trim();
        if (respuesta.equalsIgnoreCase("S")) {
            System.out.println("Ingrese el nuevo detalle de la reserva:");
            nuevoDetalleReserva = scanner.nextLine().trim();
        }

        // Actualizar la reserva
        reserva.setSala(nuevaSala != null ? nuevaSala : reserva.getSala());
        reserva.setUsuario(nuevoUsuario != null ? nuevoUsuario : reserva.getUsuario());
        reserva.setFecha(nuevaFecha != null ? nuevaFecha : reserva.getFecha());
        reserva.setDetalle(nuevoDetalleReserva != null ? nuevoDetalleReserva : reserva.getDetalle());

        System.out.println("Reserva actualizada correctamente.");
    }

    private static void eliminarReserva(Scanner scanner) {
        System.out.println("Ingrese el código de la sala de la reserva:");
        String codigoSala = scanner.nextLine().trim();

        System.out.println("Ingrese la fecha de la reserva (AAAA-MM-DD):");
        LocalDate fechaReserva = LocalDate.parse(scanner.nextLine().trim());

        // Eliminar la reserva
        reservaManager.eliminarReserva(codigoSala, fechaReserva);
        System.out.println("Reserva eliminada correctamente.");
    }

}

