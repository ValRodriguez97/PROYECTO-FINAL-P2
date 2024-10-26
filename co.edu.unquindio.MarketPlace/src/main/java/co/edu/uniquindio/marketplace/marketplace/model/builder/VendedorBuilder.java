package co.edu.uniquindio.marketplace.marketplace.model.builder;

import co.edu.uniquindio.marketplace.marketplace.model.Vendedor;

public class VendedorBuilder  extends PersonaBuilder<VendedorBuilder>{
    protected String idVendedor;

    @Override
    protected VendedorBuilder self() {
        return this;
    }

    public VendedorBuilder idVendedor(String idVendedor) {
        this.idVendedor = idVendedor;
        return self();
    }

    public Vendedor build() {
        return new Vendedor(idVendedor, nombre, apellido, cedula, direccion, usuario, contraseña);
    }

}
