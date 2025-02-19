package co.edu.uniquindio.marketplace.marketplace.factory;

import co.edu.uniquindio.marketplace.marketplace.mapping.dto.*;
import co.edu.uniquindio.marketplace.marketplace.mapping.mappers.MarketPlaceMappingImplt;
import co.edu.uniquindio.marketplace.marketplace.model.*;
import co.edu.uniquindio.marketplace.marketplace.service.IModelFactory;
import co.edu.uniquindio.marketplace.marketplace.service.IVendedorController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public  class ModelFactory implements IModelFactory {
    private static ModelFactory instance;
    MarketPlace marketPlace;
    MarketPlaceMappingImplt mapper;
    private IVendedorController vendedorController;
    private UsuarioProxy usuarioProxy;

    public static ModelFactory getInstance() {
        if (instance == null) {
            instance = new ModelFactory();
        }
        return instance;
    }

    private ModelFactory() {
        mapper = new MarketPlaceMappingImplt();
        marketPlace = inicializarDatos();
    }

    public void inicializarProxy(){
        this.usuarioProxy = new UsuarioProxy(marketPlace);
    }

    public MarketPlace getMarketPlace() {
        return marketPlace;
    }

    public void setMarketPlace(MarketPlace marketPlace) {
        this.marketPlace = marketPlace;
    }

    @Override
    public UsuarioDto getUsuario(UsuarioDto usuarioDto) {
        if(admitirUsuario(usuarioDto)){
            return  mapper.usuarioToUsuarioDto(marketPlace.getUsuarioLogin(usuarioDto.getUsername(), usuarioDto.getPassword()));
        }
        return null;
    }

    public UsuarioDto getUserID(String id){
        return mapper.usuarioToUsuarioDto(marketPlace.getUserId(id));
    }

    @Override
    public void darLikePublicacion(UsuarioDto usuarioDto, String idVendedor, PublicacionDto publicacionDto) {
        marketPlace.darLikePublicacion((Vendedor) mapper.usuarioDtoToUsuario(usuarioDto), idVendedor, publicacionDto.getFechaPublicacion());
    }

    @Override
    public List<ProductoDto> listaProductosDisponibles(UsuarioDto usuarioDto) {
        Usuario usuario = marketPlace.getUsuarioLogin(usuarioDto.getUsername(), usuarioDto.getPassword()) ;
        List<ProductoDto> disponible = new ArrayList<>();
        if( usuario != null){
            for(Producto producto :((Vendedor) usuario).getProductosDisponibles()){
                disponible.add(mapper.productoToProductoDto(producto));
            }
        }
        return disponible;
    }

    @Override
    public List<PublicacionDto> getPublicacionesDto(Muro muro) {
        return List.of();
    }

    @Override
    public boolean addPublicacion(PublicacionDto publicacionDto, VendedorDto vendedorDto) {
       Publicacion publicacio1 = mapper.publicacionDtoToPublicacion(publicacionDto);
       Usuario usuario= mapper.usuarioDtoToUsuario(vendedorDto);

        Publicacion publicacion = new Publicacion(publicacio1.getFechaPublicacion(), publicacio1.getDescripcion(), publicacio1.getProducto());
        marketPlace.createPublicacion(publicacion, usuario.getCedula());
        return true;
    }

    @Override
    public boolean updatePublicacion(PublicacionDto publicacionDto, VendedorDto vendedorDto) {
        return false;
    }

    @Override
    public boolean deletePublicacion(PublicacionDto publicacionDto, VendedorDto vendedorDto) {
        return false;
    }

    @Override
    public boolean addUsuario(VendedorDto vendedorDto) {
       return marketPlace.createUsuario((Vendedor) mapper.usuarioDtoToUsuario(vendedorDto));
    }

    @Override
    public boolean updateUsuario(UsuarioDto usuarioDto) {
        return false;
    }

    @Override
    public boolean deleteUsuario(String cedula) {
        return false;
    }

    @Override
    public boolean addChatMessage(MensajeDto mensajeDto, ChatDto chatDto) {
        return marketPlace.addMessage(mapper.mensajeDtoToMensaje(mensajeDto), mapper.chatDtoToChat(chatDto));
    }

    @Override
    public ChatDto getChat(VendedorDto vendedorDto, VendedorDto vendedorDto2) {
        Chat chat = new Chat();
        chat = marketPlace.getChat((Vendedor) mapper.usuarioDtoToUsuario(vendedorDto), (Vendedor) mapper.usuarioDtoToUsuario(vendedorDto2));
        return mapper.chatToChatDto(chat);
    }

    @Override
    public void darLike(ComentarioDto comentarioDto, PublicacionDto publicacionDto) {
        marketPlace.añadirComentario(mapper.comentarioDtoToComentario(comentarioDto), mapper.publicacionDtoToPublicacion(publicacionDto)
        );
    }

    @Override
    public int getLikes(ComentarioDto comentarioDto, PublicacionDto publicacionDto) {
        return marketPlace.getLikesComentarios(mapper.comentarioDtoToComentario(comentarioDto), mapper.publicacionDtoToPublicacion(publicacionDto));
    }

    @Override
    public void aplicarDescuentos() {

    }

    @Override
    public UsuarioDto getUsuarioDto(UsuarioDto usuarioDto) {
       if(admitirUsuario(usuarioDto)){
           return mapper.usuarioToUsuarioDto(marketPlace.getUsuarioLogin(usuarioDto.getUsername(), usuarioDto.getPassword()));
       }
       return null;
    }

    @Override
    public List<ProductoDto> getProductosPorNombre(String nombreProducto) {
        return mapper.productoDtoListToProductoDtoList(marketPlace.getListaProductos(nombreProducto));
    }

    @Override
    public List<VendedorDto> getListContactosDto(String id) {
        return mapper.vendedoresToVendedorDto(marketPlace.getListContactos(id));
    }

    @Override
    public List<Vendedor> getListContactos(String id) {
        return marketPlace.getListContactos(id);
    }

    @Override
    public List<Comentario> getListComentarios(String id, Publicacion publicacion) {
        return marketPlace.getListComentarios(id);
    }

    @Override
    public List<ComentarioDto> getListComentariosDto(String id, PublicacionDto publicacionDto) {
       return mapper.comentariosToComentarioDto(marketPlace.getListComentarios(id));
    }

    @Override
    public List<Vendedor> getListLike(String id, PublicacionDto publicacionDto) {
        return marketPlace.getListLike(id, mapper.productoDtoToProducto(publicacionDto.getProducto()));
    }

    @Override
    public List<VendedorDto> getListLikeDto(String id, PublicacionDto publicacionDto) {
        return mapper.vendedoresToVendedorDto(marketPlace.getListLike(id, mapper.productoDtoToProducto(publicacionDto.getProducto())));
    }

    @Override
    public List<Publicacion> getListPublicaciones(String id) {
        return marketPlace.getListPublicaciones(id);
    }



    @Override
    public List<MensajeDto> getListMensajesDto(String id) {
        return mapper.mensajeToMensajeDtoList(marketPlace.getMensajes(id));
    }

    @Override
    public List<Mensaje> getListMensajes(String id) {
        return marketPlace.getMensajes(id);
    }

    /**
     * Método admitirUsuario
     * @param usuarioDto
     * @return
     */
    @Override
    public boolean admitirUsuario(UsuarioDto usuarioDto) {
        if(marketPlace.verificarContraseñaUsuario(usuarioDto.getUsername(), usuarioDto.getPassword())){
            return true;
        }
        return false;
    }


    //PROXY
    /**
     * Método para autenticar al usuario usando Proxy
     * @param username
     * @param password
     * @return
     */
    public boolean autenticarUsuarioProxy(String username, String password){
        return usuarioProxy.autenticar(username,password);
    }

    @Override
    public boolean agregarComentario(ComentarioDto comentarioDto, PublicacionDto publicacionDto) {
        return marketPlace.añadirComentario(mapper.comentarioDtoToComentario(comentarioDto), mapper.publicacionDtoToPublicacion(publicacionDto));
    }

    // Método para inicializar datos de prueba
    public static MarketPlace  inicializarDatos() {
        MarketPlace marketPlace = new MarketPlace("Mi Marketplace");

        Vendedor vendedor1 = new Vendedor("Sofia","Suarez", "2332", "Calle 36", "Sofi", "sofia123", "124");
        Vendedor vendedor2 = new Vendedor("Carlos", "Gomez", "6729", "Calle 45", "Sofi", "carlos123", "123");

        marketPlace.createUsuario(vendedor1);
        marketPlace.createUsuario(vendedor2);

        Producto producto1 = new Producto("IPHONE ", "/co/edu/uniquindio/marketplace/marketplace/\uD83C\uDF38\uD83D\uDC9E\uD83D\uDC93\uD83D\uDC97.jpeg", "Electronica", 100000, Estado.DISPONIBLE);
        Producto producto2 = new Producto("LAPTOP", "/co/edu/uniquindio/marketplace/marketplace/MacBook Pro 16 (2021, M1) skins - Custom _ Bottom.jpeg","Electronica", 3000, Estado.PUBLICADO);
        Producto producto3 = new Producto("AUDIFONOS", "/co/edu/uniquindio/marketplace/marketplace/cbbbe243-b4b1-4a44-86cb-ac037270325d.jpeg", "ENTRETENIMIENTO", 300, Estado.VENDIDO);

        Publicacion publicacion1 = new Publicacion(LocalDateTime.now(), "Elegante telefono celular", producto1);
        Publicacion publicacion2 = new Publicacion(LocalDateTime.now(), "Computador", producto2);
        Publicacion publicacion3 = new Publicacion(LocalDateTime.now(), "Audifonos", producto3);

        marketPlace.createPublicacion(publicacion1, vendedor1.getIdVendedor());
        marketPlace.createPublicacion(publicacion2, vendedor2.getIdVendedor());
        marketPlace.createPublicacion(publicacion3, vendedor2.getIdVendedor());

        Administrador administrador = new Administrador("Ad", "Admi", "12345678", "Calle 0", "Admi", "admi123", "123");

        Mensaje mensaje1 = new Mensaje(vendedor1, LocalDateTime.now() ,"Hola");
        Mensaje mensaje2 = new Mensaje(vendedor2, LocalDateTime.now() ,"Holaaaa");

        Chat chat = new Chat("A");
        chat.setVendedor1(vendedor1);
        chat.setVendedor2(vendedor2);
        chat.enviarMensaje(mensaje1);
        chat.enviarMensaje(mensaje2);

        Comentario comentario = new Comentario(vendedor1, LocalDateTime.now(), "Lindo", 3);
        marketPlace.añadirComentario(comentario, publicacion1);

        Muro muro = new Muro();

        muro.añadirPublicacion(publicacion1);
        muro.getListChat().add(chat);

        vendedor1.añadirProducto(producto1);
        return marketPlace;
    }

}

