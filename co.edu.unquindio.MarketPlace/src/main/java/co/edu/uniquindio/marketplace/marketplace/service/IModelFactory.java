package co.edu.uniquindio.marketplace.marketplace.service;

import co.edu.uniquindio.marketplace.marketplace.mapping.dto.*;
import co.edu.uniquindio.marketplace.marketplace.model.Mensaje;
import co.edu.uniquindio.marketplace.marketplace.model.Muro;

import java.util.List;

/**
 * Creación de la interface IModelFactory para establecer los métodos que implementaria el ModelFactory
 */
public interface IModelFactory {
  public UsuarioDto getUsuario(UsuarioDto usuarioDto);
  public boolean admitirUsuario(UsuarioDto usuarioDto);
  public void darLike(UsuarioDto usuarioDto, String idVendedor, PublicacionDto publicacionDto);
  public List<ProductoDto> listaProductosDisponibles(UsuarioDto usuarioDto);

  List<PublicacionDto> getPublicacionesDto(Muro muro);
  boolean addPublicacion(PublicacionDto publicacionDto, VendedorDto vendedorDto);

    boolean updatePublicacion(PublicacionDto publicacionDto, VendedorDto vendedorDto);
  boolean deletePublicacion(PublicacionDto publicacionDto, VendedorDto vendedorDto);

  boolean addUsuario(VendedorDto vendedorDto);
  boolean updateUsuario(UsuarioDto usuarioDto);
  boolean deleteUsuario(String cedula);

  boolean addChatMessage(MensajeDto mensajeDto, ChatDto chatDto);

  boolean addComentario(ComentarioDto comentarioDto);
  boolean updateComentario(ComentarioDto comentarioDto);
  boolean deleteComentario(ComentarioDto comentarioDto);

  boolean addMensaje(MensajeDto mensajeDto);
  boolean updateMensaje(MensajeDto mensajeDto);
  boolean deleteMensaje(MensajeDto mensajeDto);

  public void aplicarDescuentos();

   List<VendedorDto> getVendedoresDto();
    boolean addVendedor(VendedorDto vendedorDto);
    boolean updateVendedor(VendedorDto vendedorDto);
    boolean deleteVendedor(String idVendedor);

    public UsuarioDto getUsuarioDto(UsuarioDto usuarioDto);
    List<UsuarioDto> getUsuariosDto();


    List<AdministradorDto> getAdministradoresDto();
    boolean addAdministrador(AdministradorDto administradorDto);
    boolean updateAdministrador(AdministradorDto administradorDto);
    boolean deleteAdministrador(String cedula);


    List<ProductoDto> getProductosPorNombre(String nombreProducto);
}
