package co.edu.uniquindio.marketplace.marketplace.service;

import co.edu.uniquindio.marketplace.marketplace.mapping.dto.VendedorDto;

import java.util.List;

public interface IModelFactory {
    List<VendedorDto> getVendedores();
    boolean addVendedor(VendedorDto vendedor);
    boolean updateVendedor(VendedorDto vendedor);
    boolean deleteVendedor(String cedula);
}
