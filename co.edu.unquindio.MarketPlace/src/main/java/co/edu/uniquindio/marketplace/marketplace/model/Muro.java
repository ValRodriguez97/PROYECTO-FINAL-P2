package co.edu.uniquindio.marketplace.marketplace.model;

import java.util.ArrayList;
import java.util.List;

public class Muro {
    private List<Publicacion> listPublicaciones;
    private List<Chat> listChat;

    public Muro(){
        listPublicaciones = new ArrayList<Publicacion>();
        listChat = new ArrayList<>();
    }

    public void añadirPublicacion(Publicacion publicacion){
        listPublicaciones.add(publicacion);
    }

    public void añadirChat(Chat chat){
        listChat.add(chat);
    }

    public List<Publicacion> getListPublicaciones() {
        return listPublicaciones;
    }

    public void setListPublicaciones(List<Publicacion> listPublicaciones) {
        this.listPublicaciones = listPublicaciones;
    }

    public List<Chat> getListChat() {
        return listChat;
    }

    public void setListChats(List<Chat> listChats) {
        this.listChat = listChat;
    }
}
