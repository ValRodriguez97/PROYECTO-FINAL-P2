package co.edu.uniquindio.marketplace.marketplace.model;

import java.util.ArrayList;
import java.util.List;

public class Muro {
    private String idVendedor;
    private List<Publicacion> listPublicaciones;
    private List<Chat> listChat;

    /**
     * Método Constructor de la clase Muro
     */
    public Muro() {
        listPublicaciones = new ArrayList<>();
        listChat = new ArrayList<>();
    }

    /**
     * Método para añadir una publicación al muro
     *
     * @param publicacion Publicación a añadir
     */
    public void añadirPublicacion(Publicacion publicacion){
        listPublicaciones.add(publicacion);
    }

    /**
     * Método para añadir un chat al muro
     *
     * @param chat Chat a añadir
     */
    public void añadirChat(Chat chat){
        listChat.add(chat);
    }

    /**
     * Método para obtener la lista de publicaciones en el muro
     *
     * @return lista de publicaciones
     */
    public List<Publicacion> getListPublicaciones() {
        return listPublicaciones;
    }

    /**
     * Método para establecer la lista de publicaciones
     *
     * @param listPublicaciones
     */
    public void setListPublicaciones(List<Publicacion> listPublicaciones) {
        this.listPublicaciones = listPublicaciones;
    }

    /**
     * Método para obtener la lista de chats del Muro
     *
     * @return listas de chats
     */
    public List<Chat> getListChat() {

        return listChat;
    }

    /**
     * Método para establecer la lista de chats de un muro
     *
     * @param listChat
     */
    public void setListChat(List<Chat> listChat) {
        this.listChat = listChat;
    }
}
