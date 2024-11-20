package co.edu.uniquindio.marketplace.marketplace.mapping.dto;

import co.edu.uniquindio.marketplace.marketplace.model.Chat;
import co.edu.uniquindio.marketplace.marketplace.model.Publicacion;

import java.util.ArrayList;
import java.util.List;

public class MuroDto {
    private String idVendedor;
    private List<Publicacion> listPublicaciones;
    private List<Chat> listChats;

    public MuroDto(String idVendedor, List<Publicacion> listPublicaciones, List<Chat> listChats) {
        this.idVendedor = idVendedor;
        this.listPublicaciones = listPublicaciones;
        this.listChats = listChats;
    }

    public String getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(String idVendedor) {
        this.idVendedor = idVendedor;
    }

    public List<Publicacion> getListPublicaciones() {
        return listPublicaciones;
    }

    public void setListPublicaciones(List<Publicacion> listPublicaciones) {
        this.listPublicaciones = listPublicaciones;
    }

    public List<Chat> getListChats() {
        return listChats;
    }

    public void setListChats(List<Chat> listChats) {
        this.listChats = listChats;
    }
}