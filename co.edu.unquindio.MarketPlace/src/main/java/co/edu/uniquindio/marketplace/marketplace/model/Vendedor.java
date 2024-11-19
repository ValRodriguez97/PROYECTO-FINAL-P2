package co.edu.uniquindio.marketplace.marketplace.model;

import co.edu.uniquindio.marketplace.marketplace.model.builder.VendedorBuilder;
import co.edu.uniquindio.marketplace.marketplace.service.IObserver;

import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Usuario {
    private int contactodMaximos = 10;
    private String idVendedor;
    private Muro muro;
    private List<Producto> listProductos;
    private List<Vendedor> listContactos;
    private List<Producto> productosFavoritos;
    private List<Producto> historialConsultas;
    private List<IObserver> seguidores; //OBSERVER

    /**
     * Método Constructor de la clase Vendedor
     *
     * @param idVendedor Identificación del Vendedor
     * @param nombre Nombre del Vendedor
     * @param apellido Apellido del Vendedor
     * @param cedula Cédula de Ciudadanía del Vendedor
     * @param direccion Dirección del Vendedor
     * @param username Usuario del Vendedor
     * @param contraseña Contraseña del Vendedor
     */
    public Vendedor(String idVendedor,String nombre, String apellido, String cedula, String direccion, String username, String contraseña){
        super(nombre, apellido, cedula, direccion, username, contraseña);
        this.listProductos = new ArrayList<Producto>();
        this.listContactos = new ArrayList<Vendedor>();
        this.idVendedor = idVendedor;
        this.muro = new Muro();
        this.seguidores = new ArrayList<>(); //OBSERVER
    }

    /**
     * Método Constructor de la clase Vendedor
     */
    public Vendedor (){}

    /**
     * Método builder de la clase Vendedor
     *
     * @return VendedorBuilder
     */
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
     * @param nuevoContacto
     *
     * @return
     */
    public boolean verificarContactoExistente(Vendedor nuevoContacto) {
        for (Vendedor contacto : listContactos) {
            if (contacto.getIdVendedor().equals(nuevoContacto.getIdVendedor())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método para añadir un Producto
     *
     * @param producto
     */
    public void añadirProducto(Producto producto){
        listProductos.add(producto);
        notifySeguidores("Un nuevo producto se ha publicado " + producto.getNombre()); //OBSERVER
    }

    /**
     * Método para obtener los productos disponibles de un Vendedor
     *
     * @return productos disponibles
     */
    public List<Producto> getProductosDisponibles(){
        ArrayList<Producto> productosDisponibles = new ArrayList<>();
        for (Producto producto : listProductos) {
            if(producto.getEstado() == Estado.DISPONIBLE){
                productosDisponibles.add(producto);
            }
        }
        return productosDisponibles;
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

    public void agregarProductoAFavoritos(Producto producto) {
        if (!productosFavoritos.contains(producto)) {
            productosFavoritos.add(producto);
        }
    }

    public List<Producto> getProductosFavoritos() {
        return productosFavoritos;
    }

    public List<Producto> getHistorialConsultas(){
        return this.historialConsultas;
    }

    //OBSERVER
    public void addSeguidor(IObserver seguidor){
        seguidores.add(seguidor);
    }

    //OBSERVER
    public void deleteSeguidor(IObserver seguidor){
        seguidores.remove(seguidor);
    }

    //OBSERVER
    public void notifySeguidores(String mensaje){
        for (IObserver seguidor : seguidores){
            seguidor.update(mensaje);
        }
    }


}
