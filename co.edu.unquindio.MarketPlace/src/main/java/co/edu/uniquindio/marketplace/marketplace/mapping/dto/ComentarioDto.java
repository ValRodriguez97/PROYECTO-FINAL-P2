package co.edu.uniquindio.marketplace.marketplace.mapping.dto;

import co.edu.uniquindio.marketplace.marketplace.model.Usuario;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Clase DTO (Data Transfer Object) de la clase Comentario
 *
 * @param usuario Usuario que comento
 * @param fechaComentario Fecha del comentario
 * @param comentario Contenido del Comentario
 */
public record ComentarioDto (
        Usuario usuario,
        LocalDateTime fechaComentario,
        String comentario){
}
