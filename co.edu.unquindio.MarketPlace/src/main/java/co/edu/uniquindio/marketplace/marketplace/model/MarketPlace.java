package co.edu.uniquindio.marketplace.marketplace.model;

import co.edu.uniquindio.marketplace.marketplace.service.ICrudVendedor;

import java.util.ArrayList;
import java.util.List;

public class MarketPlace implements ICrudVendedor {
    private String nombre;
    private List<Usuario> listUsuarios;
    private List<Administrador> listAdministradores;
    private List<Vendedor> listVendedores;

    public MarketPlace(){
        this.listUsuarios = new ArrayList<>();
        this.listAdministradores = new ArrayList<>();
        this.listVendedores = new ArrayList<>();
    }

    @Override
    public boolean createVendedor(String nombre, String apellido, String cedula, String direccion, String usuario, String contraseña){
        Vendedor vendedorExistente = verificarVendedor(cedula);
        if(vendedorExistente == null){
            Vendedor vendedor = Vendedor.builder()
                    .nombre(nombre)
                    .apellido(apellido)
                    .cedula(cedula)
                    .direccion(direccion)
                    .usuario(usuario)
                    .contraseña(contraseña)
                    .build();

            getListVendedores().add(vendedor);
            return true;
        }
        return false;
    }

    @Override
    public Vendedor readVendedor(String cedula){
        Vendedor vendedorExistente = verificarVendedor(cedula);
        if(vendedorExistente != null){
            return vendedorExistente;
        }
        return null;
    }

    @Override
    public boolean updateVendedor(String nombre, String apellido, String cedula, String direccion, String usuario, String contraseña){
        Vendedor vendedorExistente = verificarVendedor(cedula);
        if(vendedorExistente != null){
            vendedorExistente.setNombre(nombre);
            vendedorExistente.setApellido(apellido);
            vendedorExistente.setCedula(cedula);
            vendedorExistente.setDireccion(direccion);
            vendedorExistente.setUsuario(usuario);
            vendedorExistente.setContraseña(contraseña);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteVendedor(String cedula){
        Vendedor vendedorExistente = verificarVendedor(cedula);
        if (vendedorExistente != null){
            getListVendedores().remove(vendedorExistente);
            return true;
        }
        return false;
    }

    @Override
    public List<Vendedor> listVendedores(){
        return List.of();
    }

    @Override
    public boolean verificarVendedorExistente(String cedula){
        if(verificarVendedor(cedula) == null){
            return true;
        }
        return false;
    }

    public Vendedor verificarVendedor(String cedula){
        Vendedor vendedorExistente = null;

        for(Vendedor vendedor : listVendedores){
            if(vendedor.getCedula().equals(cedula)){
                vendedorExistente = vendedor;
                break;
            }
        }
        return vendedorExistente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Usuario> getListUsuarios() {
        return listUsuarios;
    }

    public void setListUsuarios(List<Usuario> listUsuarios) {
        this.listUsuarios = listUsuarios;
    }

    public List<Administrador> getListAdministradores() {
        return listAdministradores;
    }

    public void setListAdministradores(List<Administrador> listAdministradores) {
        this.listAdministradores = listAdministradores;
    }

    public List<Vendedor> getListVendedores() {
        return listVendedores;
    }

    public void setListVendedores(List<Vendedor> listVendedores) {
        this.listVendedores = listVendedores;
    }
}

