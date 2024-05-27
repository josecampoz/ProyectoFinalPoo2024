
package com.mycompany.restaurantepp;

public class ItemPedido {
    private Plato plato;
    private int cantidad;

    public ItemPedido(Plato plato, int cantidad) {
        this.plato = plato;
        this.cantidad = cantidad;
    }

    public Plato getPlato() {
        return plato;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return plato.getPrecio() * cantidad;
    }
}
