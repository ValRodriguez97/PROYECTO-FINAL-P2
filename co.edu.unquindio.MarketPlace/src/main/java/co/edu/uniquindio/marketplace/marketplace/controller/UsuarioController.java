package co.edu.uniquindio.marketplace.marketplace.controller;

import co.edu.uniquindio.marketplace.marketplace.factory.ModelFactory;
import co.edu.uniquindio.marketplace.marketplace.model.MarketplaceFacade;
import co.edu.uniquindio.marketplace.marketplace.model.Producto;
import co.edu.uniquindio.marketplace.marketplace.model.Vendedor;

import java.util.List;

public class UsuarioController {
    private MarketplaceFacade marketplaceFacade;

    public UsuarioController() {
        this.marketplaceFacade = ModelFactory.getInstance().getMarketplaceFacade();
    }

    public void registrarVendedor(Vendedor vendedor) {
        marketplaceFacade.agregarVendedor(vendedor);
    }

    public Vendedor buscarVendedor(String cedula) {
        return marketplaceFacade.buscarVendedorPorCedula(cedula);
    }

    public void agregarProductoAVendedor(Vendedor vendedor, Producto producto) {
        marketplaceFacade.agregarProducto(vendedor, producto);
    }

    public List<Producto> obtenerProductosDeVendedor(Vendedor vendedor) {
        return marketplaceFacade.obtenerProductosDeVendedor(vendedor);
    }
}