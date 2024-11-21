package co.edu.uniquindio.marketplace.marketplace.factory;

import co.edu.uniquindio.marketplace.marketplace.controller.VendedorController;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.*;
import co.edu.uniquindio.marketplace.marketplace.mapping.mappers.MarketPlaceMappingImplt;
import co.edu.uniquindio.marketplace.marketplace.model.*;
import co.edu.uniquindio.marketplace.marketplace.service.ICrudVendedor;
import co.edu.uniquindio.marketplace.marketplace.service.IModelFactory;
import co.edu.uniquindio.marketplace.marketplace.service.IVendedorController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public  class ModelFactory implements IModelFactory {
    private static ModelFactory instance;
    MarketPlace marketPlace;
    MarketPlaceMappingImplt mapper;
    private List<ProductoDto> productos;
    private List<VendedorDto> vendedores;
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
        this.productos = new ArrayList<>();
        this.vendedores = new ArrayList<>();
        this.marketplaceFacade= new MarketplaceFacade();
        this.vendedorController = new VendedorController();
        usuarioProxy= new UsuarioProxy(marketPlace);
    }

    public MarketPlace getMarketPlace() {
        return marketPlace;
    }

    public void setMarketPlace(MarketPlace marketPlace) {
        this.marketPlace = marketPlace;
    }

    //MÉTODOS DE PUBLICACIÓN

    /**
     * Método darLike
     * @param usuarioDto
     * @param idVendedor
     * @param publicacionDto
     */
    @Override
    public void darLike(UsuarioDto usuarioDto, String idVendedor, PublicacionDto publicacionDto) {

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
        Vendedor vendedor = marketPlace.verificarVendedor(vendedorDto.getIdVendedor());
        Publicacion publicacion = new Publicacion(publicacionDto.getFechaPublicacion(),publicacionDto.getDescripcion(), publicacionDto.getProducto());
        return marketPlace.createPublicacion(publicacion,vendedor);
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
     * @param usuarioDto
     * @return
     */
    @Override
    public boolean addUsuario(UsuarioDto usuarioDto) {
        if (marketPlace.verificarUsuarioExistente(usuarioDto.getCedula())) {
            Usuario usuario = mapper.usuarioDtoToUsuario(usuarioDto);
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
    public void aplicarDescuentos(){
    }

    public IVendedorController getVendedorController() {
        return this.vendedorController;
    }

    public List<VendedorDto> getVendedoresPorNombre(String nombre){
        return vendedores.stream().filter((vendedor -> vendedor.getNombre().toLowerCase().contains(nombre.toLowerCase()))).collect(Collectors.toList());

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
    public List<VendedorDto> getVendedoresDto() {
        return mapper.vendedoresToVendedorDto(marketPlace.getListVendedores());
    }


    /**




    @Override
    public boolean updateVendedor(VendedorDto vendedorDto) {
        if (marketPlace.verificarVendedorExistente(vendedorDto.cedula())) {
            Vendedor vendedorActualizado = mapper.vendedorDtoToVendedor(vendedorDto);

            return marketPlace.updateVendedor(vendedorActualizado.getIdVendedor(), vendedorActualizado);
        }
        return false;
    }

    @Override
    public boolean deleteVendedor(String idVendedor) {
        return marketPlace.deleteVendedor(idVendedor);
    }

    @Override
    public List<UsuarioDto> getUsuariosDto() {
        return mapper.getUsuariosDto(marketPlace.getListUsuarios());
    }

    @Override
    public UsuarioDto getUsuarioDto(UsuarioDto usuarioDto) {
        if (verificarRegistro(usuarioDto)) {
            return mapper.usuarioToUsuarioDto(marketPlace.getUsuarioVerificar(usuarioDto.usuario(), usuarioDto.contraseña()));
        }
        return null;
    }

    @Override
    public boolean addUsuario(UsuarioDto usuarioDto) {
        if (marketPlace.verificarUsuarioExistente(usuarioDto.cedula())) {
            Usuario usuario = mapper.usuarioDtoToUsuario(usuarioDto);
            return marketPlace.createUsuario(usuario);
        }
        return false;
    }

    @Override
    public boolean updateUsuario(UsuarioDto usuarioDto) {
        if (!marketPlace.verificarUsuarioExistente(usuarioDto.cedula())) {
            Usuario usuarioActualizado = mapper.usuarioDtoToUsuario(usuarioDto);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteUsuario(String cedula) {
        return false;
    }

    @Override
    public List<AdministradorDto> getAdministradoresDto() {
        return List.of();
    }

    @Override
    public boolean addAdministrador(AdministradorDto administradorDto) {
        return false;
    }

    @Override
    public boolean updateAdministrador(AdministradorDto administradorDto) {
        return false;
    }

    @Override
    public boolean deleteAdministrador(String cedula) {
        return false;
    }

    @Override
    public boolean verificarRegistro(UsuarioDto usuarioDto) {
        return false;
    }

    @Override
    public boolean verificarRegistro(AdministradorDto administradorDto) {
        return false;
    }

    @Override
    public boolean verificarRegistro(VendedorDto vendedorDto) {
        return false;
    }

    @Override
    public List<PublicacionDto> getPublicacionesDto() {
        return List.of();
    }

    @Override
    public boolean addPublicacion(PublicacionDto publicacionDto, VendedorDto vendedorDto) {
        return false;
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
    public boolean admitirUsuario(UsuarioDto usuarioDto) {
        if (marketPlace.verificarContraseñaUsuario(usuarioDto.usuario(), usuarioDto.contraseña())) {
            return true;
        }
        return false;
    }**/


    // Método para inicializar datos de prueba
    public static MarketPlace inicializarDatos() {
        MarketPlace marketPlace = new MarketPlace("Mi Marketplace");

        Vendedor vendedor1 = Vendedor.Vendedorbuilder()
                .nombre("Sofia")
                .apellido("Suarez")
                .cedula("12345")
                .direccion("Calle 23")
                .username("Sofi")
                .contraseña("sofia123")
                .build();

        Vendedor vendedor2 = Vendedor.Vendedorbuilder()
                .nombre("Carlos")
                .apellido("Gomez")
                .cedula("67890")
                .direccion("Calle 45")
                .username("CarlosG")
                .contraseña("carlos123")
                .build();
        marketPlace.createVendedor(vendedor1);
        marketPlace.createVendedor(vendedor2);

        Producto producto1 = Producto.builder()
                .nombre("Laptop")
                .imagen("path/to/laptop/image.png") // Asegúrate de que la ruta sea correcta
                .categoria("Electrónica")
                .precio(1000.00)
                .estado(Estado.PUBLICADO)
                .build();

        Producto producto2 = Producto.builder()
                .nombre("Teléfono")
                .imagen("path/to/phone/image.png") // Asegúrate de que la ruta sea correcta
                .categoria("Electrónica")
                .precio(500.00)
                .estado(Estado.PUBLICADO)
                .build();

        // Agregar productos a los vendedores
        vendedor1.setListProductos(new ArrayList<>(List.of(producto1)));
        vendedor2.setListProductos(new ArrayList<>(List.of(producto2)));

        return marketPlace;
    }

}

