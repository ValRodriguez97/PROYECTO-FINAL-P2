package co.edu.uniquindio.marketplace.marketplace.model.strategy.producto;

import co.edu.uniquindio.marketplace.marketplace.model.Producto;
import co.edu.uniquindio.marketplace.marketplace.service.IStrategyProducto;

import java.util.Comparator;
import java.util.List;

public class OrdenarPorNombreStrategy implements IStrategyProducto {

    @Override
    public void ordenar(List<Producto> productos){
        productos.sort(Comparator.comparing(Producto::getNombre));
    }
}
