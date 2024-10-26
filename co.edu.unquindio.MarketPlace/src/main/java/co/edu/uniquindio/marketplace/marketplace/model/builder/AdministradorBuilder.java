package co.edu.uniquindio.marketplace.marketplace.model.builder;

import co.edu.uniquindio.marketplace.marketplace.model.Administrador;

public class AdministradorBuilder extends PersonaBuilder<AdministradorBuilder>{
   protected String idAdministrador;
    @Override
    protected AdministradorBuilder self() {
        return this;
    }

    @Override
    public Administrador build() {
        return new Administrador(idAdministrador,nombre, apellido, cedula, direccion, usuario, contraseña);
    }
}
