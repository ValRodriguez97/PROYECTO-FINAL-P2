package co.edu.uniquindio.marketplace.marketplace.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Comentario {
    private Usuario usuario;
    private LocalDateTime fechaComentario;
    private String comentario;
    private int numLikes;

    /**
     * Método Constructor de la clase Comentario
     *
     * @param usuario Usuario que comenta
     * @param fechaComentario Fecha y hora del comentario
     * @param comentario Comentario
     */
    public Comentario(Usuario usuario, LocalDateTime fechaComentario, String comentario){
        this.usuario = usuario;
        this.fechaComentario = fechaComentario;
        this.comentario = comentario;
        this.numLikes = 0;
    }

    /**
     * Método Constructor vacio
     */
    public Comentario(){}

    /**
     * Método para obtener el usuario que comento
     *
     * @return Usuario que comento
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Método para establecer el usuario que comento en una publicación
     *
     * @param usuario Nuevo usuario que comento
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Método para obtener la fecha en la que se hizo un comentario
     *
     * @return fecha del comentario
     */
    public LocalDateTime getFechaComentario() {
        return fechaComentario;
    }

    /**
     * Método para establecer la fecha de un comentario
     *
     * @param fechaComentario Nueva fecha del comentario
     */
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
