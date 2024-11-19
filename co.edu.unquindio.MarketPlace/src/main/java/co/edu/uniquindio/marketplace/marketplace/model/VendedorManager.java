package co.edu.uniquindio.marketplace.marketplace.model;

import java.util.ArrayList;
import java.util.List;

public class VendedorManager {
    private List<Vendedor> vendedores;

    public VendedorManager() {
        this.vendedores = new ArrayList<>();
    }

    public void agregarVendedor(Vendedor vendedor) {
        vendedores.add(vendedor);
    }

    public Vendedor buscarVendedorPorCedula(String cedula) {
        for (Vendedor vendedor : vendedores) {
            if (vendedor.getCedula().equals(cedula)) {
                return vendedor;
            }
        }
        return null;
    }
}