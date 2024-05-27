package com.mycompany.restaurantepp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioGestionUsuarios extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JComboBox<String> rolComboBox;
    private JButton crearButton;
    private JButton modificarButton;
    private JButton consultarButton;
    private JButton eliminarButton;
    private JTextArea resultadoArea;
    private UsuarioController usuarioController;

    public FormularioGestionUsuarios() {
        setTitle("Gestión de Usuarios");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        usuarioController = new UsuarioController();

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel usernameLabel = new JLabel("Nombre de Usuario:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(usernameLabel, gbc);

        usernameField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(usernameField, gbc);

        JLabel passwordLabel = new JLabel("Contraseña:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(passwordLabel, gbc);

        passwordField = new JPasswordField(10);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(passwordField, gbc);

        JLabel rolLabel = new JLabel("Rol:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(rolLabel, gbc);

        rolComboBox = new JComboBox<>();
        rolComboBox.addItem("Administrador");
        rolComboBox.addItem("Mesero");
        rolComboBox.addItem("Chef");
        rolComboBox.addItem("Cliente");
        rolComboBox.addItem("Cajero");
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(rolComboBox, gbc);

        crearButton = new JButton("Crear");
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(crearButton, gbc);

        modificarButton = new JButton("Modificar");
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(modificarButton, gbc);

        consultarButton = new JButton("Consultar");
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(consultarButton, gbc);

        eliminarButton = new JButton("Eliminar");
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(eliminarButton, gbc);

        resultadoArea = new JTextArea(10, 30);
        resultadoArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultadoArea);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        panel.add(scrollPane, gbc);

        add(panel);

        crearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                crearUsuario();
            }
        });

        modificarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modificarUsuario();
            }
        });

        consultarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                consultarUsuario();
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarUsuario();
            }
        });
    }

    private void crearUsuario() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String rol = (String) rolComboBox.getSelectedItem();
        Usuario usuario = new Usuario(username, password, new Rol(0, rol));
        usuarioController.agregarUsuario(usuario);
        resultadoArea.setText("Usuario creado: " + usuario.toString());
    }

    private void modificarUsuario() {
        // Implementa la lógica para modificar un usuario existente
    }

    private void consultarUsuario() {
        // Implementa la lógica para consultar un usuario existente
    }

    private void eliminarUsuario() {
        // Implementa la lógica para eliminar un usuario existente
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                FormularioGestionUsuarios form = new FormularioGestionUsuarios();
                form.setVisible(true);
            }
        });
    }
}
