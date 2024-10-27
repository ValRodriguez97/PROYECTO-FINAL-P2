package co.edu.uniquindio.marketplace.marketplace.mapping.dto;

import co.edu.uniquindio.marketplace.marketplace.model.Usuario;

import java.time.LocalDateTime;

public record MensajeDto (
        Usuario usuario,
        LocalDateTime fechaMensaje,
        String mensaje
){
}
