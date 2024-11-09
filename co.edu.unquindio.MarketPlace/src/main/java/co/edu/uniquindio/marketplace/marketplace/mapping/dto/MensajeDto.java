package co.edu.uniquindio.marketplace.marketplace.mapping.dto;

import co.edu.uniquindio.marketplace.marketplace.model.Usuario;

import java.time.LocalDateTime;

/**
 * Clase DTO (Data Transfer Object de la clase Mensaje
 *
 * @param usuario Usuario que envio el mensaje
 * @param fechaMensaje Fecha en la que se realizo el mensaje
 * @param mensaje Contenido del mensaje
 */
public record MensajeDto (
        Usuario usuario,
        LocalDateTime fechaMensaje,
        String mensaje
){
}
