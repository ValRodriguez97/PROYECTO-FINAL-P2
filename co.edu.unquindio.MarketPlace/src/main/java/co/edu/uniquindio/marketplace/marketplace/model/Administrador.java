package co.edu.uniquindio.marketplace.marketplace.model;

import co.edu.uniquindio.marketplace.marketplace.model.builder.AdministradorBuilder;

//Clase de tipo Admiistrador encardado de administrar las funciones del MarketPlace
public class Administrador extends  Usuario {
    private String idAdminsitrador;

    /**
     * Método Constructor del objeto Administrador
     *
     * @param idAdministrador Identificación del administrador
     * @param nombre Nombre del administrador
     * @param apellido Apellido del administrador
     * @param cedula Cedula de Ciudadania del administradir
     * @param direccion Dirección del administrador
     * @param username Usuario del perfil del administrador
     * @param contraseña Contraseña del perfil del administrador
     */
    public Administrador(String idAdministrador,String nombre, String apellido, String cedula, String direccion, String username, String contraseña) {
        super(nombre, apellido, cedula, direccion, username, contraseña);
        this.idAdminsitrador = idAdminsitrador;
    }

    /**
     * Método builder para la clase Administrador
     *
     * @return Administrador Builder
     */
    public static AdministradorBuilder Adminbuilder() {
        return new AdministradorBuilder();
    }

    /**
     * Método Constructor vacio del objeto Administrador
     */
    public Administrador() {}

    /**
     * Método para obtener la identificación del Administrador
     *
     * @return Identificación del Administrador
     */
    public String getIdAdministrador() {
        return idAdminsitrador;
    }

    /**
     * Método para establecer la identificación del Administrador
     *
     * @param idAdminsitrador Nueva identificación del Administrador
     */
    public void setIdAdministrador(String idAdminsitrador) {
        this.idAdminsitrador = idAdminsitrador;
    }
}
