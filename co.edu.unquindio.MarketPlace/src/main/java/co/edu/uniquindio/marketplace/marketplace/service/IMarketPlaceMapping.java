package co.edu.uniquindio.marketplace.marketplace.service;

import co.edu.uniquindio.marketplace.marketplace.mapping.dto.AdministradorDto;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.ChatDto;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.VendedorDto;
import co.edu.uniquindio.marketplace.marketplace.model.Administrador;
import co.edu.uniquindio.marketplace.marketplace.model.Chat;
import co.edu.uniquindio.marketplace.marketplace.model.Vendedor;

import java.util.List;

public interface IMarketPlaceMapping {
     List<AdministradorDto> getAdministradoresDto(List<AdministradorDto> administradores);
     AdministradorDto administradorToAdministradorDto(Administrador administrador);
     Administrador administradorDtoToAdministrador(AdministradorDto administradorDto);

     ChatDto chatToChatDto(Chat chat);
     Chat chatDtoToChat(ChatDto chatDto);

     List<VendedorDto> getVendedoresDto(List<Vendedor> listVendedores);
     VendedorDto vendedorToVendedorDto(Vendedor vendedor);
     Vendedor vendedorDtoToVendedor(VendedorDto vendedorDto);
}
