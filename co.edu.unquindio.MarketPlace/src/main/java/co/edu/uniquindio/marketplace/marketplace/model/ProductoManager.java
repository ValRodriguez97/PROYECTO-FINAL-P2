package co.edu.uniquindio.marketplace.marketplace.model;

/**
 * Creación de la clase ProductoManager para la implementación del patrón Facade
 */
public class ProductoManager {

    public void agregarProducto(Vendedor vendedor, Producto producto) {
        vendedor.getListProductos().add(producto);
    }
    public Producto buscarProductoPorNombre(Vendedor vendedor, String nombre) {
        for (Producto producto : vendedor.getListProductos()) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }
}