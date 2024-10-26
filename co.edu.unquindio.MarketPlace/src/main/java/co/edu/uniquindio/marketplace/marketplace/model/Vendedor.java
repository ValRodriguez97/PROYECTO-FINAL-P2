package co.edu.uniquindio.marketplace.marketplace.model;

import co.edu.uniquindio.marketplace.marketplace.model.builder.VendedorBuilder;

import java.util.ArrayList;
import java.util.List;

public class Vendedor extends  Persona {
    private int contactodMaximos = 10;
    private String idVendedor;
    private Muro muro;
    private List<Producto> listProductos;
    private List<Vendedor> listContactos;

    public Vendedor(String idVendedor,String nombre, String apellido, String cedula, String direccion, String usuario, String contraseña){
        super(nombre, apellido, cedula, direccion, usuario, contraseña);
        this.listProductos = new ArrayList<>();
        this.listContactos = new ArrayList<>();
        this.idVendedor = idVendedor;
        this.muro = new Muro();
    }

    public Vendedor (){

    }

    public static VendedorBuilder builder(){
        return new VendedorBuilder();
    }

    public void añadirContacto(Vendedor vendedor){
        if(!verificarContactoExistente(vendedor) && listContactos.size() < contactodMaximos){
            listContactos.add(vendedor);
        }
    }

    private boolean verificarContactoExistente(Vendedor vendedor){
        boolean contactoExistente = false;
        for(Vendedor vendedorA : listContactos){
            if(vendedorA.getIdVendedor().equals(vendedor.getIdVendedor())){
                contactoExistente = true;
            }
        }
        return contactoExistente;
    }

    public void añadirProducto(Producto producto){
        listProductos.add(producto);
    }


    public int getContactodMaximos() {
        return contactodMaximos;
    }

    public void setContactodMaximos(int contactodMaximos) {
        this.contactodMaximos = contactodMaximos;
    }

    public String getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(String idVendedor) {
        this.idVendedor = idVendedor;
    }

    public Muro getMuro() {
        return muro;
    }

    public void setMuro(Muro muro) {
        this.muro = muro;
    }

    public List<Producto> getListProductos() {
        return listProductos;
    }

    public void setListProductos(List<Producto> listProductos) {
        this.listProductos = listProductos;
    }

    public List<Vendedor> getListContactos() {
        return listContactos;
    }

    public void setListContactos(List<Vendedor> listContactos) {
        this.listContactos = listContactos;
    }
}
