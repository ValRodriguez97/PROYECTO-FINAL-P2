package co.edu.uniquindio.marketplace.marketplace.model.strategy.producto;

import co.edu.uniquindio.marketplace.marketplace.model.Producto;
import co.edu.uniquindio.marketplace.marketplace.service.IStrategyProducto;

import java.util.Comparator;
import java.util.List;
//STRATEGY
public class OrdenarPorPrecioStrategy  implements IStrategyProducto {

    @Override
    public void ordenarProducto(List<Producto> productos){
        productos.sort(Comparator.comparingDouble(Producto::getPrecio));
    }
}
