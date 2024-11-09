package co.edu.uniquindio.marketplace.marketplace.mapping.dto;

/**
 * Método DTO (Data Transfer Object) de la clase Usuario
 *
 * @param nombre Nombre del Usuario
 * @param apellido Apellido del Usuario
 * @param cedula Cedula del Usuario
 * @param direccion Dirección del Usuario
 * @param usuario Usuario
 * @param contraseña Contraseña del Usuario
 */
public record UsuarioDto (
        String nombre,
        String apellido,
        String cedula,
        String direccion,
        String usuario,
        String contraseña
){
}
