package co.edu.uniquindio.marketplace.marketplace.model;

import co.edu.uniquindio.marketplace.marketplace.model.builder.ProductoBuilder;
import javafx.scene.image.Image;

import java.time.LocalDate;

public class Producto {
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
        this.imagen = new Image(getClass().getResourceAsStream("/images/" + imagen));
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
     * Método para obtener la imagen del producto
     *
     * @return Imagen del Producto
     */
    public Image getImagen() {
        return imagen;
    }

    /**
     * Método para establecer la imagen de un Producto
     *
     * @param imagen Nueva imagen del Producto
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
