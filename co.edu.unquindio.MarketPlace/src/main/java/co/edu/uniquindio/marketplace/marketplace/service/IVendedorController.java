package co.edu.uniquindio.marketplace.marketplace.service;

import co.edu.uniquindio.marketplace.marketplace.mapping.dto.ProductoDto;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.VendedorDto;

import java.util.List;

public interface IVendedorController {

    List<VendedorDto> getVendedoresDto();

    boolean addVendedor(VendedorDto vendedorDto);

    boolean updateVendedor(VendedorDto vendedorDto);

    boolean deleteVendedor(String cedula);
}
