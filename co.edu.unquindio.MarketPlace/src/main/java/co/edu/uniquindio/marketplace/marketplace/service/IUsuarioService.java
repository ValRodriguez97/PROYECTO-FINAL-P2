package co.edu.uniquindio.marketplace.marketplace.service;

import co.edu.uniquindio.marketplace.marketplace.mapping.dto.ProductoDto;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.UsuarioDto;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.VendedorDto;

import java.util.List;

public interface IUsuarioService {
    public UsuarioDto getUsuarioDto(UsuarioDto usuarioDto);
    public List<ProductoDto> getListProductosDisponibles(UsuarioDto usuarioDto);
    public List<VendedorDto> getListaContactos(UsuarioDto usuarioDto);
    public boolean createUsuario(VendedorDto vendedorDto);
}
