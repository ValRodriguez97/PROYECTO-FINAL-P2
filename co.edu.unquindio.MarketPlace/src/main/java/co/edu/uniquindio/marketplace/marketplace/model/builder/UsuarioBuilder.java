package co.edu.uniquindio.marketplace.marketplace.model.builder;

import co.edu.uniquindio.marketplace.marketplace.model.Usuario;

public class UsuarioBuilder extends PersonaBuilder<UsuarioBuilder> {
    @Override
    protected UsuarioBuilder self() {
        return this;
    }

    @Override
    public Usuario build() {
        return new Usuario(nombre, apellido, cedula, direccion, usuario, contraseña);
    }
}
