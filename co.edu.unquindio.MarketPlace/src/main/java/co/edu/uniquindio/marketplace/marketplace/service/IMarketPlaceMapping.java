package co.edu.uniquindio.marketplace.marketplace.service;

import co.edu.uniquindio.marketplace.marketplace.mapping.dto.*;
import co.edu.uniquindio.marketplace.marketplace.model.*;

import java.util.List;

public interface IMarketPlaceMapping {
     List<AdministradorDto> getAdministradoresDto(List<Administrador> administradores);
     AdministradorDto administradorToAdministradorDto(Administrador administrador);
     Administrador administradorDtoToAdministrador(AdministradorDto administradorDto);

     ChatDto chatToChatDto(Chat chat);
     Chat chatDtoToChat(ChatDto chatDto);

     ComentarioDto comentarioToComentarioDto(Comentario comentario);
     Comentario comentarioDtoToComentario(ComentarioDto comentarioDto);

     ProductoDto productoToProductoDto(Producto producto);
     Producto productoDtoToProducto(ProductoDto productoDto);

     MensajeDto mensajeToMensajeDto(Mensaje mensaje);
     Mensaje mensajeDtoToMensaje(MensajeDto mensajeDto);

     PublicacionDto publicacionToPublicacionDto(Publicacion publicacion);
     Publicacion publicacionDtoToPublicacion(PublicacionDto publicacionDto);

     MuroDto muroToMuroDto(Muro muro);
     Muro muroDtoToMuro(MuroDto muroDto);

     List<UsuarioDto> getUsuariosDto(List<Usuario> usuarios);
     UsuarioDto usuarioToUsuarioDto(Usuario usuario);
     Usuario usuarioDtoToUsuario(UsuarioDto usuarioDto);

     List<VendedorDto> getVendedoresDto(List<Vendedor> listVendedores);
     VendedorDto vendedorToVendedorDto(Vendedor vendedor);
     Vendedor vendedorDtoToVendedor(VendedorDto vendedorDto);
}
