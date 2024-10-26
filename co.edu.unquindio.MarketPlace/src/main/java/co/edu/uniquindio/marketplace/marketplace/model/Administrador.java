package co.edu.uniquindio.marketplace.marketplace.model;

import co.edu.uniquindio.marketplace.marketplace.model.builder.AdministradorBuilder;

public class Administrador extends Persona {
    private String idAdminsitrador;

    public Administrador(String idAdminsitrador,String nombre, String apellido, String cedula, String direccion, String usuario, String contraseña) {
        super(nombre, apellido, cedula, direccion, usuario, contraseña);
        this.idAdminsitrador = idAdminsitrador;
    }

    public Administrador() {

    }

    public static AdministradorBuilder builder() {
        return new AdministradorBuilder();
    }

    public String getIdAdminsitrador() {
        return idAdminsitrador;
    }

    public void setIdAdminsitrador(String idAdminsitrador) {
        this.idAdminsitrador = idAdminsitrador;
    }
}
