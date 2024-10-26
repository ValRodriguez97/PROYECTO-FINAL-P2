package co.edu.uniquindio.marketplace.marketplace.mapping.dto;

import java.time.LocalDateTime;

public record MensajeDto (
        String mensaje,
        LocalDateTime fechaMensaje
){
}
