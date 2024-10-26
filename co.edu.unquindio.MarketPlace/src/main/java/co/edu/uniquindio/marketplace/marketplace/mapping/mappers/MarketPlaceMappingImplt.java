package co.edu.uniquindio.marketplace.marketplace.mapping.mappers;

import co.edu.uniquindio.marketplace.marketplace.mapping.dto.AdministradorDto;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.ChatDto;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.ComentarioDto;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.VendedorDto;
import co.edu.uniquindio.marketplace.marketplace.model.Administrador;
import co.edu.uniquindio.marketplace.marketplace.model.Chat;
import co.edu.uniquindio.marketplace.marketplace.model.Comentario;
import co.edu.uniquindio.marketplace.marketplace.model.Vendedor;
import co.edu.uniquindio.marketplace.marketplace.service.IMarketPlaceMapping;

import java.util.ArrayList;
import java.util.List;

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
    public ComentarioDto comentarioToComentarioDto(Comentario comen)

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
