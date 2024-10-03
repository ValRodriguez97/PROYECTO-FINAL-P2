package co.edu.uniquindio.marketplace.marketplace.mapping.mappers;

import co.edu.uniquindio.marketplace.marketplace.mapping.dto.VendedorDto;
import co.edu.uniquindio.marketplace.marketplace.model.Vendedor;
import co.edu.uniquindio.marketplace.marketplace.service.IMarketPlaceMapping;

import java.util.ArrayList;
import java.util.List;

public class MarketPlaceMappingImplt implements IMarketPlaceMapping {

    @Override
   public  List<VendedorDto> getVendedoresDto(List<Vendedor> listVendedores){
        if (listVendedores == null) {
            return null;
        }

        List<VendedorDto> listVendedoresDto = new ArrayList<VendedorDto>();
        for (Vendedor vendedor : listVendedores) {
            listVendedoresDto.add(vendedorToVendedorDto(vendedor));
        }
        return listVendedoresDto;
    }

    @Override
    public VendedorDto vendedorToVendedorDto(Vendedor vendedor) {
        return new VendedorDto(
                vendedor.getNombre(),
                vendedor.getApellido(),
                vendedor.getCedula(),
                vendedor.getDireccion(),
                vendedor.getUsuario(),
                vendedor.getContraseña());
    }

    @Override
    public Vendedor vendedorDtoToVendedor(VendedorDto vendedorDto){
        return Vendedor.builder().nombre(vendedorDto.nombre()).apellido(vendedorDto.apellido()).cedula(vendedorDto.cedula()).
                cedula(vendedorDto.cedula()).direccion(vendedorDto.direccion()).usuario(vendedorDto.usuario()).contraseña(vendedorDto.contraseña()).build();
    }
}
