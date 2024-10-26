package co.edu.uniquindio.marketplace.marketplace.mapping.dto;

import java.time.LocalDateTime;
import java.util.List;

public record PublicacionDto (
        LocalDateTime fechaPublicacion,
        String descripcion,
        ProductoDto productoDto,
        List<ComentarioDto> listComentarios,
        List<VendedorDto> listVendedores
){
}
