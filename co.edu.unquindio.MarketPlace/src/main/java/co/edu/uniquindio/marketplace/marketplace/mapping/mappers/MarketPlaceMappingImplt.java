package co.edu.uniquindio.marketplace.marketplace.mapping.mappers;

import co.edu.uniquindio.marketplace.marketplace.mapping.dto.*;
import co.edu.uniquindio.marketplace.marketplace.model.*;
import co.edu.uniquindio.marketplace.marketplace.service.IMarketPlaceMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MarketPlaceMappingImplt implements IMarketPlaceMapping {

    @Override
    public List<AdministradorDto> getAdministradoresDto(List<AdministradorDto> administradores){
        if (administradores == null){
            return null;
        }
        List<AdministradorDto> administradoresDto = new ArrayList<>(administradores.size());
        for (Administrador administrador : administradores ){
            administradoresDto.add(administradorToAdministradorDto(administrador));
        }
        return administradoresDto;
    }

    @Override
    public AdministradorDto administradorToAdministradorDto(Administrador administrador){
        return new AdministradorDto(
                administrador.getNombre(),
                administrador.getApellido(),
                administrador.getUsuario());
    }

    @Override
    public Administrador administradorDtoToAdministrador(AdministradorDto administradorDto){
        return Administrador.builder()
                .nombre(administradorDto.nombre())
                .apellido(administradorDto.nombre())
                .usuario(administradorDto.usuario())
                .build();
    }

    @Override
    public ChatDto chatToChatDto(Chat chat){
        if (chat == null){
            return null;
        }
        return new ChatDto(chat.getMensajes());
    }

    @Override
    public Chat chatDtoToChat(ChatDto chatDto){
        if (chatDto == null){
            return null;
        }
        return new Chat(chatDto.mensajes());
    }

    @Override
    public ComentarioDto comentarioToComentarioDto(Comentario comentario){
        if (comentario == null){
            return null;
        }
        return new ComentarioDto(
                comentario.getComentario(),
                comentario.getFechaComentario(),
                productoToProductoDto(comentario.getProducto())
        );
    }

    @Override
    public Comentario comentarioDtoToComentario(ComentarioDto comentarioDto){
        if (comentarioDto == null){
            return null;
        }
        return new Comentario(
                comentarioDto.comentario(),
                comentarioDto.fecha(),
                productoDtoToProducto(comentarioDto.producto()
        );
    }

    @Override
    public ProductoDto productoToProductoDto(Producto producto){
        if (producto == null){
            return null;
        }
        return new ProductoDto(
                producto.getNombre(),
                producto.getImagen(),
                producto.getCategoria(),
                producto.getPrecio(),
                producto.getEstado()
        );
    }

    @Override
    public Producto productoDtoToProducto(ProductoDto productoDto){
        if (productoDto == null){
            return null;
        }
        return new Producto(
                productoDto.nombre(),
                productoDto.imagen(),
                productoDto.categoria(),
                productoDto.precio(),
                productoDto.estado()
        );
    }

    @Override
    public MensajeDto mensajeToMensajeDto(Mensaje mensaje) {
        if (mensaje == null) {
            return null;
        }
        return new MensajeDto(
                mensaje.getMensaje(),
                mensaje.getFechaMensaje()
        );
    }

    @Override
    public Mensaje mensajeDtoToMensaje(MensajeDto mensajeDto) {
        if (mensajeDto == null) {
            return null;
        }
        return new Mensaje(
                mensajeDto.mensaje(),
                mensajeDto.fechaMensaje());
    }


    @Override
    public PublicacionDto publicacionToPublicacionDto(Publicacion publicacion) {
        if (publicacion == null) {
            return null;
        }
        return new PublicacionDto(
                publicacion.getFechaPublicacion(),
                publicacion.getDescripcion(),
                productoToProductoDto(publicacion.getProducto()),
                publicacion.getListComentarios().stream()
                        .map(this::comentarioToComentarioDto)
                        .collect(Collectors.toList()),
                getVendedoresDto(publicacion.getListVendedores())
        );
    }

    @Override
    public Publicacion publicacionDtoToPublicacion(PublicacionDto publicacionDto) {
        if (publicacionDto == null) {
            return null;
        }
        return new Publicacion(
                publicacionDto.fechaPublicacion(),
                publicacionDto.descripcion(),
                productoDtoToProducto(publicacionDto.productoDto()),
                publicacionDto.listComentarios().stream()
                        .map(this::comentarioDtoToComentario)
                        .collect(Collectors.toList()),
                listVendedorDtoToVendedor(publicacionDto.listVendedores())
        );
    }

    public List<Vendedor> listVendedorDtoToVendedor(List<VendedorDto> listVendedoresDto) {
        if (listVendedoresDto == null) {
            return null;
        }
        return listVendedoresDto.stream()
                .map(this::vendedorDtoToVendedor)
                .collect(Collectors.toList());
    }

    @Override
    public MuroDto muroToMuroDto(Muro muro) {
        if (muro == null) {
            return null;
        }
        return new MuroDto(
                muro.getListPublicaciones().stream()
                        .map(this::publicacionToPublicacionDto)
                        .collect(Collectors.toList()),
                muro.getListChats().stream()
                        .map(this::chatToChatDto)
                        .collect(Collectors.toList())
        );
    }

    @Override
    public Muro muroDtoToMuro(MuroDto muroDto) {
        if (muroDto == null) {
            return null;
        }
        return new Muro(
                muroDto.listPublicaciones().stream()
                        .map(this::publicacionDtoToPublicacion)
                        .collect(Collectors.toList()),
                muroDto.listChats().stream()
                        .map(this::chatDtoToChat)
                        .collect(Collectors.toList())
        );
    }

    @Override
    public UsuarioDto usuarioToUsuarioDto(Usuario usuario) {
        if (usuario == null) {
            return null;
        }
        return new UsuarioDto(
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getCedula(),
                usuario.getDireccion(),
                usuario.getUsuario(),
                usuario.getContraseña()
        );
    }

    @Override
    public Usuario usuarioDtoToUsuario(UsuarioDto usuarioDto) {
        if (usuarioDto == null) {
            return null;
        }
        return Usuario.builder()
                .nombre(usuarioDto.nombre())
                .apellido(usuarioDto.apellido())
                .cedula(usuarioDto.cedula())
                .direccion(usuarioDto.direccion())
                .usuario(usuarioDto.usuario())
                .contraseña(usuarioDto.contraseña())
                .build();
    }

    @Override
   public  List<VendedorDto> getVendedoresDto(List<Vendedor> listVendedores){
        if (listVendedores == null) {
            return null;
        }

        List<VendedorDto> listVendedoresDto = new ArrayList<VendedorDto>();
        for (Vendedor vendedor : listVendedores) {
            listVendedoresDto.add(vendedorToVendedorDto(vendedor));
        }
        return listVendedoresDto;
    }

    @Override
    public VendedorDto vendedorToVendedorDto(Vendedor vendedor) {
        return new VendedorDto(
                vendedor.getNombre(),
                vendedor.getApellido(),
                vendedor.getCedula(),
                vendedor.getDireccion(),
                vendedor.getUsuario(),
                vendedor.getContraseña());
    }

    @Override
    public Vendedor vendedorDtoToVendedor(VendedorDto vendedorDto){
        return Vendedor.builder().nombre(vendedorDto.nombre()).apellido(vendedorDto.apellido()).cedula(vendedorDto.cedula()).
                cedula(vendedorDto.cedula()).direccion(vendedorDto.direccion()).usuario(vendedorDto.usuario()).contraseña(vendedorDto.contraseña()).build();
    }
}
