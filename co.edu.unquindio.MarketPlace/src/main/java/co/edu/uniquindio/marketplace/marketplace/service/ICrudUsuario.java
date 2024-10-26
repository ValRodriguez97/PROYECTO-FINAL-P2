package co.edu.uniquindio.marketplace.marketplace.service;

import co.edu.uniquindio.marketplace.marketplace.model.Usuario;

public interface ICrudUsuario{

    boolean createUsuario(Usuario usuario);
    boolean updateUsuario(Usuario usuario);
    boolean deleteUsuario(Usuario usuario);
    Usuario getUsuario(String cedula);

    boolean verificarUsuarioExistente(String cedula);

}
