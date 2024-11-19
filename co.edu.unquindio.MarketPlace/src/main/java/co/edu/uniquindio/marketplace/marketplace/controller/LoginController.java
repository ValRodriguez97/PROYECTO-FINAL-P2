package co.edu.uniquindio.marketplace.marketplace.controller;

import co.edu.uniquindio.marketplace.marketplace.factory.ModelFactory;
import co.edu.uniquindio.marketplace.marketplace.service.ILoginControllerService;

public class LoginController implements ILoginControllerService {
    ModelFactory modelFactory;

    public LoginController(){
        modelFactory = ModelFactory.getInstance();
    }

    @Override
    public UsuarioDto getUsuarioDto(UsuarioDto usuarioDto) {
        return modelFactory.getUsuarioDto(usuarioDto);

    }

    @Override
    public boolean verificarUsuario(UsuarioDto usuarioDto) {
        if(modelFactory.admitirUsuario(usuarioDto)){
            return true;
        }
        return false;
    }

    public boolean iniciarSesion(String nombre, String contraseña){
        return modelFactory.getMarketPlace().autenticarUsuario(nombre, contraseña);
    }

}
