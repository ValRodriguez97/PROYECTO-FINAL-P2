package co.edu.uniquindio.marketplace.marketplace.model;

import java.util.ArrayList;
import java.util.List;

public class Muro {
    private List<Publicacion> listPublicaciones;
    private List<Chat> listChats;

    public Muro(){
        listPublicaciones = new ArrayList<>();
        listChats = new ArrayList<>();
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
