package co.edu.uniquindio.marketplace.marketplace.mapping.dto;

/**
 * Método DTO (Data Transfer Object) de la clase Vendedor
 *
 * @param nombre Nombre del Vendedor
 * @param apellido Apellido del Vendedor
 * @param cedula Cedula del Vendedor
 * @param direccion Dirección del Vendedor
 * @param usuario Usuario del Vendedor
 * @param contraseña Contrasela del Vendedor
 */
public record VendedorDto (
        String nombre,
        String apellido,
        String cedula,
        String direccion,
        String usuario,
        String contraseña
) implements UsuarioDto{
}
