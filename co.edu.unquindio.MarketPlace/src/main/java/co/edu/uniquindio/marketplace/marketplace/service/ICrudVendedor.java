package co.edu.uniquindio.marketplace.marketplace.service;

import co.edu.uniquindio.marketplace.marketplace.model.Vendedor;

import java.util.List;

public interface ICrudVendedor {
    boolean createVendedor(Vendedor vendedor);
    boolean updateVendedor( Vendedor vendedor);
    boolean deleteVendedor(String idVendedor);
    List<Vendedor> listVendedores();

    boolean verificarVendedorExistente (String idVendedor);
}
