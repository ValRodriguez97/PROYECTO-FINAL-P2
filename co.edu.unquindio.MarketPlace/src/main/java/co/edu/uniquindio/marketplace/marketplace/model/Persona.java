package co.edu.uniquindio.marketplace.marketplace.model;

import co.edu.uniquindio.marketplace.marketplace.model.builder.PersonaBuilder;

public abstract  class Persona {
    private String nombre;
    private String apellido;
    private String cedula;
    private String direccion;
    private String usuario;
    private String contraseña;

    /**
     * Método de la clase Persona vacio
     */
    public Persona() {}

    /**
     * Método Constructor de la clase Persona
     *
     * @param nombre Nombre de la Persona
     * @param apellido Apellido de la Persona
     * @param cedula Cedula de Ciudadania de la Persona
     * @param direccion Dirección de vivienda de la Persona
     * @param usuario Usuario de la Persona
     * @param contraseña Contraseña de inicio de sesión de la Persona
     */
    public Persona(String nombre, String apellido, String cedula, String direccion, String usuario, String contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.direccion = direccion;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    /**
     * Método para obtener el nombre de la Persona
     *
     * @return Nombre de la persona
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para establecer el nombre de la Persona
     *
     * @param nombre  Nuevo nombre de la Persona
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método para obtener el apellido de la Persona
     *
     * @return Apellido de la Persona
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Método para establecer el apellido de la Persona
     *
     * @param apellido
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Método para obtener la cedula de una Persona
     *
     * @return Cedula de una Persona
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Método para establecer la cedula de una Persona
     *
     * @param cedula
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * Método para obtener la dirección de una Persona
     *
     * @return Dirección de la persona
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Método para establecer la dirección de una Persona
     *
     * @param direccion Nueva dirección de la Persona
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Método para obtener el Usuario de una Persona
     *
     * @return Usuario de una Persona
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Método para establecer el usuario de una Persona
     *
     * @param usuario Nuevo usuario de la Persona
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Método para obtener la contraseña de una Persona
     *
     * @return contraseña de una Persona
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Método para establecer la contrasela de una Persona
     *
     * @param contraseña Nueva contraseña de la Persona
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
