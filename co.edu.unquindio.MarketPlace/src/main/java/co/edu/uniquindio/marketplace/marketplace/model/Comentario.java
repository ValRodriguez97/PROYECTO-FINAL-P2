package co.edu.uniquindio.marketplace.marketplace.model;

import java.time.LocalDate;

public class Comentario {
    private String comentario;
    private LocalDate fecha;
    private Producto producto;

    public Comentario(String comentario, LocalDate fecha) {
        this.comentario = comentario;
        this.fecha = fecha;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
