package co.edu.uniquindio.marketplace.marketplace.controller;

import co.edu.uniquindio.marketplace.marketplace.factory.ModelFactory;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.ProductoDto;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.UsuarioDto;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.VendedorDto;
import co.edu.uniquindio.marketplace.marketplace.service.IUsuarioService;

import java.util.List;

/**
 * Creación de la clase UsuarioController
 */
public class UsuarioController implements IUsuarioService {
    private ModelFactory modelFactory;

    public UsuarioController() {
        modelFactory = ModelFactory.getInstance();
    }

    @Override
    public UsuarioDto getUsuarioDto(UsuarioDto usuarioDto) {
        return modelFactory.getUsuario(usuarioDto);
    }

    @Override
    public List<ProductoDto> getListProductosDisponibles(UsuarioDto usuarioDto) {
       return modelFactory.listaProductosDisponibles(usuarioDto);
    }

    @Override
    public List<VendedorDto> getListaContactos(UsuarioDto usuarioDto) {
        return modelFactory.getListContactosDto(((VendedorDto) usuarioDto).getIdVendedor());
    }

    @Override
    public boolean createUsuario(VendedorDto vendedorDto) {
        return modelFactory.addUsuario(vendedorDto);
    }
}