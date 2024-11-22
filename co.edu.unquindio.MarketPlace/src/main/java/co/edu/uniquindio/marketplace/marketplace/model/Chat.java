package co.edu.uniquindio.marketplace.marketplace.model;

import java.util.ArrayList;
import java.util.List;

public class Chat {
    private final int maximoUsuariosChat = 2; //Es decir, un chat solo se da con dos personas
    private String idChat;
    private Vendedor vendedor1;
    private Vendedor vendedor2;
    private List<Mensaje> mensajes;

    /**
     * Método Constructor de la clase Chat
     */
    public Chat(String idChat) {
        this.idChat = idChat;
        this.mensajes = new ArrayList<Mensaje>();
    }
    public Chat(){}


    /**
     * Método para obtener el numero maximo de usuarios que se permite en un chat
     *
     * @return maximo usuarios chat
     */
    public int getMaximoUsuariosChat() {
        return maximoUsuariosChat;
    }

    public void enviarMensaje(Mensaje mensaje){
        mensajes.add(mensaje);
    }


    /**
     * Método para obtener la lista de mensajes de un chat
     *
     * @return lista de mensajes
     */
    public List<Mensaje> getMensajes() {
        return mensajes;
    }

    /**
     * Método para establecer la lista de mensajes de un chat
     * @param mensajes
     */
    public void setMensajes(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }

    public String getIdChat() {
        return idChat;
    }

    public void setIdChat(String idChat) {
        this.idChat = idChat;
    }

    public Vendedor getVendedor1() {
        return vendedor1;
    }

    public void setVendedor1(Vendedor vendedor1) {
        this.vendedor1 = vendedor1;
    }

    public Vendedor getVendedor2() {
        return vendedor2;
    }

    public void setVendedor2(Vendedor vendedor2) {
        this.vendedor2 = vendedor2;
    }
}
