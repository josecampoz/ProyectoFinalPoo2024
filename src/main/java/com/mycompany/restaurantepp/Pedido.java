package com.mycompany.restaurantepp;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Mesa mesa;
    private List<ItemPedido> items;
    private boolean finalizado;

    public Pedido(Mesa mesa) {
        this.mesa = mesa;
        this.items = new ArrayList<>();
        this.finalizado = false;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public List<ItemPedido> getItems() {
        return items;
    }

    public void agregarItem(ItemPedido item) {
        items.add(item);
    }

    public void eliminarItem(Plato plato) {
        items.removeIf(item -> item.getPlato().equals(plato));
    }

    public void modificarItem(Plato plato, int nuevaCantidad) {
        for (ItemPedido item : items) {
            if (item.getPlato().equals(plato)) {
                item.setCantidad(nuevaCantidad);
                break;
            }
        }
    }

    public double calcularTotal() {
        double total = 0.0;
        for (ItemPedido item : items) {
            total += item.getTotal();
        }
        return total;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }
}
