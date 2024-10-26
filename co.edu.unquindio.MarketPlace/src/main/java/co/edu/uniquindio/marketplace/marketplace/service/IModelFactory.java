package co.edu.uniquindio.marketplace.marketplace.service;

import co.edu.uniquindio.marketplace.marketplace.mapping.dto.AdministradorDto;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.PublicacionDto;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.UsuarioDto;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.VendedorDto;
import co.edu.uniquindio.marketplace.marketplace.model.Usuario;

import java.util.List;

public interface IModelFactory {
    List<VendedorDto> getVendedoresDto();
    boolean addVendedor(VendedorDto vendedorDto);
    boolean updateVendedor(VendedorDto vendedorDto);
    boolean deleteVendedor(String idVendedor);

    List<UsuarioDto> getUsuariosDto();
    boolean addUsuario(UsuarioDto usuarioDto);
    boolean updateUsuario(UsuarioDto usuarioDto);
    boolean deleteUsuario(String cedula);

    List<AdministradorDto> getAdministradoresDto();
    boolean addAdministrador(AdministradorDto administradorDto);
    boolean updateAdministrador(AdministradorDto administradorDto);
    boolean deleteAdministrador(String cedula);

    public boolean verificarRegistro(UsuarioDto usuarioDto);
    public boolean verificarRegistro(AdministradorDto administradorDto);
    public boolean verificarRegistro(VendedorDto vendedorDto);

    List<PublicacionDto> getPublicacionesDto();
    boolean addPublicacion(PublicacionDto publicacionDto, VendedorDto vendedorDto);
    boolean updatePublicacion(PublicacionDto publicacionDto, VendedorDto vendedorDto);
    boolean deletePublicacion(PublicacionDto publicacionDto, VendedorDto vendedorDto);

    public boolean admitirUsuario(UsuarioDto usuarioDto);

}
