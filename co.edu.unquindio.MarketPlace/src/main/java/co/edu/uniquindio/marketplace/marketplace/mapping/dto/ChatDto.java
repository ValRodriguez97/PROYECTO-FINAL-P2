package co.edu.uniquindio.marketplace.marketplace.mapping.dto;

import co.edu.uniquindio.marketplace.marketplace.model.Mensaje;

import java.util.List;

public record ChatDto(
        List<Mensaje> mensajes
){
}
