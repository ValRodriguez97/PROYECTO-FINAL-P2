package co.edu.uniquindio.marketplace.marketplace.mapping.dto;

/**
 * Clase DTO (Data Transfer Object para la clase Administrador
 *
 * @param nombre Nombre del Administrador
 * @param apellido Apellido del Administrador
 * @param usuario Usuario del Administrador
 */
public record AdministradorDto (
        String nombre,
        String apellido,
        String usuario
){
}
