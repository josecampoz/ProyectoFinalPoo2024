//integrantes
package com.mycompany.restaurantepp;

import java.util.HashMap;
import java.util.Map;

public class Inventario {
    private Map<Plato, Integer> stock;

    public Inventario() {
        stock = new HashMap<>();
    }

    public void agregarPlato(Plato plato, int cantidad) {
        stock.put(plato, stock.getOrDefault(plato, 0) + cantidad);
    }

    public int obtenerCantidad(Plato plato) {
        return stock.getOrDefault(plato, 0);
    }

    public void reducirPlato(Plato plato, int cantidad) {
        if (stock.containsKey(plato)) {
            int nuevaCantidad = stock.get(plato) - cantidad;
            if (nuevaCantidad <= 0) {
                stock.remove(plato);
            } else {
                stock.put(plato, nuevaCantidad);
            }
        }
    }

    public void removerPlato(Plato plato, int cantidad) {
        if (stock.containsKey(plato)) {
            int stockActual = stock.get(plato);
            if (stockActual - cantidad <= 0) {
                stock.remove(plato);
            } else {
                stock.put(plato, stockActual - cantidad);
            }
        }
    }

    public int obtenerStock(Plato plato) {
        return stock.getOrDefault(plato, 0);
    }

    public void setStock(Plato plato, int cantidad) {
        stock.put(plato, cantidad);
    }

    public Map<Plato, Integer> getStock() {
        return stock;
    }
}
