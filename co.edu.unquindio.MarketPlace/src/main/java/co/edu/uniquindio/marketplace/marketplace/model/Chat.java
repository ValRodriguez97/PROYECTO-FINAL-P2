package co.edu.uniquindio.marketplace.marketplace.model;

import java.util.ArrayList;
import java.util.List;

public class Chat {
    private final int maximoUsuariosChat = 2; //Es decir, un chat solo se da con dos personas
    private List<Usuario> usuarios;
    private List<Mensaje> mensajes;

    /**
     * Método Constructor de la clase Chat
     */
    public Chat(List<Mensaje> mensajes) {
        this.usuarios = new ArrayList<Usuario>();
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
     * @param usuario a agregar
     *
     * @return exito del proceso
     */
   public boolean agregarUsuarioChat(Usuario usuario) {
        if(usuarios.size() < maximoUsuariosChat) {
            if(!usuarios.contains(usuario)) {
                usuarios.add(usuario);
                return true;
            } else {
                throw new UnsupportedOperationException();
            }
        } else {
            throw new UnsupportedOperationException();
        }
   }

    /**
     * Método para obtener la cantidad máxima de usuarios que hay en un chat
     *
     * @return cantidad máxima de usuarios en un chat
     */
    public int getMaximoUsuariosChat(){
        return maximoUsuariosChat;
    }

    /**
     * Método para obtener la lista de usuarios de un chat
     *
     * @return lista de usuarios de un chat
     */
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * Método para establecer la lista de usuarios de un chat
     *
     * @param usuarios Nueva lista de usuarios
     */
    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    /**
     * Método para obtener la lista de mensajes de un chat
     *
     * @return Lista de mensajes de un chat
     */
    public List<Mensaje> getMensajes() {
        return mensajes;
    }

    /**
     * Método para establecer la lista de mensajes de un chat
     *
     * @param mensajes Nueva lista de mensajes de un chat
     */
    public void setMensajes(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }
}
