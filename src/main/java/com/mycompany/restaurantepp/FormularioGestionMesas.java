
package com.mycompany.restaurantepp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioGestionMesas extends JFrame {
    private JTextField numeroField;
    private JTextField capacidadField;
    private JButton crearButton;
    private JButton modificarButton;
    private JButton consultarButton;
    private JButton eliminarButton;
    private JTextArea resultadoArea;

    public FormularioGestionMesas() {
        setTitle("Gestión de Mesas");
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

        JLabel numeroLabel = new JLabel("Número de Mesa:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(numeroLabel, gbc);

        numeroField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(numeroField, gbc);

        JLabel capacidadLabel = new JLabel("Capacidad:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(capacidadLabel, gbc);

        capacidadField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(capacidadField, gbc);

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
                crearMesa();
            }
        });

        modificarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modificarMesa();
            }
        });

        consultarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                consultarMesa();
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarMesa();
            }
        });
    }

    public void crearMesa() {
        int numero = Integer.parseInt(numeroField.getText());
        int capacidad = Integer.parseInt(capacidadField.getText());
        Mesa mesa = new Mesa(numero, capacidad);
        resultadoArea.setText("Mesa creada: " + mesa.toString());
    }

    private void modificarMesa() {
        int numero = Integer.parseInt(numeroField.getText());
        int capacidad = Integer.parseInt(capacidadField.getText());
        // Aquí puedes agregar lógica para buscar y modificar una mesa existente
        Mesa mesa = new Mesa(numero, capacidad);
        resultadoArea.setText("Mesa modificada: " + mesa.toString());
    }

    private void consultarMesa() {
        int numero = Integer.parseInt(numeroField.getText());
        // Aquí puedes agregar lógica para buscar y consultar una mesa existente
        Mesa mesa = new Mesa(numero, 0); // Cambia el 0 por la capacidad real de la mesa consultada
        resultadoArea.setText("Consulta de mesa: " + mesa.toString());
    }

    private void eliminarMesa() {
        int numero = Integer.parseInt(numeroField.getText());
        // Aquí puedes agregar lógica para buscar y eliminar una mesa existente
        resultadoArea.setText("Mesa eliminada con número: " + numero);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                FormularioGestionMesas form = new FormularioGestionMesas();
                form.setVisible(true);
            }
        });
    }
}
