package co.edu.uniquindio.marketplace.marketplace.factory;

import co.edu.uniquindio.marketplace.marketplace.MarketPlaceApplication;
import co.edu.uniquindio.marketplace.marketplace.controller.VendedorController;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.*;
import co.edu.uniquindio.marketplace.marketplace.mapping.mappers.MarketPlaceMappingImplt;
import co.edu.uniquindio.marketplace.marketplace.model.*;
import co.edu.uniquindio.marketplace.marketplace.service.IModelFactory;
import co.edu.uniquindio.marketplace.marketplace.service.IVendedorController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public  class ModelFactory implements IModelFactory {
    private static ModelFactory instance;
    MarketPlace marketPlace;
    MarketPlaceMappingImplt mapper;
    private MarketplaceFacade marketplaceFacade;
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

    //MÉTODOS DE PUBLICACIÓN


    @Override
    public void darLikePublicacion(UsuarioDto usuarioDto, String idVendedor, PublicacionDto publicacionDto) {
        marketPlace.
    }

    /**
     * Método de listaProductos
     * @param usuarioDto
     * @return
     */
    @Override
    public List<ProductoDto> listaProductosDisponibles(UsuarioDto usuarioDto) {
        return List.of();
    }

    /**
     * Método listaPublicaciones
     * @param muro
     * @return
     */
    @Override
    public List<PublicacionDto> getPublicacionesDto(Muro muro) {
        return List.of();
    }

    @Override
    public boolean addPublicacion(PublicacionDto publicacionDto, VendedorDto vendedorDto) {
        Publicacion publicacion = mapper.publicacionDtoToPublicacion(publicacionDto);
        Vendedor vendedor = (Vendedor) mapper.usuarioDtoToUsuario( vendedorDto);
        return marketPlace.createPublicacion(publicacion, vendedor.getIdVendedor());
    }


    @Override
    public boolean updatePublicacion(PublicacionDto publicacionDto, VendedorDto vendedorDto) {
        Vendedor vendedor = marketPlace.verificarVendedor(vendedorDto.getIdVendedor());
       // Publicacion publicacion = vendedor.getMuro().getListPublicaciones(publicacionDto.getDescripcion());
        return false;
    }

    @Override
    public boolean deletePublicacion(PublicacionDto publicacionDto, VendedorDto vendedorDto) {
        return false;
    }

    /**
     * Métodos de Usuario agregar
     * @param vendedorDto
     * @return
     */
    @Override
    public boolean addUsuario(VendedorDto vendedorDto) {
        if (marketPlace.verificarUsuarioExistente(vendedorDto.getCedula())) {
            Usuario usuario = mapper.usuarioDtoToUsuario(vendedorDto);
            return marketPlace.createUsuario(usuario);
        }
        return false;
    }
    //METODOS DE USUARIO

    /**
     * Método de usuario, obtenerUsuario
     * @param usuarioDto
     * @return
     */
    @Override
    public UsuarioDto getUsuario(UsuarioDto usuarioDto) {
        if(admitirUsuario(usuarioDto)){
            return mapper.usuarioToUsuarioDto(marketPlace.getUsuarioVerificar(usuarioDto.getUsername(), usuarioDto.getPassword()));
        }
        return null;
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
    /**
     * Método actualizarUsuario
     * @param usuarioDto
     * @return
     */
    @Override
    public boolean updateUsuario(UsuarioDto usuarioDto) {
        if(marketPlace.verificarUsuarioExistente(usuarioDto.getCedula())){
            Usuario usuario = mapper.usuarioDtoToUsuario(usuarioDto);
            return marketPlace.updateUsuario(usuario);
        }
        return false;
    }

    /**
     * Método eliminarUsuario
     * @param cedula
     * @return
     */
    @Override
    public boolean deleteUsuario(String cedula) {
        return false;
    }

    //MÉTODOS DE CHAT

    /**
     * Método agregarchatMensaje
     * @param mensajeDto
     * @param chatDto
     * @return
     */
    @Override
    public boolean addChatMessage(MensajeDto mensajeDto, ChatDto chatDto) {
        return false;
    }

    /**
     * Método de comentario, agregarComentario
     * @param comentarioDto
     * @return
     */
    @Override
    public boolean addComentario(ComentarioDto comentarioDto) {
        return false;
    }

    /**
     * Método de comentario, actualizarComentario
     * @param comentarioDto
     * @return
     */
    @Override
    public boolean updateComentario(ComentarioDto comentarioDto) {
        return false;
    }

    /**
     * Método de comentario, eliminarComentario
     * @param comentarioDto
     * @return
     */
    @Override
    public boolean deleteComentario(ComentarioDto comentarioDto) {
        return false;
    }

    /**
     * Método de Mensaje, agregarMensaje
     * @param mensajeDto
     * @return
     */
    @Override
    public boolean addMensaje(MensajeDto mensajeDto) {
        return false;
    }

    /**
     * Método de Mensaje, actualizarMensaje
     * @param mensajeDto
     * @return
     */
    @Override
    public boolean updateMensaje(MensajeDto mensajeDto) {
        return false;
    }

    /**
     * Método de Mensaje, eliminarMensaje
     * @param mensajeDto
     * @return
     */
    @Override
    public boolean deleteMensaje(MensajeDto mensajeDto) {
        return false;
    }

    @Override
    public void darLike(ComentarioDto comentarioDto, PublicacionDto publicacionDto) {

    }

    @Override
    public void getLikes(ComentarioDto comentarioDto, PublicacionDto publicacionDto) {

    }

    @Override
    public void aplicarDescuentos(){
    }

    public IVendedorController getVendedorController() {
        return this.vendedorController;
    }

   /** public List<VendedorDto> getVendedoresPorNombre(String nombre){
        return marketPlace.getListVendedores().stream().filter((vendedor -> vendedor.getNombre().toLowerCase().contains(nombre.toLowerCase()))).collect(Collectors.toList());

    }**/

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
    public UsuarioDto getUsuarioDto(UsuarioDto usuarioDto) {
        return null;
    }


    @Override
    public List<ProductoDto> getProductosPorNombre(String nombreProducto) {
        return List.of();
    }

    @Override
    public List<VendedorDto> getListContactosDto(String id) {
        return List.of();
    }

    @Override
    public List<VendedorDto> getListContactos(String id) {
        return List.of();
    }

    @Override
    public List<Comentario> getListComentarios(Publicacion publicacion) {
        return List.of();
    }

    @Override
    public List<ComentarioDto> getListComentariosDto(PublicacionDto publicacionDto) {
        return List.of();
    }

    @Override
    public List<Vendedor> getListLike(String id, PublicacionDto publicacionDto) {
        return List.of();
    }

    @Override
    public List<VendedorDto> getListLikeDto(String id, PublicacionDto publicacionDto) {
        return List.of();
    }

    @Override
    public List<Publicacion> getListPublicaciones(String id) {
        return List.of();
    }

    @Override
    public List<ProductoDto> getListPublicacionesDto(String id) {
        return List.of();
    }

    @Override
    public List<MensajeDto> getListMensajesDto(String id) {
        return List.of();
    }

    @Override
    public List<Mensaje> getListMenajes(String id) {
        return List.of();
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

