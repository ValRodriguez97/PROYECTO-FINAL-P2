package co.edu.uniquindio.marketplace.marketplace.service;

/**
 * Interface para implementar el patrón de diseño estructural Decorator
 * agregando un descuento al producto
 */
public interface IProducto {
    double getPrecio();
    String getNombre();
}
