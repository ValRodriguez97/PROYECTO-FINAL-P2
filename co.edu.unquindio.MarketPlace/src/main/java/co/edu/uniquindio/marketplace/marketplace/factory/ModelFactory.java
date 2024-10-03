package co.edu.uniquindio.marketplace.marketplace.factory;

import co.edu.uniquindio.marketplace.marketplace.mapping.dto.VendedorDto;
import co.edu.uniquindio.marketplace.marketplace.mapping.mappers.MarketPlaceMappingImplt;
import co.edu.uniquindio.marketplace.marketplace.model.MarketPlace;
import co.edu.uniquindio.marketplace.marketplace.model.Vendedor;
import co.edu.uniquindio.marketplace.marketplace.service.IModelFactory;

import java.util.List;

public class ModelFactory implements IModelFactory {
    private static ModelFactory instance;
    MarketPlace marketPlace;
    MarketPlaceMappingImplt mapper;

    public static ModelFactory getInstance() {
        if (instance == null){
            instance = new ModelFactory();
        }
        return instance;
    }

    private ModelFactory(){
        mapper = new MarketPlaceMappingImplt();
        marketPlace = inicializarDatos();
    }

    public MarketPlace getMarketPlace() {
        return marketPlace;
    }

    public void setMarketPlace(MarketPlace marketPlace) {
        this.marketPlace = marketPlace;
    }

    @Override
    public List<VendedorDto> getVendedores(){
        return mapper.getVendedoresDto(marketPlace.getListVendedores());
    }

    @Override
    public boolean addVendedor(VendedorDto vendedorDto){
        if(marketPlace.verificarVendedorExistente(vendedorDto.cedula())){
            Vendedor vendedor = mapper.vendedorDtoToVendedor(vendedorDto);
            getMarketPlace().createVendedor(
                    vendedor.getNombre(),
                    vendedor.getApellido(),
                    vendedor.getCedula(),
                    vendedor.getDireccion(),
                    vendedor.getUsuario(),
                    vendedor.getContraseña());
            return true;
        }
        return false;
    }

    @Override
    public boolean updateVendedor(VendedorDto vendedorDto){
        if(marketPlace.verificarVendedorExistente(vendedorDto.cedula())){
            Vendedor vendedor1 = mapper.vendedorDtoToVendedor(vendedorDto);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteVendedor(String cedula){
        return false;
    }

    public static MarketPlace inicializarDatos(){
        MarketPlace marketPlace = new MarketPlace();
        Vendedor vendedorA = Vendedor.builder()
                .nombre("Sofia")
                .apellido("Suarez")
                .cedula("12345")
                .direccion("Calle 23")
                .usuario("Sofi")
                .contraseña("sofia123")
                .build();
        return marketPlace;
    }
}
