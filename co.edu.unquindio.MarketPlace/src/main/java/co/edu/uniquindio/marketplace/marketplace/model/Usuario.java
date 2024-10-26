package co.edu.uniquindio.marketplace.marketplace.model;

import co.edu.uniquindio.marketplace.marketplace.model.builder.PersonaBuilder;

public class Usuario extends Persona {

    public Usuario(String nombre, String apellido, String cedula, String direccion, String usuario, String contraseña) {
        super(nombre, apellido, cedula, direccion, usuario, contraseña);
    }

    public Usuario(){

    }

    public static <T> PersonaBuilder<T> builder() {
    }
}
