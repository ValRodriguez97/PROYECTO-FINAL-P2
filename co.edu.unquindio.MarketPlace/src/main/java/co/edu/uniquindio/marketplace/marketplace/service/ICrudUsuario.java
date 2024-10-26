package co.edu.uniquindio.marketplace.marketplace.service;

import co.edu.uniquindio.marketplace.marketplace.model.Usuario;

public interface ICrudUsuario{

    boolean createUsuario(String nombre, String apellido, String cedula, String direccion, String usuario, String contraseña);
    boolean updateUsuario(Usuario usuario);
    boolean deleteUsuario(Usuario usuario);
    Usuario getUsuario(String cedula);

    boolean verificarUsuarioExistente(String cedula);

}
