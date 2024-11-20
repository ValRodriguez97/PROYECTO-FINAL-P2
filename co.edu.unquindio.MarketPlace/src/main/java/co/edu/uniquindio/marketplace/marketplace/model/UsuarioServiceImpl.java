package co.edu.uniquindio.marketplace.marketplace.model;

import co.edu.uniquindio.marketplace.marketplace.service.IUsuarioService;

import java.util.List;

public class UsuarioServiceImpl implements IUsuarioService {
    private List<Usuario> usuarios;

    public UsuarioServiceImpl(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public boolean autenticarUsuario(String nombreUsuario, String contraseña) {
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(nombreUsuario) && usuario.getContraseña().equals(contraseña)) {
                // Aquí puedes establecer el usuario actual si es necesario
                return true;
            }
        }
        return false;
    }
}