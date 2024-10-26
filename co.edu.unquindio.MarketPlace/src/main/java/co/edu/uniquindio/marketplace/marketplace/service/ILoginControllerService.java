package co.edu.uniquindio.marketplace.marketplace.service;

import co.edu.uniquindio.marketplace.marketplace.mapping.dto.UsuarioDto;

public interface ILoginControllerService {
    public UsuarioDto getUsuarioDto(UsuarioDto usuarioDto);
    public boolean verificarUsuario(UsuarioDto usuarioDto);

}
