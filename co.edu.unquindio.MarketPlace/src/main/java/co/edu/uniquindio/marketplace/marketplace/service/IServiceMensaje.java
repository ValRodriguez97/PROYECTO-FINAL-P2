package co.edu.uniquindio.marketplace.marketplace.service;

import co.edu.uniquindio.marketplace.marketplace.mapping.dto.ChatDto;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.MensajeDto;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.VendedorDto;

import java.util.List;

public interface IServiceMensaje {
    public ChatDto getChat(VendedorDto vendedorDto1, VendedorDto vendedorDto2);
    public List<MensajeDto> getListaMensajes(String id);
    public boolean addMessage(MensajeDto mensajeDto, ChatDto chatDto);
    }

