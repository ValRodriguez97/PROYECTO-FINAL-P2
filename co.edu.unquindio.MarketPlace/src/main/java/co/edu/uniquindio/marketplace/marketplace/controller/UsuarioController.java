package co.edu.uniquindio.marketplace.marketplace.controller;

import co.edu.uniquindio.marketplace.marketplace.factory.ModelFactory;
import co.edu.uniquindio.marketplace.marketplace.model.MarketplaceFacade;
import co.edu.uniquindio.marketplace.marketplace.model.Producto;
import co.edu.uniquindio.marketplace.marketplace.model.Usuario;
import co.edu.uniquindio.marketplace.marketplace.model.Vendedor;

import java.util.List;

/**
 * Creación de la clase UsuarioController
 */
public class UsuarioController {
    private MarketplaceFacade marketplaceFacade;

    public UsuarioController() {
        this.marketplaceFacade = ModelFactory.getInstance().getMarketPlace().getMarketplaceFacade();
    }

    /**
     * Método creado para la implementación del Facade
     * @param vendedor
     */
    public void registrarVendedor(Vendedor vendedor) {
        Usuario usuario = new Usuario();
        usuario.agregarVendedor(vendedor, marketplaceFacade);
    }

    /**
     * Método creado para la implementación del Facade
     * @param vendedor
     * @param producto
     */
    public void agregarProductoAVendedor(Vendedor vendedor, Producto producto) {
        Usuario usuario = new Usuario();
        usuario.agregarProducto(vendedor, producto, marketplaceFacade);
    }

    /**
     * Método creado para la implementación del Facade
     * @param nombre
     * @param vendedor
     * @return
     */
    public Producto buscarProducto(String nombre, Vendedor vendedor) {
        Usuario usuario = new Usuario();
        return usuario.buscarProductoPorNombre(vendedor, nombre, marketplaceFacade);
    }

    /**
     * Método creado para la implementación del Facade
     * @param cedula
     * @return
     */
    public Vendedor buscarVendedor(String cedula) {
        Usuario usuario = new Usuario();
        return usuario.buscarVendedorPorCedula(cedula, marketplaceFacade);
    }
}