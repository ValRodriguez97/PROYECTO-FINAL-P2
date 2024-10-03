package co.edu.uniquindio.marketplace.marketplace.model.builder;

import co.edu.uniquindio.marketplace.marketplace.model.Vendedor;

public class VendedorBuilder  extends PersonaBuilder<VendedorBuilder>{

    @Override
    protected VendedorBuilder self() {
        return this;
    }

    @Override
    public Vendedor build() {
        return new Vendedor(nombre, apellido, cedula, direccion, usuario, contraseña);
    }
}
