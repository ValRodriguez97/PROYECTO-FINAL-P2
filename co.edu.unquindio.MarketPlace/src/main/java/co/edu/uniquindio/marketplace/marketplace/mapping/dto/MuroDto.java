package co.edu.uniquindio.marketplace.marketplace.mapping.dto;

import java.util.List;

/**
 * Clase DTO (Data Transfer Object) de la clase Muro
 *
 * @param listPublicaciones Lista de publicaciones en el Muro
 * @param listChats Lista de Chats en el Muro
 */
public record MuroDto (
        List<PublicacionDto> listPublicaciones,
        List<ChatDto> listChats
){
}
