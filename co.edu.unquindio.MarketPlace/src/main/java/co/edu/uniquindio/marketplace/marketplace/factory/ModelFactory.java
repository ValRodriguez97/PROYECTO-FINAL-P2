package co.edu.uniquindio.marketplace.marketplace.factory;

import co.edu.uniquindio.marketplace.marketplace.mapping.dto.*;
import co.edu.uniquindio.marketplace.marketplace.mapping.mappers.MarketPlaceMappingImplt;
import co.edu.uniquindio.marketplace.marketplace.model.*;
import co.edu.uniquindio.marketplace.marketplace.service.IModelFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ModelFactory implements IModelFactory {
    private static ModelFactory instance;
    MarketPlace marketPlace;
    MarketPlaceMappingImplt mapper;
    private List<ProductoDto> productos;
    private List<VendedorDto> vendedores;
    private MarketplaceFacade marketplaceFacade;

    public static ModelFactory getInstance() {
        if (instance == null) {
            instance = new ModelFactory();
        }
        return instance;
    }

    private ModelFactory() {
        mapper = new MarketPlaceMappingImplt();
        marketPlace = inicializarDatos();
        aplicarDescuentos();
        this.productos = new ArrayList<>();
        this.vendedores = new ArrayList<>();
        this.marketplaceFacade= new MarketplaceFacade();
    }

    public  List<ProductoDto> getProductosPorNombre(String nombre) {
        return productos.stream()
                .filter(producto -> producto.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<VendedorDto> getVendedoresPorNombre(String nombre) {
        return vendedores.stream()
                .filter((vendedor -> vendedor.getNombre().toLowerCase().contains(nombre.toLowerCase())))
                .collect(Collectors.toList());
    }

    public MarketPlace getMarketPlace() {
        return marketPlace;
    }

    public void setMarketPlace(MarketPlace marketPlace) {
        this.marketPlace = marketPlace;
    }

    @Override
    public List<VendedorDto> getVendedoresDto() {
        return mapper.getVendedoresDto(marketPlace.getListVendedores());
    }

    @Override
    public boolean addVendedor(VendedorDto vendedorDto) {
        if (marketPlace.verificarVendedorExistente(vendedorDto.cedula())) {
            Vendedor newVendedor = mapper.vendedorDtoToVendedor(vendedorDto);
            getMarketPlace().createVendedor(newVendedor);
            return true;
        }
        return false;
    }

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
    }


    // Método para inicializar datos de prueba
    public static MarketPlace inicializarDatos() {
        MarketPlace marketPlace = new MarketPlace("Mi Marketplace");

        Vendedor vendedor1 = Vendedor.Vendedorbuilder()
                .nombre("Sofia")
                .apellido("Suarez")
                .cedula("12345")
                .direccion("Calle 23")
                .usuario("Sofi")
                .contraseña("sofia123")
                .build();

        Vendedor vendedor2 = Vendedor.Vendedorbuilder()
                .nombre("Carlos")
                .apellido("Gomez")
                .cedula("67890")
                .direccion("Calle 45")
                .usuario("CarlosG")
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

    /**
     * Método para aplicar el descuento al producto
     */

    private void aplicarDescuentos() {
        for (Vendedor vendedor : marketPlace.getListVendedores()) {
            List<Producto> productosConDescuento = new ArrayList<>();
            for (Producto producto : vendedor.getListProductos()) {

                if (producto.getNombre().equals("Laptop")) {
                    productosConDescuento.add(new DescuentoDecorator(producto, 10));
                } else if (producto.getNombre().equals("Teléfono")) {
                    productosConDescuento.add(new DescuentoDecorator(producto, 15));
                } else {
                    productosConDescuento.add(producto);
                }
            }
            vendedor.setListProductos(productosConDescuento);
        }
    }

    public MarketplaceFacade getMarketplaceFacade(){
        return marketplaceFacade;
    }

}

