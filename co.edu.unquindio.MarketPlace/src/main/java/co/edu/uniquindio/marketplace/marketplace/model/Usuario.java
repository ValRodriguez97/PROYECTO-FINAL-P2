package co.edu.uniquindio.marketplace.marketplace.model;

import co.edu.uniquindio.marketplace.marketplace.model.builder.UsuarioBuilder;

public class Usuario {
    private String nombre;
    private String apellido;
    private String cedula;
    private String direccion;
    private String usuario;
    private String contraseña;
    /**
     * Método Constructor de la clase Usuario
     *
     * @param nombre Nombre del Usuario
     * @param apellido Apellido del Usuario
     * @param cedula Cédula de Ciudadania del Usuario
     * @param direccion Dirección de vivienda del Usuario
     * @param usuario Usuario para iniciar sesión
     * @param contraseña Contraseña del Usuario
     */
    public Usuario(String nombre, String apellido, String cedula, String direccion, String usuario, String contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.direccion = direccion;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    /**
     * Método Constructor de la clase Usuario vacio
     */
    public Usuario(){}

    /**
     * Método builder de la clase Usuario
     *
     * @return Usuario Builder
     */
    public static UsuarioBuilder builder(){
        return new UsuarioBuilder();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
