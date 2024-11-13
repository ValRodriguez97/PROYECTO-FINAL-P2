package co.edu.uniquindio.marketplace.marketplace.mapping.mappers;

import co.edu.uniquindio.marketplace.marketplace.mapping.dto.*;
import co.edu.uniquindio.marketplace.marketplace.model.*;
import co.edu.uniquindio.marketplace.marketplace.service.IMarketPlaceMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MarketPlaceMappingImplt implements IMarketPlaceMapping {

    @Override
    public List<AdministradorDto> getAdministradoresDto(List<Administrador> administradores) {
        if (administradores == null) {
            return null;
        }
        List<AdministradorDto> administradoresDto = new ArrayList<>(administradores.size());
        for (Administrador administrador : administradores) {
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
        return Administrador.Adminbuilder()
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
                comentario.getUsuario(),
                comentario.getFechaComentario(),
                comentario.getComentario()
        );
    }

    @Override
    public Comentario comentarioDtoToComentario(ComentarioDto comentarioDto){
        if (comentarioDto == null){
            return null;
        }
        return new Comentario(
                comentarioDto.usuario(),
                comentarioDto.fechaComentario(),
                comentarioDto.comentario());
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
                mensaje.getUsuario(),
                mensaje.getFechaMensaje(),
                mensaje.getMensaje()
        );
    }

    @Override
    public Mensaje mensajeDtoToMensaje(MensajeDto mensajeDto) {
        if (mensajeDto == null) {
            return null;
        }
        return new Mensaje(
                mensajeDto.usuario(),
                mensajeDto.fechaMensaje(),
                mensajeDto.mensaje()
        );
    }


    @Override
    public PublicacionDto publicacionToPublicacionDto(Publicacion publicacion) {
        if (publicacion == null) {
            return null;
        }
        return new PublicacionDto(
                publicacion.getFechaPublicacion(),
                publicacion.getDescripcion(),
               publicacion.getProducto()
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
                publicacionDto.producto()
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
                muro.getListChat().stream()
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
        );
    }

    @Override
    public List<UsuarioDto> getUsuariosDto(List<Usuario> listUsuarios){
        if(listUsuarios==null){
            return null;
        }

        List<UsuarioDto> usuarioDtos = new ArrayList<UsuarioDto>(listUsuarios.size());
        for(Usuario usuario : listUsuarios){
            usuarioDtos.add(usuarioToUsuarioDto(usuario));
        }
        return usuarioDtos;
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
        return new Usuario(usuarioDto.nombre(), usuarioDto.apellido(), usuarioDto.cedula(), usuarioDto.direccion(), usuarioDto.usuario(), usuarioDto.contraseña());

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
        return Vendedor.Vendedorbuilder().nombre(vendedorDto.nombre()).apellido(vendedorDto.apellido()).cedula(vendedorDto.cedula()).
                cedula(vendedorDto.cedula()).direccion(vendedorDto.direccion()).usuario(vendedorDto.usuario()).contraseña(vendedorDto.contraseña()).build();
    }
}
