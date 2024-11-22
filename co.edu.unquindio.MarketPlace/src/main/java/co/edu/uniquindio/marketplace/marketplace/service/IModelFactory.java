package co.edu.uniquindio.marketplace.marketplace.service;

import co.edu.uniquindio.marketplace.marketplace.mapping.dto.*;
import co.edu.uniquindio.marketplace.marketplace.model.*;

import java.util.List;

/**
 * Creación de la interface IModelFactory para establecer los métodos que implementaria el ModelFactory
 */
public interface IModelFactory {
  public UsuarioDto getUsuario(UsuarioDto usuarioDto);
  public boolean admitirUsuario(UsuarioDto usuarioDto);
  public void darLikePublicacion(UsuarioDto usuarioDto, String idVendedor, PublicacionDto publicacionDto);
  public List<ProductoDto> listaProductosDisponibles(UsuarioDto usuarioDto);

  List<PublicacionDto> getPublicacionesDto(Muro muro);
  boolean addPublicacion(PublicacionDto publicacionDto, VendedorDto vendedorDto);
  boolean updatePublicacion(PublicacionDto publicacionDto, VendedorDto vendedorDto);
  boolean deletePublicacion(PublicacionDto publicacionDto, VendedorDto vendedorDto);

  boolean addUsuario(VendedorDto vendedorDto);
  boolean updateUsuario(UsuarioDto usuarioDto);
  boolean deleteUsuario(String cedula);

  boolean addChatMessage(MensajeDto mensajeDto, ChatDto chatDto);

ChatDto getChat(VendedorDto vendedorDto, VendedorDto vendedorDto2);

  void darLike(ComentarioDto comentarioDto, PublicacionDto publicacionDto);
  int getLikes(ComentarioDto comentarioDto, PublicacionDto publicacionDto);
  public void aplicarDescuentos();

    public UsuarioDto getUsuarioDto(UsuarioDto usuarioDto);

    List<ProductoDto> getProductosPorNombre(String nombreProducto);

    List<VendedorDto> getListContactosDto(String id);
    List<Vendedor> getListContactos(String id);

    List<Comentario> getListComentarios(String id, Publicacion publicacion);
    List<ComentarioDto> getListComentariosDto(String id,PublicacionDto publicacionDto);

    List<Vendedor> getListLike(String id, PublicacionDto publicacionDto);
    List<VendedorDto> getListLikeDto(String id, PublicacionDto publicacionDto);

    List<Publicacion> getListPublicaciones(String id);

    List<MensajeDto> getListMensajesDto(String id);
    List<Mensaje> getListMensajes(String id);
    }

