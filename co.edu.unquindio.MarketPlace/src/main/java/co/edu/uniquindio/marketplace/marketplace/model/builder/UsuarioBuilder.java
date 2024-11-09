package co.edu.uniquindio.marketplace.marketplace.model.builder;

import co.edu.uniquindio.marketplace.marketplace.model.Usuario;

public class UsuarioBuilder {
    protected String nombre;
    protected String apellido;
    protected String cedula;
    protected String direccion;
    protected String usuario;
    protected String contraseña;

    public UsuarioBuilder nombre(String nombre){
        this.nombre = nombre;
        return this;
    }

    public UsuarioBuilder apellido(String apellido){
        this.apellido = apellido;
        return this;
    }

    public UsuarioBuilder cedula(String cedula){
        this.cedula = cedula;
        return this;
    }

    public UsuarioBuilder direccion(String direccion){
        this.direccion = direccion;
        return this;
    }

    public UsuarioBuilder usuario(String usuario){
        this.usuario = usuario;
        return this;
    }

    public UsuarioBuilder contraseña(String contraseña){
        this.contraseña = contraseña;
        return this;
    }

    public Usuario build(){
        return new Usuario(nombre, apellido, cedula, direccion, usuario, contraseña);
    }

}
