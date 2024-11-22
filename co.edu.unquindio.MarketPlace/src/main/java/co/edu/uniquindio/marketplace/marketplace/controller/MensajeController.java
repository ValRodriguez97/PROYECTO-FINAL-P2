package co.edu.uniquindio.marketplace.marketplace.controller;

import co.edu.uniquindio.marketplace.marketplace.factory.ModelFactory;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.ChatDto;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.MensajeDto;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.VendedorDto;
import co.edu.uniquindio.marketplace.marketplace.service.IServiceMensaje;

import java.util.List;

public class MensajeController implements IServiceMensaje {
    ModelFactory modelFactory;

    public  MensajeController(){
        modelFactory = ModelFactory.getInstance();
    }

    @Override
    public ChatDto getChat(VendedorDto vendedorDto1, VendedorDto vendedorDto2) {
        return modelFactory.getChat(vendedorDto1,vendedorDto2);
    }

    @Override
    public List<MensajeDto> getListaMensajes(String id) {
        return modelFactory.getListMensajesDto(id);
    }

    @Override
    public boolean addMessage(MensajeDto mensajeDto, ChatDto chatDto) {
        return modelFactory.addChatMessage(mensajeDto,chatDto);
    }

}
