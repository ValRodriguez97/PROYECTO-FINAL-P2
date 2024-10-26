package co.edu.uniquindio.marketplace.marketplace.mapping.dto;

import java.util.List;

public record MuroDto (
        List<PublicacionDto> listPublicaciones,
        List<ChatDto> listChats
){
}
