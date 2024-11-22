package co.edu.uniquindio.marketplace.marketplace.factory;

import co.edu.uniquindio.marketplace.marketplace.mapping.dto.*;
import co.edu.uniquindio.marketplace.marketplace.mapping.mappers.MarketPlaceMappingImplt;
import co.edu.uniquindio.marketplace.marketplace.model.*;
import co.edu.uniquindio.marketplace.marketplace.service.IModelFactory;
import co.edu.uniquindio.marketplace.marketplace.service.IVendedorController;

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

        Vendedor vendedor1 = new Vendedor("123","Sofia", "Suarez", "12345", "Calle 23", "Sofi", "sofia123");
        Vendedor vendedor2 = new Vendedor("242", "Carlos", "Gomez", "67890", "Calle 45", "CarlosG", "carlos123");

        marketPlace.createUsuario(vendedor1);
        marketPlace.createUsuario(vendedor2);
        /**Producto producto1 = Producto.builder()
                .nombre("Laptop")
                .imagen("/co/edu/uniquindio/marketplace/marketplace/one-piece-title-manga-art-0k550byvor5oc6nb.jpg") // Asegúrate de que la ruta sea correcta
                .categoria("Electrónica")
                .precio(1000.00)
                .estado(Estado.PUBLICADO)
                .build();

        Producto producto2 = Producto.builder()
                .nombre("Teléfono")
                .imagen("/co/edu/uniquindio/marketplace/marketplace/one-piece-title-manga-art-0k550byvor5oc6nb.jpg") // Asegúrate de que la ruta sea correcta
                .categoria("Electrónica")
                .precio(500.00)
                .estado(Estado.PUBLICADO)
                .build();
**/
        // Agregar productos a los vendedores
       // vendedor1.setListProductos(new ArrayList<>(List.of(producto1)));
        //vendedor2.setListProductos(new ArrayList<>(List.of(producto2)));
        return marketPlace;
    }

}

