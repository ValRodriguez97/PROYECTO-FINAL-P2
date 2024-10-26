package co.edu.uniquindio.marketplace.marketplace.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Comentario {
    private Usuario usuario;
    private LocalDateTime fechaComentario;
    private String comentario;
    private int numLikes;

    public Comentario(Usuario usuario, LocalDateTime fechaComentario, String comentario){
        this.usuario = usuario;
        this.fechaComentario = fechaComentario;
        this.comentario = comentario;
        this.numLikes = numLikes;
    }

    public Comentario(){

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getFechaComentario() {
        return fechaComentario;
    }

    public void setFechaComentario(LocalDateTime fechaComentario) {
        this.fechaComentario = fechaComentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getNumLikes() {
        return numLikes;
    }

    public void setNumLikes(int numLikes) {
        this.numLikes = numLikes;
    }
}
