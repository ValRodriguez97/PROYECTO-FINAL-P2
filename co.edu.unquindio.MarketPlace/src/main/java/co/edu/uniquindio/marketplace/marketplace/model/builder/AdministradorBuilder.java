package co.edu.uniquindio.marketplace.marketplace.model.builder;

import co.edu.uniquindio.marketplace.marketplace.model.Administrador;

public class AdministradorBuilder extends PersonaBuilder<AdministradorBuilder>{
    @Override
    protected AdministradorBuilder self() {
        return this;
    }

    @Override
    public Administrador build() {
        return new Administrador(nombre, apellido, cedula, direccion, usuario, contraseña);
    }
}
