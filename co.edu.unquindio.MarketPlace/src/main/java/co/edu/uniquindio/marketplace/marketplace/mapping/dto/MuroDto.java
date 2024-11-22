package co.edu.uniquindio.marketplace.marketplace.mapping.dto;

import co.edu.uniquindio.marketplace.marketplace.model.Chat;
import co.edu.uniquindio.marketplace.marketplace.model.Publicacion;

import java.util.ArrayList;
import java.util.List;

public class MuroDto {
    private List<Publicacion> listPublicaciones;
    private List<Chat> listChats;

    public MuroDto( List<Publicacion> listPublicaciones, List<Chat> listChats) {
        this.listPublicaciones = listPublicaciones;
        this.listChats = listChats;
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