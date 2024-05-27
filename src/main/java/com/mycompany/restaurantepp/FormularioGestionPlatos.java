package com.mycompany.restaurantepp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class FormularioGestionPlatos extends JFrame {
    private JTextField idField;
    private JTextField nombreField;
    private JTextField precioField;
    private JButton crearButton;
    private JButton modificarButton;
    private JButton consultarButton;
    private JButton eliminarButton;
    private JTextArea resultadoArea;
    private List<Plato> listaPlatos; // Definición de la lista de platos
    private MainMenu mainMenu;

    public FormularioGestionPlatos(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
        setTitle("Gestión de Platos");
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

        JLabel idLabel = new JLabel("ID de Plato:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(idLabel, gbc);

        idField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(idField, gbc);

        JLabel nombreLabel = new JLabel("Nombre de Plato:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(nombreLabel, gbc);

        nombreField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(nombreField, gbc);

        JLabel precioLabel = new JLabel("Precio de Plato:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(precioLabel, gbc);

        precioField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(precioField, gbc);

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
                crearPlato();
            }
        });

        modificarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modificarPlato();
            }
        });

        consultarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                consultarPlato();
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarPlato();
            }
        });

        listaPlatos = new ArrayList<>(); // Inicialización de la lista de platos

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mainMenu.setVisible(true);
            }
        });
    }

    private void crearPlato() {
        int id = Integer.parseInt(idField.getText());
        String nombre = nombreField.getText();
        double precio = Double.parseDouble(precioField.getText());
        Categoria categoria = new Categoria(1, "Categoria Ejemplo"); // Define una nueva categoría
        Plato plato = new Plato(id, nombre, precio, categoria);
        listaPlatos.add(plato); // Añadir el plato a la lista
        resultadoArea.setText("Plato creado: " + plato.toString());
    }

    private void modificarPlato() {
        int id = Integer.parseInt(idField.getText());
        String nombre = nombreField.getText();
        double precio = Double.parseDouble(precioField.getText());
        Categoria categoria = new Categoria(1, "Categoria Ejemplo"); // Define una nueva categoría
        Plato plato = new Plato(id, nombre, precio, categoria);
        // Lógica para modificar el plato en la lista
        for (int i = 0; i < listaPlatos.size(); i++) {
            if (listaPlatos.get(i).getId() == id) {
                listaPlatos.set(i, plato);
                resultadoArea.setText("Plato modificado: " + plato.toString());
                return;
            }
        }
        resultadoArea.setText("No se encontró un plato con el ID especificado.");
    }

    private void consultarPlato() {
        int id = Integer.parseInt(idField.getText());
        // Lógica para consultar el plato en la lista
        for (Plato plato : listaPlatos) {
            if (plato.getId() == id) {
                resultadoArea.setText("Consulta de plato: " + plato.toString());
                return;
            }
        }
        resultadoArea.setText("No se encontró un plato con el ID especificado.");
    }

    private void eliminarPlato() {
        try {
            int id = Integer.parseInt(idField.getText());

            // Buscar y eliminar el plato con el ID especificado
            Plato platoEliminado = null;
            for (Plato plato : listaPlatos) {
                if (plato.getId() == id) {
                    platoEliminado = plato;
                    break;
                }
            }

            // Si el plato fue encontrado y eliminado
            if (platoEliminado != null) {
                listaPlatos.remove(platoEliminado);
                resultadoArea.setText("Plato eliminado con ID: " + id);
            } else {
                resultadoArea.setText("No se encontró un plato con el ID especificado.");
            }
        } catch (NumberFormatException ex) {
            resultadoArea.setText("El ID del plato debe ser un número entero.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainMenu mainMenu = new MainMenu(new Usuario("admin", "admin", new Rol(1, "Administrador")));
                FormularioGestionPlatos form = new FormularioGestionPlatos(mainMenu);
                form.setVisible(true);
            }
        });
    }
}
