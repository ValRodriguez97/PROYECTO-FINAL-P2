package co.edu.uniquindio.marketplace.marketplace.mapping.dto;

import co.edu.uniquindio.marketplace.marketplace.model.Chat;
import co.edu.uniquindio.marketplace.marketplace.model.Mensaje;

import java.util.ArrayList;
import java.util.List;

public class ChatDto {
private List<VendedorDto> vendedores;
private List<MensajeDto> mensajes;

    public List<VendedorDto> getVendedores() {
        return vendedores;
    }

    public void setVendedores(List<VendedorDto> vendedores) {
        this.vendedores = vendedores;
    }

    public List<MensajeDto> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<MensajeDto> mensajes) {
        this.mensajes = mensajes;
    }

    public ChatDto (){
    this.vendedores = new ArrayList<VendedorDto>();
    this.mensajes = new ArrayList<MensajeDto>();


}

}