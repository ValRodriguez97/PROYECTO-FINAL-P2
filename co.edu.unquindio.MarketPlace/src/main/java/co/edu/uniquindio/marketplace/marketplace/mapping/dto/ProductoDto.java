package co.edu.uniquindio.marketplace.marketplace.mapping.dto;

import co.edu.uniquindio.marketplace.marketplace.model.Estado;
import javafx.scene.image.Image;

import java.time.LocalDate;

/**
 *Clase DTO(Data Transfer Object)  de la clase Produto
 *
 * @param nombre Nombre del Producto
 * @param imagen Imagen del Producto
 * @param categoria Categoria del Producto
 * @param precio Precio del Producto
 * @param estado Estado del Producto
 */
public record ProductoDto (
        String nombre,
        String imagen,
        String categoria,
        double precio,
        Estado estado
){
    public String getNombre(){
        return nombre;
    }
}
