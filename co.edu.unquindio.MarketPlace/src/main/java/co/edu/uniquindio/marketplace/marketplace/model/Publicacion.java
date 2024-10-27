package co.edu.uniquindio.marketplace.marketplace.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Publicacion {
    private LocalDateTime fechaPublicacion;
    private String descripcion;
    private Producto producto;
    private List<Comentario> listComentarios;
    private List<Vendedor> listVendedores;

    public Publicacion(LocalDateTime fechaPublicacion, String descripcion, Producto producto, List<Comentario> listComentarios, List<Vendedor> listVendedores) {
        this.fechaPublicacion = fechaPublicacion;
        this.descripcion = descripcion;
        this.producto = producto;
        this.listComentarios = listComentarios;
        this.listVendedores = listVendedores;
    }

    public void añadirComentario(Comentario comentario) {
        this.listComentarios.add(comentario);
    }

    public void añadirLike(Vendedor vendedor) {
        this.listVendedores.add(vendedor);
    }

    public LocalDateTime getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicación(LocalDateTime fechaPublicación) {
        this.fechaPublicacion = fechaPublicación;
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

    public List<Vendedor> getListVendedores() {
        return listVendedores;
    }

    public void setListVendedores(List<Vendedor> listVendedores) {
        this.listVendedores = listVendedores;
    }
}
