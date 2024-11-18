package co.edu.uniquindio.marketplace.marketplace.model;

import co.edu.uniquindio.marketplace.marketplace.service.ILike;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Publicacion implements ILike {
    private LocalDateTime fechaPublicacion;
    private String descripcion;
    private Producto producto;
    private List<Comentario> listComentarios;
    private List<Vendedor> listLikesVendedores;

    /**
     * Método Constructor de la clase Publicación
     *
     * @param fechaPublicacion Fecha en la que se realizó la publicación
     * @param descripcion Descripción de la Publicación
     * @param producto Producto agregado a la publicación
     */
    public Publicacion(LocalDateTime fechaPublicacion, String descripcion, Producto producto) {
        this.fechaPublicacion = fechaPublicacion;
        this.descripcion = descripcion;
        this.producto = producto;
        this.listComentarios =new ArrayList<Comentario>();
        this.listLikesVendedores = new ArrayList<>();
    }

    /**
     * Método Constructor de la clase Publicación Vacio
     */
    public Publicacion (){}

    /**
     * Método para añadir un comentario a una Publicación
     *
     * @param comentario Comentario a añadir
     */
    public void añadirComentario(Comentario comentario){
        listComentarios.add(comentario);
    }

    /**
     * Método para añadir un like a una Publicación
     *
     * @param vendedor Like a añadir
     */
    public void añadirLike(Vendedor vendedor){
        listLikesVendedores.add(vendedor);
    }

    /**
     * Método para que un vendedor le de Like a una publicación
     *
     * @param vendedor
     */
    @Override
    public void addLike(Vendedor vendedor){
        añadirLike(vendedor);
    }

    /**
     * Método para obtener la fecha de Publicación
     *
     * @return Fecha de publicación
     */
    public LocalDateTime getFechaPublicacion() {
        return fechaPublicacion;
    }

    /**
     * Método para establecer la fecha de Publicación
     *
     * @param fechaPublicacion Nueva fecha de publicación
     */
    public void setFechaPublicacion(LocalDateTime fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    /**
     * Método para obtener la descripcion de una Publicación
     *
     * @return Descripción de la Publicación
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Método para establecer la descripción de una Publicación
     *
     * @param descripcion Nueva descripción de la publicación
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Método para obtener el producto de una Publicación
     *
     * @return Producto de una publicación
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * Método para establecer el producto de una Publicación
     *
     * @param producto Nuevo Producto de la publicación
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     * Método para obtener la lista de comentarios de una Publicación
     *
     * @return Lista de comentarios de una publicación
     */
    public List<Comentario> getListComentarios() {
        return listComentarios;
    }

    /**
     * Método para establecer la lista de comentarios de una Publicación
     *
     * @param listComentarios Nueva lista de comentarios
     */
    public void setListComentarios(List<Comentario> listComentarios) {
        this.listComentarios = listComentarios;
    }

    /**
     * Método para obtener la lista de likes de los vendedores de una Publicación
     *
     * @return Lista de Likes de una publicación
     */
    public List<Vendedor> getListLikesVendedores() {
        return listLikesVendedores;
    }

    /**
     * Método para establecer la lista de likes de los vendedores de una Publicación
     *
     * @param listLikesVendedores Nueva lista de Likes de la Publicación
     */
    public void setListLikesVendedores(List<Vendedor> listLikesVendedores) {
        this.listLikesVendedores = listLikesVendedores;
    }
}
