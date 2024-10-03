package co.edu.uniquindio.marketplace.marketplace.model;

import java.util.ArrayList;
import java.util.List;

public class MarketPlace {
    private String nombre;
    private List<Usuario> listUsuarios;
    private List<Administrador> listAdministradores;
    private List<Vendedor> listVendedores;

    public MarketPlace(String nombre){
        this.nombre = nombre;
        this.listUsuarios = new ArrayList<>();
        this.listAdministradores = new ArrayList<>();
        this.listVendedores = new ArrayList<>();
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

