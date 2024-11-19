package co.edu.uniquindio.marketplace.marketplace.model;

import co.edu.uniquindio.marketplace.marketplace.service.IObserver;

public class Usuario implements IObserver {
    private String nombre;
    private String apellido;
    private String cedula;
    private String direccion;
    private String username;
    private String contraseña;

    /**
     * Método Constructor de la clase Usuario
     *
     * @param nombre Nombre del Usuario
     * @param apellido Apellido del Usuario
     * @param cedula Cédula de Ciudadania del Usuario
     * @param direccion Dirección de vivienda del Usuario
     * @param username Usuario para iniciar sesión
     * @param contraseña Contraseña del Usuario
     */
    public Usuario(String nombre, String apellido, String cedula, String direccion, String username, String contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.direccion = direccion;
        this.username = username;
        this.contraseña = contraseña;
    }

    /**
     * Método Constructor de la clase Usuario vacio
     */
    public Usuario(){}

    /**
     * Método para obtener el nombre de un Usuario
     *
     * @return nombre del usuario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para establecer el nombre de un Usuario
     *
     * @param nombre Nuevo nombre del Usuario
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método para obtener el apellido de un Usuario
     *
     * @return apellido del Usuario
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Método para establecer el apellido de un Usuario
     *
     * @param apellido Nuevo apellido del Usuario
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Método para obtener la cedula de un Usuario
     *
     * @return cedula de un Usuario
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Método para establecer la cedula de un Usuario
     *
     * @param cedula Nueva cedula del Usuario
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * Método para obtener la direccion del usuario
     *
     * @return direccion del Usuario
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Método para establecer la direccion del Usuario
     *
     * @param direccion Nueva direccion del Usuario
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Método para obtener el username de un Usuario
     *
     * @return Username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Método para establecer el username de un Usuario
     *
     * @param username Nuevo username de Usuario
     */
   public void setUsername(String username) {
        this.username = username;
   }

    /**
     * Método para obtener la contraseña de un Usuario
     *
     * @return contraseña de un Usuario
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Método para establecer la contraseña de un Usuario
     *
     *
     * @param contraseña Nueva contraseña del Usuario
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    //OBSERVER
    @Override
    public void update(String mensaje){
        System.out.println("Usuario " + username + " recibió una notificación: " + mensaje);
    }
}
