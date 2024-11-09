package co.edu.uniquindio.marketplace.marketplace.mapping.dto;

import co.edu.uniquindio.marketplace.marketplace.model.Mensaje;

import java.util.List;

/**
 * Clase DTO (Data Transfer Object) de la clase Chat
 *
 * @param mensajes Mensaje del Chat
 */
public record ChatDto(
        List<Mensaje> mensajes
){
}
