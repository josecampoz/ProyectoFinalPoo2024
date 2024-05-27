package com.mycompany.restaurantepp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioGestionInventario extends JFrame {
    private JTextField idField;
    private JTextField nombreField;
    private JTextField cantidadField;
    private JTextField precioField; // Nuevo campo de texto para el precio
    private JButton crearButton;
    private JButton modificarButton;
    private JButton consultarButton;
    private JButton eliminarButton;
    private JTextArea resultadoArea;
    private Inventario inventario;

    public FormularioGestionInventario() {
        inventario = new Inventario();

        setTitle("Gestión de Inventario");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel idLabel = new JLabel("ID de Inventario:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(idLabel, gbc);

        idField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(idField, gbc);

        JLabel nombreLabel = new JLabel("Nombre de Producto:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(nombreLabel, gbc);

        nombreField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(nombreField, gbc);

        JLabel cantidadLabel = new JLabel("Cantidad:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(cantidadLabel, gbc);

        cantidadField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(cantidadField, gbc);

        JLabel precioLabel = new JLabel("Precio:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(precioLabel, gbc);

        precioField = new JTextField(10); // Crea el nuevo campo de texto para el precio
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(precioField, gbc);

        crearButton = new JButton("Crear");
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(crearButton, gbc);

        modificarButton = new JButton("Modificar");
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(modificarButton, gbc);

        consultarButton = new JButton("Consultar");
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(consultarButton, gbc);

        eliminarButton = new JButton("Eliminar");
        gbc.gridx = 1;
        gbc.gridy = 5;
        panel.add(eliminarButton, gbc);

        resultadoArea = new JTextArea(10, 30);
        resultadoArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultadoArea);
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        panel.add(scrollPane, gbc);

        add(panel);

        crearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                crearInventario();
            }
        });

        modificarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modificarInventario();
            }
        });

        consultarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                consultarInventario();
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarInventario();
            }
        });
    }

    private void crearInventario() {
        int id = Integer.parseInt(idField.getText());
        String nombre = nombreField.getText();
        int cantidad = Integer.parseInt(cantidadField.getText());
        double precio = Double.parseDouble(precioField.getText()); // Obtiene el valor del precio del nuevo campo de texto
        Plato plato = new Plato(id, nombre, precio, new Categoria(1, "Categoria de Ejemplo")); // Establece una categoría adecuada
        inventario.agregarPlato(plato, cantidad);
        resultadoArea.setText("Producto de inventario creado: " + plato.toString());
    }

    private void modificarInventario() {
        int id = Integer.parseInt(idField.getText());
        String nombre = nombreField.getText();
        int cantidad = Integer.parseInt(cantidadField.getText());
        double precio = Double.parseDouble(precioField.getText()); // Obtiene el valor del precio del nuevo campo de texto
        Plato plato = new Plato(id, nombre, precio, new Categoria(1, "Categoria de Ejemplo")); // Establece una categoría adecuada
        inventario.setStock(plato, cantidad);
        resultadoArea.setText("Producto de inventario modificado: " + plato.toString());
    }

    private void consultarInventario() {
        int id = Integer.parseInt(idField.getText());
        Plato plato = new Plato(id, nombreField.getText(), 0.0, new Categoria(1, "Categoria de Ejemplo")); // Precio es un valor double, establece una categoría adecuada
        int cantidad = inventario.obtenerCantidad(plato);
        resultadoArea.setText("Consulta de inventario: " + plato.toString() + ", Cantidad: " + cantidad);
    }

    private void eliminarInventario() {
        int id = Integer.parseInt(idField.getText());
        Plato plato = new Plato(id, nombreField.getText(), 0.0, new Categoria(1, "Categoria de Ejemplo")); // Precio es un valor double, establece una categoría adecuada
        inventario.removerPlato(plato, inventario.obtenerCantidad(plato));
        resultadoArea.setText("Producto de inventario eliminado con ID: " + id);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                FormularioGestionInventario form = new FormularioGestionInventario();
                form.setVisible(true);
            }
        });
    }
}
