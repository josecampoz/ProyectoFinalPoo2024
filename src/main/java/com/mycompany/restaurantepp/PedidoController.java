package com.mycompany.restaurantepp;

import java.util.ArrayList;
import java.util.List;

public class PedidoController {
    private List<Pedido> pedidos;

    public PedidoController() {
        this.pedidos = new ArrayList<>();
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
        
    // Método para agregar un pedido a la lista de pedidos
    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    // Método para buscar un pedido por el número de mesa
    public Pedido buscarPedidoPorMesa(int numeroMesa) {
        for (Pedido pedido : pedidos) {
            if (pedido.getMesa().getNumero() == numeroMesa) {
                return pedido;
            }
        }
        return null;
    }

    // Método para finalizar un pedido
    public void finalizarPedido(Pedido pedido) {
        pedido.setFinalizado(true);
    }

    // Método para obtener todos los pedidos
    public List<Pedido> obtenerTodosLosPedidos() {
        return new ArrayList<>(pedidos);
    }

    // Método para eliminar un pedido de la lista de pedidos
    public void eliminarPedido(Pedido pedido) {
        pedidos.remove(pedido);
    }
}
