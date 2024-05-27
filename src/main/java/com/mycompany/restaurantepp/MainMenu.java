package com.mycompany.restaurantepp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class MainMenu extends JFrame {
    private JButton gestionarPedidosButton;
    private JButton gestionarMesasButton;
    private JButton gestionarCategoriasButton;
    private JButton gestionarPlatosButton;
    private JButton gestionarUsuariosButton;
    private JButton gestionarInventarioButton;

    public MainMenu(Usuario usuario) {
        setTitle("Menú Principal");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(245, 245, 245));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel label = new JLabel("Bienvenido, " + usuario.getUsername());
        label.setFont(new Font("Arial", Font.BOLD, 22));
        label.setForeground(new Color(60, 63, 65));
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(label, gbc);

        gestionarPedidosButton = createButton("Gestionar Pedidos", "iconos/pedidos.png");
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(gestionarPedidosButton, gbc);

        if (usuario.getRol().getNombre().equals("Administrador")) {
            gestionarMesasButton = createButton("Gestionar Mesas", "iconos/mesas.png");
            gestionarCategoriasButton = createButton("Gestionar Categorias", "iconos/categorias.png");
            gestionarPlatosButton = createButton("Gestionar Platos", "iconos/platos.png");
            gestionarUsuariosButton = createButton("Gestionar Usuarios", "iconos/usuarios.png");
            gestionarInventarioButton = createButton("Gestionar Inventario", "iconos/inventario.png");

            gbc.gridwidth = 1;
            gbc.gridx = 0;
            gbc.gridy = 2;
            panel.add(gestionarMesasButton, gbc);

            gbc.gridx = 1;
            gbc.gridy = 2;
            panel.add(gestionarCategoriasButton, gbc);

            gbc.gridx = 0;
            gbc.gridy = 3;
            panel.add(gestionarPlatosButton, gbc);

            gbc.gridx = 1;
            gbc.gridy = 3;
            panel.add(gestionarUsuariosButton, gbc);

            gbc.gridx = 0;
            gbc.gridy = 4;
            panel.add(gestionarInventarioButton, gbc);
        }

        // Configurar acciones de los botones
        gestionarPedidosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirFormularioGestionPedidos();
            }
        });

        if (usuario.getRol().getNombre().equals("Administrador")) {
            gestionarMesasButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    abrirFormularioGestionMesas();
                }
            });

            gestionarCategoriasButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    abrirFormularioGestionCategorias();
                }
            });

            gestionarPlatosButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    abrirFormularioGestionPlatos();
                }
            });

            gestionarUsuariosButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    abrirFormularioGestionUsuarios();
                }
            });

            gestionarInventarioButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    abrirFormularioGestionInventario();
                }
            });
        }

        // Agregar el panel al formulario
        add(panel);
    }

    private JButton createButton(String text, String iconPath) {
        JButton button = new JButton(text);
        URL iconURL = getClass().getResource(iconPath);
        if (iconURL != null) {
            button.setIcon(new ImageIcon(iconURL));
        }
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setPreferredSize(new Dimension(250, 60));
        button.setBackground(new Color(220, 220, 220));
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(60, 63, 65)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        return button;
    }

    private void abrirFormularioGestionPedidos() {
        PedidoForm pedidoForm = new PedidoForm(this);
        pedidoForm.setVisible(true);
        setVisible(false); // Ocultar MainMenu
    }

    private void abrirFormularioGestionMesas() {
        // Implementar lógica para abrir el formulario de gestión de mesas
        JOptionPane.showMessageDialog(this, "Abrir formulario de gestión de mesas");
    }

    private void abrirFormularioGestionCategorias() {
        // Implementar lógica para abrir el formulario de gestión de categorías
        JOptionPane.showMessageDialog(this, "Abrir formulario de gestión de categorías");
    }

    private void abrirFormularioGestionPlatos() {
        FormularioGestionPlatos formPlatos = new FormularioGestionPlatos(this);
        formPlatos.setVisible(true);
        setVisible(false); // Ocultar MainMenu
    }

    private void abrirFormularioGestionUsuarios() {
        // Implementar lógica para abrir el formulario de gestión de usuarios
        JOptionPane.showMessageDialog(this, "Abrir formulario de gestión de usuarios");
    }

    private void abrirFormularioGestionInventario() {
        // Implementar lógica para abrir el formulario de gestión de inventario
        JOptionPane.showMessageDialog(this, "Abrir formulario de gestión de inventario");
    }

    // Método principal para ejecutar la aplicación
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Rol rol = new Rol(1, "Administrador"); // Crear un rol de prueba
                Usuario usuario = new Usuario("admin", "admin", rol); // Crear un usuario de prueba
                MainMenu mainMenu = new MainMenu(usuario);
                mainMenu.setVisible(true);
            }
        });
    }
}
