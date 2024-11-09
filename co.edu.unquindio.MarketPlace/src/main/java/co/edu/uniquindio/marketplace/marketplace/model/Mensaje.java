package co.edu.uniquindio.marketplace.marketplace.model;

import java.time.LocalDateTime;

public class Mensaje {
    private Usuario usuario;
    private LocalDateTime fechaMensaje;
    private String mensaje;

    /**
     * Método Constructor de la clase Mensaje
     *
     * @param usuario Usuario que envio el mensaje
     * @param fechaMensaje Fecha en la que se envio el mensaje
     * @param mensaje Contenido del mensaje
     */
    public Mensaje (Usuario usuario, LocalDateTime fechaMensaje, String mensaje){
        this.usuario = usuario;
        this.fechaMensaje = fechaMensaje;
        this.mensaje = mensaje;
    }

    /**
     * Método Constructor de la clase Mensaje vacio
     */
    public Mensaje (){}

    /**
     * Método para obtener el usuario que envio un mensaje
     *
     * @return usuario que envio un mensaje
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Método para establecer el usuario que envio un mensaje
     *
     * @param usuario Nuevo usuario que envio el mensaje
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Método para obtener la fecha de un mensaje
     *
     * @return fecha del mensaje
     */
    public LocalDateTime getFechaMensaje() {
        return fechaMensaje;
    }

    /**
     * Método para establecer la fecha de un mensaje
     *
     * @param fechaMensaje Nueva fecha del mensaje
     */
    public void setFechaMensaje(LocalDateTime fechaMensaje) {
        this.fechaMensaje = fechaMensaje;
    }

    /**
     * Método para obtener un mensaje
     *
     * @return mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Método para establecer un mensaje
     *
     * @param mensaje Nuevo mensaje
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}

