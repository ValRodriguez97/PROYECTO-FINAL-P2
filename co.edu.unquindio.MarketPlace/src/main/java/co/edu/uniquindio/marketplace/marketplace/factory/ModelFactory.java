package co.edu.uniquindio.marketplace.marketplace.factory;

import co.edu.uniquindio.marketplace.marketplace.mapping.dto.AdministradorDto;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.PublicacionDto;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.UsuarioDto;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.VendedorDto;
import co.edu.uniquindio.marketplace.marketplace.mapping.mappers.MarketPlaceMappingImplt;
import co.edu.uniquindio.marketplace.marketplace.model.MarketPlace;
import co.edu.uniquindio.marketplace.marketplace.model.Usuario;
import co.edu.uniquindio.marketplace.marketplace.model.Vendedor;
import co.edu.uniquindio.marketplace.marketplace.service.IModelFactory;

import java.util.List;

public class ModelFactory implements IModelFactory {
    private static ModelFactory instance;
    MarketPlace marketPlace;
    MarketPlaceMappingImplt mapper;

    public static ModelFactory getInstance() {
        if (instance == null){
            instance = new ModelFactory();
        }
        return instance;
    }

    private ModelFactory(){
        mapper = new MarketPlaceMappingImplt();
        marketPlace = inicializarDatos();
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
        if(marketPlace.verificarVendedorExistente(vendedorDto.cedula())){
            Vendedor newVendedor = mapper.vendedorDtoToVendedor(vendedorDto);
            getMarketPlace().createVendedor(newVendedor);
            return true;
        }
        return false;
    }
    @Override
    public boolean updateVendedor(VendedorDto vendedorDto) {
        if(marketPlace.verificarVendedorExistente(vendedorDto.cedula())){
            Vendedor vendedorActualizado= mapper.vendedorDtoToVendedor(vendedorDto);

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
    public UsuarioDto getUsuarioDto(UsuarioDto usuarioDto){
        if(verificarRegistro(usuarioDto)){
            return mapper.usuarioToUsuarioDto(marketPlace.getUsuarioVerificar(usuarioDto.usuario(), usuarioDto.contraseña()));
        }
        return null;
    }

    @Override
    public boolean addUsuario(UsuarioDto usuarioDto) {
        if(marketPlace.verificarUsuarioExistente(usuarioDto.cedula())){
            Usuario usuario = mapper.usuarioDtoToUsuario(usuarioDto);
            return marketPlace.createUsuario(usuario);
        }
        return false;
    }

    @Override
    public boolean updateUsuario(UsuarioDto usuarioDto) {
        if(!marketPlace.verificarUsuarioExistente(usuarioDto.cedula())){
            Usuario usuarioActualizado= mapper.usuarioDtoToUsuario(usuarioDto);
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
    public boolean admitirUsuario(UsuarioDto usuarioDto){
        if(marketPlace.verificarContraseñaUsuario(usuarioDto.usuario(), usuarioDto.contraseña())){
            return true;
        }
        return false;
    }



    public static MarketPlace inicializarDatos(){
        MarketPlace marketPlace = new MarketPlace("");
        Vendedor vendedorA = Vendedor.Vendedorbuilder()
                .nombre("Sofia")
                .apellido("Suarez")
                .cedula("12345")
                .direccion("Calle 23")
                .usuario("Sofi")
                .contraseña("sofia123")
                .build();

        Usuario usuario = new Usuario("Sofi", "Sara", "Rios", "123", "hasb", "1234");
        marketPlace.createUsuario(usuario);
        return marketPlace;
    }
}
