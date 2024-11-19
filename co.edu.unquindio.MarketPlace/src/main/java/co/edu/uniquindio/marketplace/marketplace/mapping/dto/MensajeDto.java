package co.edu.uniquindio.marketplace.marketplace.mapping.dto;

import co.edu.uniquindio.marketplace.marketplace.model.Usuario;

import java.time.LocalDateTime;

public class MensajeDto{
    private String mensaje;
    private LocalDateTime fechaMensaje;
    private Usuario usuario;

    public MensajeDto(String mensaje, LocalDateTime fechaMensaje, Usuario usuario) {
        this.mensaje = mensaje;
        this.fechaMensaje = fechaMensaje;
        this.usuario = usuario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getFechaMensaje() {
        return fechaMensaje;
    }

    public void setFechaMensaje(LocalDateTime fechaMensaje) {
        this.fechaMensaje = fechaMensaje;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
