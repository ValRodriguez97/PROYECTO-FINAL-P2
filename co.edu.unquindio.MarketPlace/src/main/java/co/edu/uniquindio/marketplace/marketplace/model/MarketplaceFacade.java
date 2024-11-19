package co.edu.uniquindio.marketplace.marketplace.model;

import co.edu.uniquindio.marketplace.marketplace.model.Producto;
import co.edu.uniquindio.marketplace.marketplace.model.ProductoManager;
import co.edu.uniquindio.marketplace.marketplace.model.Vendedor;
import co.edu.uniquindio.marketplace.marketplace.model.VendedorManager;

import java.util.List;

public class MarketplaceFacade {
    private ProductoManager productoManager;
    private VendedorManager vendedorManager;

    public MarketplaceFacade() {
        this.productoManager = new ProductoManager();
        this.vendedorManager = new VendedorManager();
    }

    /**
     * Método para que el Vendedor Manager cumpla su tarea
     * @param vendedor
     */
    public void agregarVendedor(Vendedor vendedor) {
        vendedorManager.agregarVendedor(vendedor);
    }

    public Vendedor buscarVendedorPorCedula(String cedula) {
        return vendedorManager.buscarVendedorPorCedula(cedula);
    }

    /**
     * Método para agregar un producto
     * @param vendedor
     * @param producto
     */
    public void agregarProducto(Vendedor vendedor, Producto producto) {
        productoManager.agregarProducto(vendedor, producto);
    }

    /**
     * Método para buscar un producto por su nombre
     * @param vendedor
     * @param nombre
     * @return
     */

    public Producto buscarProductoPorNombre(Vendedor vendedor, String nombre) {
        return productoManager.buscarProductoPorNombre(vendedor, nombre);
    }

    /**
     * Método para obtener una lista de productos de vendedores
     * @param vendedor
     * @return
     */

    public List<Producto> obtenerProductosDeVendedor(Vendedor vendedor) {
        return vendedor.getListProductos();
    }
}