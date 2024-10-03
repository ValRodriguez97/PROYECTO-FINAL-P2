package co.edu.uniquindio.marketplace.marketplace.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Publicacion {
    private String titulo;
    private String descripcion;
    private LocalDate fecha;
    private List<Producto> listProductos;

    public Publicacion(String titulo, String descripcion, LocalDate fecha) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.listProductos = new ArrayList<Producto>();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public List<Producto> getListProductos() {
        return listProductos;
    }

    public void setListProductos(List<Producto> listProductos) {
        this.listProductos = listProductos;
    }
}
