package co.edu.uniquindio.marketplace.marketplace.mapping.dto;

import co.edu.uniquindio.marketplace.marketplace.model.Usuario;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ComentarioDto {
    private Usuario usuario;
    private LocalDateTime fechaComentario;
    private String comentario;
    private int numLikes;

    public ComentarioDto(Usuario usuario, LocalDateTime fechaComentario, String comentario, int numLikes) {
        this.usuario = usuario;
        this.fechaComentario = fechaComentario;
        this.comentario = comentario;
        this.numLikes = numLikes;
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