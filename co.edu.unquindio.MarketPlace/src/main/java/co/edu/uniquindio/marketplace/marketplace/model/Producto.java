package co.edu.uniquindio.marketplace.marketplace.model;

import co.edu.uniquindio.marketplace.marketplace.model.builder.ProductoBuilder;
import javafx.scene.image.Image;

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Producto {
    private String idVendedor;
    private String nombre;
    private Image imagen;
    private String categoria;
    private double precio;
    private Estado estado;

    /**
     * Método Constructor de la clase Producto
     *
     * @param nombre Nombre del Producto
     * @param imagen Imagen del Producto
     * @param categoria Categoria en la que se encuentra el producto
     * @param precio Precio del Productor
     * @param estado Estado en el que se encuentra actualmente el producto
     */
    public Producto(String nombre, String imagen, String categoria, double precio, Estado estado) {
        this.nombre = nombre;
        this.imagen = new Image(getClass().getResource(imagen).toString());
        this.categoria = categoria;
        this.precio = precio;
        this.estado = estado;
    }

    /**
     * Método Constructor de la clase Producto vacio
     */
    public Producto(){}

    /**
     * Método Builder de la clase Producto
     *
     * @return Producto Builder
     */
    public static ProductoBuilder builder(){
        return new ProductoBuilder();
    }

    /**
     * Método para obtener el nombre del producto
     *
     * @return Nombre del Producto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para establecer el nombre del producto
     *
     * @param nombre Nuevo nombre del producto
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método para obtener la identificacion del Vendedor
     *
     * @return identificación del Vendedor
     */
    public String getIdVendedor() {
        return idVendedor;
    }

    /**
     * Método para establecer la identificación del Vendedor
     *
     * @param idVendedor Nueva identificación del Vendedor
     */
    public void setIdVendedor(String idVendedor) {
        this.idVendedor = idVendedor;
    }

    /**
     * Método para obtener la imagen de una publicación
     *
     * @return imagen de una publicación
     */
    public Image getImagen() {
        return imagen;
    }

    /**
     * Método para establecer la imagen de una publicación
     *
     * @param imagen Nueva imagen
     */
    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    /**
     * Método para obtener la categoria de un Producto
     *
     * @return Categoria de un Producto
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Método para establecer la categoria de un Producto
     *
     * @param categoria Nueva categoria del Producto
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Método para obtener el precio del Producto
     *
     * @return Precio del Producto
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Método para establecer el precio de un producto
     *
     * @param precio Nuevo precio del Producto
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Método para obtener el estado de un Producto
     *
     * @return Estado del producto
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * Método para establecer el estado de un Producto
     *
     * @param estado Nuevo estado del Producto
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
