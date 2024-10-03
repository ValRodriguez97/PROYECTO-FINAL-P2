package co.edu.uniquindio.marketplace.marketplace.service;

import co.edu.uniquindio.marketplace.marketplace.model.Vendedor;

import java.util.List;

public interface ICrudVendedor {
    boolean createVendedor(String nombre, String apellido, String cedula, String direccion, String usuario, String contraseña);
    Vendedor readVendedor(String cedula);
    boolean updateVendedor(String nombre, String apellido, String cedula, String direccion, String usuario, String contraseña);
    boolean deleteVendedor(String cedula);
    List<Vendedor> listVendedores();

    boolean verificarVendedorExistente (String cedula);
}
