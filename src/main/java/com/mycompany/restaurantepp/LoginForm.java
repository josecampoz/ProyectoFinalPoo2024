package com.mycompany.restaurantepp;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton clearButton;
    private JButton exitButton;
    private UsuarioController usuarioController;

    public LoginForm() {
        // Configuración básica del formulario
        setTitle("Inicio de Sesión");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inicialización del controlador de usuarios
        usuarioController = new UsuarioController();

        // Creación del panel principal y configuración de su layout
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Etiqueta y campo de usuario
        JLabel userLabel = new JLabel("Usuario:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(userLabel, gbc);

        usernameField = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(usernameField, gbc);

        // Etiqueta y campo de contraseña
        JLabel passLabel = new JLabel("Contraseña:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(passLabel, gbc);

        passwordField = new JPasswordField();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(passwordField, gbc);

        // Botón de iniciar sesión
        loginButton = new JButton("Iniciar Sesión");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(loginButton, gbc);

        // Botón de limpiar campos
        clearButton = new JButton("Limpiar");
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(clearButton, gbc);

        // Botón de salir del sistema
        exitButton = new JButton("Salir del Sistema");
        gbc.gridx = 2;
        gbc.gridy = 2;
        panel.add(exitButton, gbc);

        // Agregar el panel al formulario
        add(panel);

        // Configuración del evento de clic para el botón de inicio de sesión
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener el nombre de usuario y contraseña ingresados por el usuario
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Validar el usuario utilizando el controlador de usuarios
                Usuario usuario = usuarioController.validarUsuario(username, password);

                // Si el usuario es válido, abrir el menú principal y cerrar el formulario de inicio de sesión
                if (usuario != null) {
                    MainMenu mainMenu = new MainMenu(usuario);
                    mainMenu.setVisible(true);
                    dispose();
                } else {
                    // Si el usuario no es válido, mostrar un mensaje de error
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                }
            }
        });

        // Configuración del evento de clic para el botón Limpiar
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Limpiar los campos de texto y contraseña
                usernameField.setText("");
                passwordField.setText("");
            }
        });

        // Configuración del evento de clic para el botón Salir del Sistema
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Salir del sistema
                System.exit(0);
            }
        });
    }

    // Método principal para ejecutar la aplicación
    public static void main(String[] args) {
        // Crear una instancia del formulario de inicio de sesión y hacerlo visible
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LoginForm loginForm = new LoginForm();
                loginForm.setVisible(true);
            }
        });
    }
}
