package co.edu.uniquindio.marketplace.marketplace.mapping.dto;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Clase DTO (Data Transfer Object) de la clase Publicación
 * 
 * @param fechaPublicacion Fecha en que se realizó la Publicación
 * @param descripcion Descripción de la Publicación
 * @param productoDto Producto de la Publicación
 * @param listComentarios Lista de Comentarios de la Publicación
 * @param listVendedores Lista de Vendedores de la Publicación
 */
public record PublicacionDto (
        LocalDateTime fechaPublicacion,
        String descripcion,
        ProductoDto productoDto,
        List<ComentarioDto> listComentarios,
        List<VendedorDto> listVendedores
){
}
