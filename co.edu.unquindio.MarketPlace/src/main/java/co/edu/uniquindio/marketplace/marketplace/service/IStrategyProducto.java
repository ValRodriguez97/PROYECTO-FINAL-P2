package co.edu.uniquindio.marketplace.marketplace.service;

import co.edu.uniquindio.marketplace.marketplace.model.Producto;

import java.util.List;

//STRATEGY
public interface IStrategyProducto {
    void ordenarProducto(List<Producto> productos);
}
