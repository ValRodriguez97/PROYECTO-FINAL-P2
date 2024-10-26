package co.edu.uniquindio.marketplace.marketplace.mapping.dto;

import java.time.LocalDate;

public record ProductoDto (
        String nombre,
        String imagen,
        String categoria,
        double precio,
        String estado
){
}
