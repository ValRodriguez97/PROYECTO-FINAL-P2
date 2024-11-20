package co.edu.uniquindio.marketplace.marketplace.mapping.mappers;

import co.edu.uniquindio.marketplace.marketplace.factory.ModelFactory;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.*;
import co.edu.uniquindio.marketplace.marketplace.model.*;
import co.edu.uniquindio.marketplace.marketplace.model.builder.VendedorBuilder;
import co.edu.uniquindio.marketplace.marketplace.service.IMarketPlaceMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MarketPlaceMappingImplt implements IMarketPlaceMapping {
    ModelFactory modelFactory;

    @Override
    public ChatDto chatToChatDto(Chat chat) {
        if(chat == null) return null;
        return new ChatDto();
    }

    @Override
    public Chat chatDtoToChat(ChatDto chatDto) {
        if(chatDto == null) return null;
        return new Chat(chatDto.getMensajes().stream().map(this::mensajeDtoToMensaje).collect(Collectors.toList()));
    }

    @Override
    public ComentarioDto comentarioToComentarioDto(Comentario comentario) {
        if(comentario == null) return null;
        return new ComentarioDto(
                comentario.getUsuario(),
                comentario.getFechaComentario(),
                comentario.getComentario(),
                comentario.getNumLikes()
        );
    }

    @Override
    public Comentario comentarioDtoToComentario(ComentarioDto comentarioDto) {
       if(comentarioDto == null) return null;
       return new Comentario(
               comentarioDto.getUsuario(),
               comentarioDto.getFechaComentario(),
               comentarioDto.getComentario(),
               comentarioDto.getNumLikes()
       );
    }

    @Override
    public List<ComentarioDto> comentariosToComentarioDto(List<Comentario> comentarios) {
        if(comentarios == null) return new ArrayList<>();

        List<ComentarioDto> comentarioDtos = new ArrayList<>();
        for(Comentario comentario : comentarios){
            ComentarioDto comentarioDto = comentarioToComentarioDto(comentario);
            comentarioDtos.add(comentarioDto);
        }
        return comentarioDtos;
    }

    @Override
    public List<Comentario> comentarioDtosToComentarios(List<ComentarioDto> comentarioDtos) {
        if(comentarioDtos == null) return new ArrayList<>();
        List<Comentario> comentarios = new ArrayList<>();
        for(ComentarioDto comentarioDto : comentarioDtos){
            Comentario comentario = comentarioDtoToComentario( comentarioDto);
            comentarios.add(comentario);
        }
        return  comentarios;
    }

    @Override
    public ProductoDto productoToProductoDto(Producto producto) {
        if(producto == null) return null;
        return new ProductoDto(
                producto.getNombre(),
                producto.getNombre(),
                producto.getImagen(),
                producto.getCategoria(),
                producto.getPrecio(),
                producto.getEstado()
        );
    }

    @Override
    public Producto productoDtoToProducto(ProductoDto productoDto) {
       if(productoDto == null) return null;
       return new Producto(
               productoDto.getNombre(),
               productoDto.getImage(),
               productoDto.getCategoria(),
               productoDto.getPrecio(),
               productoDto.getEstado()
       );
    }

    @Override
    public List<ProductoDto> productoDtoListToProductoDtoList(List<Producto> productoList) {
        if(productoList == null) return new ArrayList<>();

        List<ProductoDto> productosDto = new ArrayList<>();
        for(Producto producto : productoList){
            productosDto.add(productoToProductoDto(producto));
        }
        return productosDto;
    }

    @Override
    public List<Producto> productoDtoListToProductoList(List<ProductoDto> productoDtoList) {
        if(productoDtoList == null) return new ArrayList<>();

        List<Producto> productos = new ArrayList<>();
        for(ProductoDto productoDto : productoDtoList){
            productos.add(productoDtoToProducto(productoDto));
        }
        return productos;
    }

    @Override
    public MensajeDto mensajeToMensajeDto(Mensaje mensaje) {
       if(mensaje == null) return null;
       return new MensajeDto(
               mensaje.getMensaje(),
               mensaje.getFechaMensaje(),
               mensaje.getUsuario()
       );
    }

    @Override
    public Mensaje mensajeDtoToMensaje(MensajeDto mensajeDto) {
        if(mensajeDto == null) return null;
        return new Mensaje(
                mensajeDto.getUsuario(),
                mensajeDto.getFechaMensaje(),
                mensajeDto.getMensaje()
        );
    }

    @Override
    public List<Mensaje> mensajeDtoListToMensajeList(List<MensajeDto> mensajeDtoList) {
        if(mensajeDtoList == null) return new ArrayList<>();

        List<Mensaje> mensajes = new ArrayList<>();
        for (MensajeDto mensajeDto : mensajeDtoList){
            mensajes.add(mensajeDtoToMensaje(mensajeDto));
        }
        return mensajes;
    }

    @Override
    public List<MensajeDto> mensajeToMensajeDtoList(List<Mensaje> mensajeList) {
        if(mensajeList == null) return new ArrayList<>();

        List<MensajeDto> mensajeDtos = new ArrayList<>();
        for(Mensaje mensaje : mensajeList){
            mensajeDtos.add(mensajeToMensajeDto(mensaje));
        }
        return mensajeDtos;
    }

    @Override
    public PublicacionDto publicacionToPublicacionDto(Publicacion publicacion) {
        if(publicacion == null) return null;
        return new PublicacionDto(
                publicacion.getFechaPublicacion(),
                publicacion.getDescripcion(),
                publicacion.getProducto()
        );
    }

    @Override
    public Publicacion publicacionDtoToPublicacion(PublicacionDto publicacionDto) {
        if(publicacionDto == null) return null;
        return new Publicacion(
                publicacionDto.getFechaPublicacion(),
                publicacionDto.getDescripcion(),
                publicacionDto.getProducto()
        );
    }

    @Override
    public List<PublicacionDto> publicacionListToPublicacionDtoList(List<Publicacion> publicacionList) {
        if(publicacionList == null) return new ArrayList<>();

        List<PublicacionDto> publicacionDtos = new ArrayList<>();
        for(Publicacion publicacion : publicacionList){
            publicacionDtos.add(publicacionToPublicacionDto(publicacion));
        }
        return publicacionDtos;
    }

    @Override
    public List<Publicacion> publicacionDtoListToPublicacionList(List<PublicacionDto> publicacionDtoList) {
        if(publicacionDtoList == null) return new ArrayList<>();

        List<Publicacion> publicaciones = new ArrayList<>();
        for(PublicacionDto publicacionDto : publicacionDtoList){
            publicaciones.add(publicacionDtoToPublicacion(publicacionDto));
        }
        return publicaciones;
    }

    @Override
    public MuroDto muroToMuroDto(Muro muro) {
        if(muro == null) return null;
        return new MuroDto(
                muro.getIdVendedor(),
                muro.getListPublicaciones(),
                muro.getListChat()
        );
    }

    @Override
    public Muro muroDtoToMuro(MuroDto muroDto) {
        if(muroDto == null) return null;
        return new Muro(
        );
    }

    @Override
    public UsuarioDto usuarioToUsuarioDto(Usuario usuario) {
       if(usuario instanceof  Vendedor){
           Vendedor vendedor = (Vendedor) usuario;
           VendedorDto vendedorDto = new VendedorDto(
                   vendedor.getNombre(),
                   vendedor.getApellido(),
                   vendedor.getCedula(),
                   vendedor.getDireccion(),
                   vendedor.getUsername(),
                   vendedor.getContraseña(),
                   vendedor.getIdVendedor()
           );
           return vendedorDto;
       } else if (usuario instanceof  Administrador) {
           Administrador administrador = (Administrador) usuario;
           AdministradorDto administradorDto = new AdministradorDto(
                   administrador.getNombre(),
                   administrador.getApellido(),
                   administrador.getCedula(),
                   administrador.getDireccion(),
                   administrador.getUsername(),
                   administrador.getContraseña(),
                   administrador.getIdAdministrador()
           );
           return administradorDto;
       }
       return null;
    }

    @Override
    public Usuario usuarioDtoToUsuario(UsuarioDto usuarioDto) {
        if(usuarioDto instanceof  VendedorDto){
            VendedorDto vendedorDto = (VendedorDto) usuarioDto;
            Vendedor vendedor = new Vendedor(
                    vendedorDto.getNombre(),
                    vendedorDto.getApellido(),
                    vendedorDto.getCedula(),
                    vendedorDto.getDireccion(),
                    vendedorDto.getUsername(),
                    vendedorDto.getPassword(),
                    vendedorDto.getIdVendedor()
            );
            return vendedor;

        } else if (usuarioDto instanceof  AdministradorDto) {
            AdministradorDto administradorDto = (AdministradorDto) usuarioDto;
            Administrador administrador = new Administrador(
                    administradorDto.getNombre(),
                    administradorDto.getApellido(),
                    administradorDto.getCedula(),
                    administradorDto.getDireccion(),
                    administradorDto.getUsername(),
                    administradorDto.getPassword(),
                    administradorDto.getIdAdministrador()
            );
            return administrador;
        }
        return null;
    }

    @Override
    public List<VendedorDto> vendedoresToVendedorDto(List<Vendedor> vendedores) {
        if(vendedores == null) return new ArrayList<>();

        List<VendedorDto> vendedorDtos = new ArrayList<VendedorDto>();
        for(Vendedor vendedor : vendedores){
            vendedorDtos.add((VendedorDto) usuarioToUsuarioDto(vendedor));
        }
        return vendedorDtos;
    }

    @Override
    public List<Vendedor> VendedorDtoToVendedor(List<VendedorDto> vendedorDtos) {
        if(vendedorDtos == null) return new ArrayList<>();

        List<Vendedor> vendedores = new ArrayList<Vendedor>();
        for(VendedorDto vendedorDto : vendedorDtos){
            vendedores.add((Vendedor) usuarioDtoToUsuario(vendedorDto));
        }
        return vendedores;
    }
}

