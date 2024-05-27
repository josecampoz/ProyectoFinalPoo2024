package com.mycompany.restaurantepp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioGestionCategorias extends JFrame {
    private JTextField idField;
    private JTextField nombreField;
    private JButton crearButton;
    private JButton modificarButton;
    private JButton consultarButton;
    private JButton eliminarButton;
    private JTextArea resultadoArea;

    public FormularioGestionCategorias() {
        setTitle("Gestión de Categorías");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Establecer un look-and-feel moderno
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Configuración del panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel idLabel = new JLabel("ID de Categoría:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(idLabel, gbc);

        idField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(idField, gbc);

        JLabel nombreLabel = new JLabel("Nombre de Categoría:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(nombreLabel, gbc);

        nombreField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(nombreField, gbc);

        crearButton = new JButton("Crear");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(crearButton, gbc);

        modificarButton = new JButton("Modificar");
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(modificarButton, gbc);

        consultarButton = new JButton("Consultar");
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(consultarButton, gbc);

        eliminarButton = new JButton("Eliminar");
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(eliminarButton, gbc);

        resultadoArea = new JTextArea(10, 30);
        resultadoArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultadoArea);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(scrollPane, gbc);

        add(panel);

        // Configurar acciones de los botones
        crearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                crearCategoria();
            }
        });

        modificarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modificarCategoria();
            }
        });

        consultarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                consultarCategoria();
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarCategoria();
            }
        });
    }

    private void crearCategoria() {
        int id = Integer.parseInt(idField.getText());
        String nombre = nombreField.getText();
        Categoria categoria = new Categoria(id, nombre);
        resultadoArea.setText("Categoría creada: " + categoria.toString());
    }

    private void modificarCategoria() {
        int id = Integer.parseInt(idField.getText());
        String nombre = nombreField.getText();
        // Aquí puedes agregar lógica para buscar y modificar una categoría existente
        Categoria categoria = new Categoria(id, nombre);
        resultadoArea.setText("Categoría modificada: " + categoria.toString());
    }

    private void consultarCategoria() {
        int id = Integer.parseInt(idField.getText());
        // Aquí puedes agregar lógica para buscar y consultar una categoría existente
        Categoria categoria = new Categoria(id, "Nombre de Ejemplo"); // Cambia "Nombre de Ejemplo" por el nombre real de la categoría consultada
        resultadoArea.setText("Consulta de categoría: " + categoria.toString());
    }

    private void eliminarCategoria() {
        int id = Integer.parseInt(idField.getText());
        // Aquí puedes agregar lógica para buscar y eliminar una categoría existente
        resultadoArea.setText("Categoría eliminada con ID: " + id);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                FormularioGestionCategorias form = new FormularioGestionCategorias();
                form.setVisible(true);
            }
        });
    }
}
