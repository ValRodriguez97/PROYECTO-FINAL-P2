package co.edu.uniquindio.marketplace.marketplace.model;

import java.util.ArrayList;
import java.util.List;

public class Chat {
    private List<Mensaje> mensajes;

    public Chat(List<Mensaje> mensajes) {
        this.mensajes = new ArrayList<Mensaje>();
    }

    public void añadirMensaje(Mensaje mensaje) {
        mensajes.add(mensaje);
    }

    public List<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }
}
