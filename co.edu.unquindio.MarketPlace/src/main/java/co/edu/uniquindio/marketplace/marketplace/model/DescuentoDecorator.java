package co.edu.uniquindio.marketplace.marketplace.model;

import co.edu.uniquindio.marketplace.marketplace.service.IProducto;

/**
 * Creación de la clase DescuentoDecorator que hereda de la clase abstracta
 * ProductoDecorato hace parte de la implementación del patrón de diseño
 * estructural Decorator
 */
 public class DescuentoDecorator extends ProductoDecorator {

    private double porcentajeDescuento;

    public DescuentoDecorator(IProducto producto, double porcentajeDescuento) {
        super(producto);
        this.porcentajeDescuento = porcentajeDescuento;
    }

    /**
     * Metodología de la aplicación de descuento al producto
     *
     * @return descuento aplicado
     */
    @Override
    public double getPrecio() {
        double precioOriginal = IProducto.getPrecio();
        return precioOriginal - (precioOriginal * (porcentajeDescuento / 100));
    }

    /**
     * Aplicación método para obtener el nombre del producto al que se va a
     * aplicar el descuento
     * @return nombre del producto y descuento aplicado al mismo
     */
    @Override
    public String getNombre() {
        return IProducto.getNombre() + "(Descuento del" + porcentajeDescuento + " %)";

    }
}
