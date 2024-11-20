package co.edu.uniquindio.marketplace.marketplace.model;

import co.edu.uniquindio.marketplace.marketplace.service.ILogin;

/**
 * Implementación del patrón proxy
 */
public class UsuarioProxy implements ILogin {

    private MarketPlace marketPlace;

    public UsuarioProxy(MarketPlace marketPlace){
        this.marketPlace=marketPlace;
    }

    @Override
    public boolean autenticar(String username, String contraseña){
        System.out.println("Proxy: verificando datos...");
        if (username == null || contraseña == null) {
            System.out.println("Proxy: Credenciales inválidas.");
            return false;
        }
        boolean autenticado = marketPlace.autenticarUsuario(username, contraseña);
        if (autenticado) {
            System.out.println("Proxy: Usuario autenticado exitosamente.");
        } else {
            System.out.println("Proxy: Autenticación fallida.");
        }
        return autenticado;
    }
    }

