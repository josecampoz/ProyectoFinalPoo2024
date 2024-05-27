package com.mycompany.restaurantepp;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoForm extends JFrame {
    private JComboBox<Mesa> mesaComboBox;
    private JComboBox<Plato> platoComboBox;
    private JTextField cantidadField;
    private JTextArea platoDetailsTextArea;
    private JButton agregarButton;
    private JButton eliminarButton;
    private JButton modificarButton;
    private JButton finalizarButton;
    private JButton listarPedidosButton;
    private JList<String> pedidoList;
    private DefaultListModel<String> pedidoListModel;
    private JLabel totalLabel;

    private PedidoController pedidoController;
    private List<Mesa> mesas;
    private List<Plato> platos;
    private Pedido pedidoActual;
    private MainMenu2 mainMenu2;

    public PedidoForm(MainMenu2 mainMenu2) {
        this.mainMenu2 = mainMenu2;

        setTitle("Gestión de Pedidos");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        pedidoController = new PedidoController();
        mesas = cargarMesas();
        platos = cargarPlatos();

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2, 5, 5));
        mesaComboBox = new JComboBox<>(mesas.toArray(new Mesa[0]));
        platoComboBox = new JComboBox<>(platos.toArray(new Plato[0]));
        cantidadField = new JTextField();
        platoDetailsTextArea = new JTextArea(3, 20); // TextArea para mostrar todos los platos agregados
        platoDetailsTextArea.setEditable(false);
        platoDetailsTextArea.setLineWrap(true);
        platoDetailsTextArea.setWrapStyleWord(true);

        cantidadField.getDocument().addDocumentListener(new DocumentListener() {
            private void adjustFieldSize() {
                cantidadField.setColumns(Math.max(1, cantidadField.getText().length()));
                PedidoForm.this.pack();
            }

            public void insertUpdate(DocumentEvent e) {
                adjustFieldSize();
            }

            public void removeUpdate(DocumentEvent e) {
                adjustFieldSize();
            }

            public void changedUpdate(DocumentEvent e) {
                adjustFieldSize();
            }
        });

        inputPanel.add(new JLabel("Mesa:"));
        inputPanel.add(mesaComboBox);
        inputPanel.add(new JLabel("Plato:"));
        inputPanel.add(platoComboBox);
        inputPanel.add(new JLabel("Cantidad:"));
        inputPanel.add(cantidadField);
        inputPanel.add(new JLabel("Detalles del Pedido:"));
        inputPanel.add(new JScrollPane(platoDetailsTextArea));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 5, 5, 5));
        agregarButton = new JButton("Agregar Plato");
        eliminarButton = new JButton("Eliminar Plato");
        modificarButton = new JButton("Modificar Pedido");
        finalizarButton = new JButton("Finalizar Pedido");
        listarPedidosButton = new JButton("Listar Pedidos");

        buttonPanel.add(agregarButton);
        buttonPanel.add(eliminarButton);
        buttonPanel.add(modificarButton);
        buttonPanel.add(finalizarButton);
        buttonPanel.add(listarPedidosButton);

        pedidoListModel = new DefaultListModel<>();
        pedidoList = new JList<>(pedidoListModel);
        JScrollPane scrollPane = new JScrollPane(pedidoList);
        totalLabel = new JLabel("Total: $0.00");

        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);
        panel.add(scrollPane, BorderLayout.SOUTH);
        panel.add(totalLabel, BorderLayout.PAGE_END);

        add(panel);

        agregarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarPlato();
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarPlato();
            }
        });

        modificarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modificarPlato();
            }
        });

        finalizarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                finalizarPedido();
            }
        });

        listarPedidosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listarPedidos();
            }
        });

        actualizarPedido();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mainMenu2.setVisible(true);
            }
        });
    }

    private List<Mesa> cargarMesas() {
        List<Mesa> mesas = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            mesas.add(new Mesa(i, 4));
        }
        return mesas;
    }

    private List<Plato> cargarPlatos() {
        List<Plato> platos = new ArrayList<>();
        platos.add(new Plato(1, "Plato 1", 10000, new Categoria(1, "Categoría 1")));
        platos.add(new Plato(2, "Plato 2", 15000, new Categoria(2, "Categoría 2")));
        platos.add(new Plato(3, "Plato 3", 20000, new Categoria(3, "Categoría 3")));
        return platos;
    }

    private void agregarPlato() {
        Mesa mesaSeleccionada = (Mesa) mesaComboBox.getSelectedItem();
        Plato platoSeleccionado = (Plato) platoComboBox.getSelectedItem();
        int cantidad = Integer.parseInt(cantidadField.getText());

        if (pedidoActual == null || !pedidoActual.getMesa().equals(mesaSeleccionada)) {
            pedidoActual = new Pedido(mesaSeleccionada);
        }

        ItemPedido item = new ItemPedido(platoSeleccionado, cantidad);
        pedidoActual.agregarItem(item);

        actualizarPedido();
    }

    private void eliminarPlato() {
        Mesa mesaSeleccionada = (Mesa) mesaComboBox.getSelectedItem();
        Plato platoSeleccionado = (Plato) platoComboBox.getSelectedItem();

        if (pedidoActual != null && pedidoActual.getMesa().equals(mesaSeleccionada)) {
            pedidoActual.eliminarItem(platoSeleccionado);
            actualizarPedido();
        }
    }

    private void modificarPlato() {
        Mesa mesaSeleccionada = (Mesa) mesaComboBox.getSelectedItem();
        Plato platoSeleccionado = (Plato) platoComboBox.getSelectedItem();
        int nuevaCantidad = Integer.parseInt(cantidadField.getText());

        if (pedidoActual != null && pedidoActual.getMesa().equals(mesaSeleccionada)) {
            pedidoActual.modificarItem(platoSeleccionado, nuevaCantidad);
            actualizarPedido();
        }
    }

    private void finalizarPedido() {
        if (pedidoActual != null) {
            pedidoController.agregarPedido(pedidoActual);

            StringBuilder mensaje = new StringBuilder();
            mensaje.append("Mesa atendida: ").append(pedidoActual.getMesa().getNumero()).append("\n");
            mensaje.append("Detalles del pedido:\n");

            double total = 0.0;
            for (ItemPedido item : pedidoActual.getItems()) {
                mensaje.append("- ").append(item.getPlato().getNombre())
                       .append(" x ").append(item.getCantidad())
                       .append(" = $").append(item.getTotal()).append("\n");
                total += item.getTotal();
            }

            double servicio = total * 0.10;
            double iva = total * 0.19;
            double totalConServicioIva = total + servicio + iva;

            mensaje.append("Total sin IVA y servicio: $").append(String.format("%.2f", total)).append("\n");
            mensaje.append("IVA (19%): $").append(String.format("%.2f", iva)).append("\n");
            mensaje.append("Servicio (10%): $").append(String.format("%.2f", servicio)).append("\n");
            mensaje.append("Total final: $").append(String.format("%.2f", totalConServicioIva)).append("\n");

            JOptionPane.showMessageDialog(this, mensaje.toString(), "Resumen del Pedido", JOptionPane.INFORMATION_MESSAGE);

            pedidoActual = null;
            actualizarPedido();
            //mainMenu2.setVisible(true);
            //dispose();
        }
    }

    private void listarPedidos() {
        List<Pedido> pedidos = pedidoController.getPedidos();
        StringBuilder informe = new StringBuilder();
        informe.append("<html><body>");
        informe.append("<h2>Informe de Pedidos</h2>");
        informe.append("<table border='1'><tr><th>Mesa</th><th>Plato</th><th>Cantidad</th><th>Total</th></tr>");

        for (Pedido pedido : pedidos) {
            for (ItemPedido item : pedido.getItems()) {
                informe.append("<tr>")
                        .append("<td>").append(pedido.getMesa().getNumero()).append("</td>")
                        .append("<td>").append(item.getPlato().getNombre()).append("</td>")
                        .append("<td>").append(item.getCantidad()).append("</td>")
                        .append("<td>").append(item.getTotal()).append("</td>")
                        .append("</tr>");
            }
        }

        informe.append("</table></body></html>");

        JOptionPane.showMessageDialog(this, informe.toString(), "Informe de Pedidos", JOptionPane.INFORMATION_MESSAGE);
    }

    private void actualizarPedido() {
        pedidoListModel.clear();
        platoDetailsTextArea.setText(""); // Limpiar el JTextArea
        double total = 0.0;
        if (pedidoActual != null) {
            for (ItemPedido item : pedidoActual.getItems()) {
                String itemText = item.getPlato().getNombre() + " x " + item.getCantidad() + " = $" + item.getTotal();
                pedidoListModel.addElement(itemText);
                platoDetailsTextArea.append(itemText + "\n"); // Agregar los detalles del plato al JTextArea
                total += item.getTotal();
            }
            double servicio = total * 0.10;
            double iva = total * 0.19;
            double totalConServicioIva = total + servicio + iva;
            totalLabel.setText(String.format("Total: $%.2f (Servicio: $%.2f) (IVA: $%.2f) Total con servicio e IVA: $%.2f", total, servicio, iva, totalConServicioIva));
        } else {
            totalLabel.setText("Total: $0.00");
        }
    }
}
