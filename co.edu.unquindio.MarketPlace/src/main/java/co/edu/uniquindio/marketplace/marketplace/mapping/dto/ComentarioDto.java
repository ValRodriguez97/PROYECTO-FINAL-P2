package co.edu.uniquindio.marketplace.marketplace.mapping.dto;

import co.edu.uniquindio.marketplace.marketplace.model.Usuario;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ComentarioDto (
        Usuario usuario,
        LocalDateTime fechaComentario,
        String comentario){
}
