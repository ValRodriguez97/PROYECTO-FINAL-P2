package co.edu.uniquindio.marketplace.marketplace.model;

import co.edu.uniquindio.marketplace.marketplace.model.builder.VendedorBuilder;

import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Usuario {
    private int contactodMaximos = 10;
    private String idVendedor;
    private Muro muro;
    private List<Producto> listProductos;
    private List<Vendedor> listContactos;

    /**
     * Método Constructor de la clase Vendedor
     *
     * @param idVendedor Identificación del Vendedor
     * @param nombre Nombre del Vendedor
     * @param apellido Apellido del Vendedor
     * @param cedula Cédula de Ciudadanía del Vendedor
     * @param direccion Dirección del Vendedor
     * @param usuario Usuario del Vendedor
     * @param contraseña Contraseña del Vendedor
     */
    public Vendedor(String idVendedor,String nombre, String apellido, String cedula, String direccion, String usuario, String contraseña){
        super(nombre, apellido, cedula, direccion, usuario, contraseña);
        this.listProductos = new ArrayList<Producto>();
        this.listContactos = new ArrayList<Vendedor>();
        this.idVendedor = idVendedor;
        this.muro = new Muro();
    }

    /**
     * Método Constructor de la clase Vendedor
     */
    public Vendedor (){}

    public static VendedorBuilder Vendedorbuilder(){
        return new VendedorBuilder();
    }

    /**
     * Método para añadir un contacto a la lista de Contactos del Vendedor
     *
     * @param vendedor
     */
    public void añadirContacto(Vendedor vendedor){
        if(!verificarContactoExistente(vendedor) && listContactos.size() < contactodMaximos){
            listContactos.add(vendedor);
        }
    }

    /**
     * Método para verificar si un contacto ya existe en la lista de contactos del Vendedor
     *
     * @param vendedor
     *
     * @return contactoExistente
     */
    private boolean verificarContactoExistente(Vendedor vendedor){
        boolean contactoExistente = false;
        for(Vendedor vendedorA : listContactos){
            if(vendedorA.getIdVendedor().equals(vendedor.getIdVendedor())){
                contactoExistente = true;
            }
        }
        return contactoExistente;
    }

    /**
     * Método para añadir un Producto
     *
     * @param producto
     */
    public void añadirProducto(Producto producto){
        listProductos.add(producto);
    }

    /**
     * Método para obtener el numero de contactos maximos que puede tener un Vendedor
     *
     * @return Número de contactos máximos
     */
    public int getContactodMaximos() {
        return contactodMaximos;
    }

    /**
     * Método para establecer la cantidad de contactos máximos de un Vendedor
     *
     * @param contactodMaximos
     */
    public void setContactodMaximos(int contactodMaximos) {
        this.contactodMaximos = contactodMaximos;
    }

    /**
     * Método para obtener la identificación del Vendedor
     *
     * @return Identificación del Vendedor
     */
    public String getIdVendedor() {
        return idVendedor;
    }

    /**
     * Método para establecer la identificación de un Vendedor
     *
     * @param idVendedor Nueva identificación del Vendedor
     */
    public void setIdVendedor(String idVendedor) {
        this.idVendedor = idVendedor;
    }

    /**
     * Método para obtener el Muro
     *
     * @return Muro
     */
    public Muro getMuro() {
        return muro;
    }

    /**
     * Método para establecer el Muro del Vendedor
     * @param muro
     */
    public void setMuro(Muro muro) {
        this.muro = muro;
    }

    /**
     * Método para obtener la lista de Productos del Vendedor
     *
     * @return Lista de Productos del Vendedor
     */
    public List<Producto> getListProductos() {
        return listProductos;
    }

    /**
     * Método para establecer la lista de Productos del Vendedor
     *
     * @param listProductos
     */
    public void setListProductos(List<Producto> listProductos) {
        this.listProductos = listProductos;
    }

    /**
     * Método para obtener la lista de Contactos del Vendedor
     *
     * @return Lista de Contactos del Vendedor
     */
    public List<Vendedor> getListContactos() {
        return listContactos;
    }

    /**
     * Método para establecer la lista de Contactos del Vendedor
     *
     * @param listContactos
     */
    public void setListContactos(List<Vendedor> listContactos) {
        this.listContactos = listContactos;
    }
}
