package co.edu.uniquindio.marketplace.marketplace.mapping.dto;

import java.time.LocalDate;

public record ComentarioDto (
        String comentario,
        LocalDate fecha,
        ProductoDto producto
){
}
