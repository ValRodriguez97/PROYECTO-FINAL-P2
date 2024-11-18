package co.edu.uniquindio.marketplace.marketplace.model;

import java.util.ArrayList;
import java.util.List;

public class Chat {
    private final int maximoUsuariosChat = 2; //Es decir, un chat solo se da con dos personas
    private List<Vendedor> vendedores;
    private List<Mensaje> mensajes;

    /**
     * Método Constructor de la clase Chat
     */
    public Chat(List<Mensaje> mensajes) {
        this.vendedores = new ArrayList<Vendedor>();
        this.mensajes = new ArrayList<Mensaje>();
    }

    /**
     * Método para agregar mensajes a un chat
     *
     * @param mensaje a añadir
     */
    public void añadirMensaje(Mensaje mensaje) {
        mensajes.add(mensaje);
    }

    /**
     * Método para agregar un usuario al chat
     *
     * @param vendedor a agregar
     *
     * @return exito del proceso
     */
    public boolean agregarVendedorAlChat(Vendedor vendedor) {
        if (vendedores.size() < maximoUsuariosChat) {
            if (vendedores.contains(vendedor)) {
                vendedores.add(vendedor);
                return true;
            } else {
                throw new IllegalArgumentException("El vendedor ya se encuentra agregado al chat");
            }
        } else{
            throw  new IllegalStateException("Maximo de vendedores permitidos, no se puede añadir más");
        }
    }

    /**
     * Método para obtener el numero maximo de usuarios que se permite en un chat
     *
     * @return maximo usuarios chat
     */
    public int getMaximoUsuariosChat() {
        return maximoUsuariosChat;
    }

    /**
     * Método para  obtener la lista de vendedores
     *
     * @return lsita de vendedores
     */
    public List<Vendedor> getVendedores() {
        return vendedores;
    }

    /**
     * Método para establecer la lista de vendedores de un chat
     *
     * @param vendedores
     */
    public void setVendedores(List<Vendedor> vendedores) {
        this.vendedores = vendedores;
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
}
