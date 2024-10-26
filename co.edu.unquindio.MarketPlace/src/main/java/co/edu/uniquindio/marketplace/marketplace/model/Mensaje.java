package co.edu.uniquindio.marketplace.marketplace.model;

import java.time.LocalDateTime;

public class Mensaje {
    private Usuario usuario;
    private LocalDateTime fechaMensaje;
    private String mensaje;

    public Mensaje (Usuario usuario, LocalDateTime fechaMensaje, String mensaje){
        this.usuario = usuario;
        this.fechaMensaje = fechaMensaje;
        this.mensaje = mensaje;
    }

    public Mensaje (){

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getFechaMensaje() {
        return fechaMensaje;
    }

    public void setFechaMensaje(LocalDateTime fechaMensaje) {
        this.fechaMensaje = fechaMensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}

