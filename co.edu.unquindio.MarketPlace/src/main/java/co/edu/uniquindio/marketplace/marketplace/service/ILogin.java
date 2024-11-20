package co.edu.uniquindio.marketplace.marketplace.service;

/**
 * Interface para la implementación del patrón Proxy
 */
public interface ILogin {
    boolean autenticar(String username, String contraseña);
}
