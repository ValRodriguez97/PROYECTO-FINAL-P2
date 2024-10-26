package co.edu.uniquindio.marketplace.marketplace.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Publicacion {
    private LocalDateTime fechaPublicación;
    private String descripcion;
    private Producto producto;
    private List<Comentario> listComentarios;
    private List<Vendedor> likes;

    public  Publicacion (LocalDateTime fechaPublicacion, String descripcion, Producto producto) {
        this.fechaPublicación = fechaPublicacion;
        this.descripcion = descripcion;
        this.producto = producto;
        this.likes = new ArrayList<>();
        this.listComentarios = new ArrayList<Comentario>();
    }

    public void añadirComentario(Comentario comentario) {
        this.listComentarios.add(comentario);
    }

    public void añadirLike(Vendedor vendedor) {
        this.likes.add(vendedor);
    }

    public LocalDateTime getFechaPublicación() {
        return fechaPublicación;
    }

    public void setFechaPublicación(LocalDateTime fechaPublicación) {
        this.fechaPublicación = fechaPublicación;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Comentario> getListComentarios() {
        return listComentarios;
    }

    public void setListComentarios(List<Comentario> listComentarios) {
        this.listComentarios = listComentarios;
    }

    public List<Vendedor> getLikes() {
        return likes;
    }

    public void setLikes(List<Vendedor> likes) {
        this.likes = likes;
    }
}
