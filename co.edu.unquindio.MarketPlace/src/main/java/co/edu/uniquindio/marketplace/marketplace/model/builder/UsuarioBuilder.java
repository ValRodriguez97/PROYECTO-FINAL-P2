package co.edu.uniquindio.marketplace.marketplace.model.builder;

import co.edu.uniquindio.marketplace.marketplace.model.Usuario;

public class UsuarioBuilder <T extends UsuarioBuilder<T>> {
    protected String nombre;
    protected String apellido;
    protected String cedula;
    protected String direccion;
    protected String username;
    protected String contraseña;

    public T nombre(String nombre){
        this.nombre = nombre;
        return self();
    }

    public T apellido(String apellido){
        this.apellido = apellido;
        return self();
    }

    public T cedula(String cedula){
        this.cedula = cedula;
        return self();
    }

    public T direccion(String direccion){
        this.direccion = direccion;
        return self();
    }

    public T username(String username){
        this.username = username;
        return self();
    }

    public  T contraseña(String contraseña){
        this.contraseña = contraseña;
        return self();
    }

    @SuppressWarnings("unchecked")
    protected T self(){
        return (T) this;
    }

    public Usuario build(){
        return new Usuario(nombre, apellido, cedula, direccion, username, contraseña);
    }

}
