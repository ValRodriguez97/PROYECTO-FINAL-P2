package co.edu.uniquindio.marketplace.marketplace.service;

import co.edu.uniquindio.marketplace.marketplace.model.Administrador;

import java.util.List;
/**
 * Interface para implementar el Crud de la clase Administrador
 */
public interface ICrudAdministrador {
    boolean createAdministrador(Administrador administrador);
    boolean updateAdministrador(String idAdministrador, Administrador administrador);
    boolean deleteAdministrador(String idAdministrador);
    List<Administrador> listAdministradores();

}
