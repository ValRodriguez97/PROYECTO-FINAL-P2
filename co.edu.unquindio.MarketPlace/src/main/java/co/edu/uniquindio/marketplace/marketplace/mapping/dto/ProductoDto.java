package co.edu.uniquindio.marketplace.marketplace.mapping.dto;

import co.edu.uniquindio.marketplace.marketplace.model.Estado;
import javafx.scene.image.Image;

import java.time.LocalDate;

public record ProductoDto (
        String nombre,
        Image imagen,
        String categoria,
        double precio,
        Estado estado
){
}
