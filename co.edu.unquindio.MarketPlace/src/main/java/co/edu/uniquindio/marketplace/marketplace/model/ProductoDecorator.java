package co.edu.uniquindio.marketplace.marketplace.model;

import co.edu.uniquindio.marketplace.marketplace.service.IProducto;

/**
 * Creación de la clase ProductoDecorator para la implementación del patrón
 * estructural Decorator
 */

public abstract class ProductoDecorator implements IProducto {

    protected IProducto IProducto;

    public ProductoDecorator(IProducto IProducto) {
        this.IProducto = IProducto;
    }

    @Override
    public double getPrecio(){
        return IProducto.getPrecio();
    }

    @Override
    public String getNombre(){
        return IProducto.getNombre();
    }

}
