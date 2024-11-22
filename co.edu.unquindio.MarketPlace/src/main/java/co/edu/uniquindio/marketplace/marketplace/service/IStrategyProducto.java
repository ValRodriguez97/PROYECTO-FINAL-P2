package co.edu.uniquindio.marketplace.marketplace.service;

import co.edu.uniquindio.marketplace.marketplace.model.Producto;
import co.edu.uniquindio.marketplace.marketplace.model.Publicacion;

import java.util.List;

//STRATEGY
public interface IStrategyProducto {
    void  ordenar (List<Producto> productos);
}
