package co.edu.uniquindio.marketplace.marketplace.model;

import co.edu.uniquindio.marketplace.marketplace.model.builder.ProductoBuilder;

import java.time.LocalDate;

public class Producto {
    private String nombre;
    private String imagen;
    private String categoria;
    private double precio;
    private LocalDate fecha;
    private Estado estado;
    private Comentario comentario;
    private Vendedor vendedor;

    public Producto (String nombre, String imagen, String categoria, double precio, LocalDate fecha, Estado estado){
        this.nombre = nombre;
        this.imagen  = imagen;
        this.categoria = categoria;
        this.precio = precio;
        this.fecha = fecha;
        this.estado = estado;
    }

    public static ProductoBuilder builder() {
        return new ProductoBuilder();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
}
