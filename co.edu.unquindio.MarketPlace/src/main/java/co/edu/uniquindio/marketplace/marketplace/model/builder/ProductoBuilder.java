package co.edu.uniquindio.marketplace.marketplace.model.builder;

import co.edu.uniquindio.marketplace.marketplace.model.Estado;
import co.edu.uniquindio.marketplace.marketplace.model.Producto;
import javafx.scene.image.Image;

import java.time.LocalDate;

public class ProductoBuilder {
    protected String nombre;
    protected String imagen;
    protected String categoria;
    protected double precio;

    protected Estado estado;

    public ProductoBuilder nombre(String nombre){
        this.nombre = nombre;
        return this;
    }

    public ProductoBuilder imagen(String  imagen){
        this.imagen = imagen;
        return this;
    }

    public ProductoBuilder categoria(String categoria){
        this.categoria = categoria;
        return this;
    }

    public ProductoBuilder precio(double precio){
        this.precio = precio;
        return this;
    }

    public ProductoBuilder estado(Estado estado){
        this.estado = estado;
        return this;
    }

    public Producto build(){
        return new Producto(nombre, imagen, categoria, precio,  estado);
    }
}
