package co.edu.uniquindio.marketplace.marketplace.mapping.dto;

import co.edu.uniquindio.marketplace.marketplace.model.Producto;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Clase DTO (Data Transfer Object) de la clase Publicación
 * 
 * @param fechaPublicacion Fecha en que se realizó la Publicación
 * @param descripcion Descripción de la Publicación
 * @param productoDto Producto de la Publicación

 */
public record PublicacionDto (
        LocalDateTime fechaPublicacion,
        String descripcion,
        Producto producto
){
}
