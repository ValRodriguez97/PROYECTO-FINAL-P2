package co.edu.uniquindio.marketplace.marketplace.service;

import co.edu.uniquindio.marketplace.marketplace.mapping.dto.VendedorDto;
import co.edu.uniquindio.marketplace.marketplace.model.Vendedor;

import java.util.List;

public interface IMarketPlaceMapping {
     List<VendedorDto> getVendedoresDto(List<Vendedor> listVendedores);
     VendedorDto vendedorToVendedorDto(Vendedor vendedor);
     Vendedor vendedorDtoToVendedor(VendedorDto vendedorDto);
}
