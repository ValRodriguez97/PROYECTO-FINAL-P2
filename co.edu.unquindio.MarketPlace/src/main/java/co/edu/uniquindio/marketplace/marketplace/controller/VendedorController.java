package co.edu.uniquindio.marketplace.marketplace.controller;

import co.edu.uniquindio.marketplace.marketplace.factory.ModelFactory;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.VendedorDto;
import co.edu.uniquindio.marketplace.marketplace.service.IVendedorController;

import java.util.List;

public class VendedorController implements IVendedorController {
    ModelFactory modelFactory;

    public VendedorController() {
        modelFactory = ModelFactory.getInstance();
    }

    @Override
    public List<VendedorDto> getVendedoresDto(){
        return List.of();
    }

    @Override
    public boolean addVendedor(VendedorDto vendedorDto){
        return modelFactory.addVendedor(vendedorDto);
    }

    @Override
    public boolean updateVendedor(VendedorDto vendedorDto){
        return false;
    }

    @Override
    public boolean deleteVendedor(String cedula){
        return false;
    }


}
