package co.edu.uniquindio.marketplace.marketplace.model.builder;

import co.edu.uniquindio.marketplace.marketplace.model.Vendedor;

public class VendedorBuilder extends UsuarioBuilder<VendedorBuilder>{

    protected String idVendedor;

    public VendedorBuilder idVendedor(String idVendedor) {
        this.idVendedor = idVendedor;
        return this;
    }

    @Override
    public Vendedor build() {
        return new Vendedor(idVendedor, nombre, apellido, cedula, direccion, usuario, contraseña)
;    }
}
