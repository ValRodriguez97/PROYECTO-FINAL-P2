package co.edu.uniquindio.marketplace.marketplace.model;

import java.util.ArrayList;
import java.util.List;

public class Vendedor extends  Persona {

    private List<Muro> muro;
    private List<Producto> listProductos;

    public Vendedor(String nombre, String apellido, String cedula, String direccion, String usuario, String contraseña){
        super(nombre, apellido, cedula, direccion, usuario, contraseña);
        muro = new ArrayList<>();
        listProductos = new ArrayList<>();
    }

    public List<Muro> getMuro() {
        return muro;
    }

    public void setMuro(List<Muro> muro) {
        this.muro = muro;
    }

    public List<Producto> getListProductos() {
        return listProductos;
    }

    public void setListProductos(List<Producto> listProductos) {
        this.listProductos = listProductos;
    }
}
