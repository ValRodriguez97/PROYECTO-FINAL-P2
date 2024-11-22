package co.edu.uniquindio.marketplace.marketplace.model.strategy.producto;

import co.edu.uniquindio.marketplace.marketplace.model.Producto;
import co.edu.uniquindio.marketplace.marketplace.model.Publicacion;
import co.edu.uniquindio.marketplace.marketplace.service.IStrategyProducto;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
//STRATEGY
public class OrdenarPorPrecioStrategy  implements IStrategyProducto {

    @Override
   public void ordenar(List<Producto> productos){
        productos.sort(Comparator.comparing(Producto::getPrecio));
    }
}
