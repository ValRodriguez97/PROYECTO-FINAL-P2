package co.edu.uniquindio.marketplace.marketplace.service;

import co.edu.uniquindio.marketplace.marketplace.mapping.dto.*;
import co.edu.uniquindio.marketplace.marketplace.model.*;

import java.util.List;

public interface IMarketPlaceMapping {

     ChatDto chatToChatDto(Chat chat);
     Chat chatDtoToChat(ChatDto chatDto);

     ComentarioDto comentarioToComentarioDto(Comentario comentario);
     Comentario comentarioDtoToComentario(ComentarioDto comentarioDto);
     List<ComentarioDto> comentariosToComentarioDto(List<Comentario> comentarios);
     List<Comentario> comentarioDtosToComentarios(List<ComentarioDto> comentarioDtos);

     ProductoDto productoToProductoDto(Producto producto);
     Producto productoDtoToProducto(ProductoDto productoDto);
     List<ProductoDto> productoDtoListToProductoDtoList(List<Producto> productoList);
     List<Producto> productoDtoListToProductoList(List<ProductoDto> productoDtoList);

     MensajeDto mensajeToMensajeDto(Mensaje mensaje);
     Mensaje mensajeDtoToMensaje(MensajeDto mensajeDto);
     List<Mensaje> mensajeDtoListToMensajeList(List<MensajeDto> mensajeDtoList);
     List<MensajeDto> mensajeToMensajeDtoList(List<Mensaje> mensajeList);

     PublicacionDto publicacionToPublicacionDto(Publicacion publicacion);
     Publicacion publicacionDtoToPublicacion(PublicacionDto publicacionDto);
     List<PublicacionDto> publicacionListToPublicacionDtoList(List<Publicacion> publicacionList);
     List<Publicacion> publicacionDtoListToPublicacionList(List<PublicacionDto> publicacionDtoList);

     MuroDto muroToMuroDto(Muro muro);
     Muro muroDtoToMuro(MuroDto muroDto);

     UsuarioDto usuarioToUsuarioDto(Usuario usuario);
     Usuario usuarioDtoToUsuario(UsuarioDto usuarioDto);
     List<VendedorDto> vendedoresToVendedorDto(List<Vendedor> vendedores);
     List<Vendedor> VendedorDtoToVendedor(List<VendedorDto> vendedorDtos);


}
