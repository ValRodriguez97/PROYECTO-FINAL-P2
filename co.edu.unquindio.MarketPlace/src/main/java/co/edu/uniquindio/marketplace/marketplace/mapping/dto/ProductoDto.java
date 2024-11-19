package co.edu.uniquindio.marketplace.marketplace.mapping.dto;

import co.edu.uniquindio.marketplace.marketplace.model.Estado;
import javafx.scene.image.Image;

import java.time.LocalDate;

public class ProductoDto {
    private String idVendedor;
    private String nombre;
    private String image;
    private String categoria;
    private double precio;
    private Estado estado;

    public ProductoDto(String idVendedor, String nombre, String image, String categoria, double precio, Estado estado) {
        this.idVendedor = idVendedor;
        this.nombre = nombre;
        this.image = image;
        this.categoria = categoria;
        this.precio = precio;
        this.estado = estado;
    }

    public String getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(String idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
