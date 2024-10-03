package co.edu.uniquindio.marketplace.marketplace.factory;

import co.edu.uniquindio.marketplace.marketplace.mapping.dto.VendedorDto;
import co.edu.uniquindio.marketplace.marketplace.mapping.mappers.MarketPlaceMappingImplt;
import co.edu.uniquindio.marketplace.marketplace.model.MarketPlace;
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
        marketPlace = inicializarDatos():
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
    boolean addVendedor(VendedorDto vendedor);
    boolean updateVendedor(VendedorDto vendedor);
    boolean deleteVendedor(String cedula);
}
