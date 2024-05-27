package com.mycompany.restaurantepp;

import java.util.ArrayList;
import java.util.List;

public class UsuarioController {
    private List<Usuario> usuarios;

    public UsuarioController() {
        this.usuarios = new ArrayList<>();
        // Usuarios de prueba
        Rol admin = new Rol(1, "Administrador");
        Rol mesero = new Rol(2, "Mesero");
        Rol chef = new Rol(3, "Chef");
        Rol cliente = new Rol(4, "Cliente");
        Rol cajero = new Rol(5, "Cajero");

        usuarios.add(new Usuario("admin", "admin", admin));
        usuarios.add(new Usuario("mesero", "mesero", mesero));
        usuarios.add(new Usuario("chef", "chef", chef));
        usuarios.add(new Usuario("cliente", "cliente", cliente));
        usuarios.add(new Usuario("cajero", "cajero", cajero));
    }

    // Método para agregar un nuevo usuario
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    // Método para validar el usuario
    public Usuario validarUsuario(String username, String password) {
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username) && usuario.getPassword().equals(password)) {
                return usuario;
            }
        }
        return null;
    }
}
