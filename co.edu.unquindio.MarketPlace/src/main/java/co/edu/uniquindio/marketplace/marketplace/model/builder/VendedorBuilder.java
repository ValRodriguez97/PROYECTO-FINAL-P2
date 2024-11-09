package co.edu.uniquindio.marketplace.marketplace.model.builder;

import co.edu.uniquindio.marketplace.marketplace.model.Vendedor;

public class VendedorBuilder {
    protected String idVendedor;
    protected String nombre;
    protected String apellido;
    protected String cedula;
    protected String direccion;
    protected String usuario;
    protected String contraseña;

    public VendedorBuilder idVendedor(String idVendedor) {
        this.idVendedor = idVendedor;
        return this;
    }

    public VendedorBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public VendedorBuilder apellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public VendedorBuilder cedula(String cedula) {
        this.cedula = cedula;
        return this;
    }

    public VendedorBuilder direccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public VendedorBuilder usuario(String usuario) {
        this.usuario = usuario;
        return this;
    }

    public VendedorBuilder contraseña(String contraseña){
        this.contraseña = contraseña;
        return this;
    }

    public Vendedor build() {
        return new Vendedor(idVendedor, nombre, apellido, cedula, direccion, usuario, contraseña);
    }
}
