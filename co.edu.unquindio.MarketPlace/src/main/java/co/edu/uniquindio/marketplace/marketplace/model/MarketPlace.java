package co.edu.uniquindio.marketplace.marketplace.model;

import co.edu.uniquindio.marketplace.marketplace.model.builder.VendedorBuilder;
import co.edu.uniquindio.marketplace.marketplace.model.chainOfResponsability.publicacion.PublicacionFiltro;
import co.edu.uniquindio.marketplace.marketplace.model.observer.EventoObserver;
import co.edu.uniquindio.marketplace.marketplace.service.*;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MarketPlace implements ICrudVendedor, ICrudPublicacion, ICrudUsuario, ICrudAdministrador {
    private String nombre;
    private List<Usuario> listUsuarios;
    private List<Administrador> listAdministradores;
    private List<Vendedor> listVendedores;
    private List<Publicacion> publicaciones;
    private Usuario usuarioActual;
    private MarketplaceFacade marketplaceFacade;
    private IStrategyPublicacion estrategiaPublicacion;
    private IStrategyProducto estrategiaProducto;

    public MarketPlace(String nombre) {
        this.nombre = nombre;
        this.listUsuarios = new ArrayList<Usuario>();
        this.listAdministradores = new ArrayList<Administrador>();
        this.listVendedores = new ArrayList<Vendedor>();
    }
    
    @Override
    public boolean createVendedor(Vendedor vendedor){
       if(!verificarVendedorExistente(vendedor.getIdVendedor())){
           Vendedor newVendedor = Vendedor.Vendedorbuilder()
                   .idVendedor(vendedor.getIdVendedor())
                   .nombre(vendedor.getNombre())
                   .apellido(vendedor.getApellido())
                   .cedula(vendedor.getCedula())
                   .direccion(vendedor.getDireccion())
                   .username(vendedor.getUsername())
                   .contraseña(vendedor.getContraseña())
                   .build();

           newVendedor.setMuro(new Muro());
           newVendedor.setListProductos(new ArrayList<>());
           newVendedor.setListContactos(new ArrayList<>());
           add(newVendedor);

           return true;
       }
       return false;
    }

    public void agregarPublicacion(Vendedor vendedor, Publicacion publicacion){
        vendedor.getMuro().añadirPublicacion(publicacion);
    }

    public void agregarComentarioAPublicacion(Vendedor vendedor, Publicacion publicacion, Comentario comentario){
        if (vendedor.getMuro().getListPublicaciones().contains(publicacion)){
            publicacion.añadirComentario(comentario);
        }
    }

    public boolean añadirContacto(Vendedor vendedor, Vendedor nuevoContacto) {
        if (!vendedor.verificarContactoExistente(nuevoContacto) &&
            vendedor.getListContactos().size() < vendedor.getContactodMaximos()){
            vendedor.añadirContacto(nuevoContacto);
            return true;
        }
        return false;
    }

    public List <Vendedor> obtenerSugerenciasContactos(Vendedor vendedor){
        List<Vendedor> sugerencias = new ArrayList<>();
        for (Vendedor otroVendedor : listVendedores){
            if (!vendedor.verificarContactoExistente(otroVendedor) && !otroVendedor.equals(vendedor)) {
                sugerencias.add(otroVendedor);
            }
        }
        return sugerencias;
    }

    @Override
    public boolean updateVendedor(String idVendedor, Vendedor vendedor){
        Vendedor vendedorExistente = verificarVendedor(idVendedor);
        if(vendedorExistente != null){
            vendedorExistente.setIdVendedor(vendedor.getIdVendedor());
            vendedorExistente.setNombre(vendedor.getNombre());
            vendedorExistente.setApellido(vendedor.getApellido());
            vendedorExistente.setDireccion(vendedor.getDireccion());
            vendedorExistente.setUsername(vendedor.getUsername());
            vendedorExistente.setContraseña(vendedor.getContraseña());
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteVendedor(String idVendedor) {
        Vendedor vendedorExistente = verificarVendedor(idVendedor);
        if (vendedorExistente != null) {
            getListVendedores().remove(vendedorExistente);
            return true;
        }
        return false;
    }

    @Override
    public List<Vendedor> listVendedores() {
        return new ArrayList<>(listVendedores);
    }

    @Override
    public boolean verificarVendedorExistente(String idVendedor) {
        return verificarVendedor(idVendedor) != null;
    }

    public Vendedor verificarVendedor(String idVendedor) {
        for (Vendedor vendedor : listVendedores) {
            if (vendedor.getCedula().equals(idVendedor)) {
                return vendedor;
            }
        }
        return null;
    }

    @Override
    public boolean createPublicacion(Publicacion publicacion, Vendedor vendedor) {
        if (!verificarPublicacion(publicacion, vendedor)) {
            vendedor.getMuro().añadirPublicacion(publicacion);
            return true;
        }
        return false;
    }

    @Override
    public boolean updatePublicacion(Publicacion publicacion, Vendedor vendedor) {
        List<Publicacion> listPublicaciones = vendedor.getMuro().getListPublicaciones();

        for (Publicacion publicacionExistente : listPublicaciones) {
            if (publicacionExistente.equals(publicacion)) {
                publicacionExistente.setFechaPublicacion(publicacion.getFechaPublicacion());
                publicacionExistente.setDescripcion(publicacion.getDescripcion());
                publicacionExistente.setProducto(publicacion.getProducto());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deletePublicacion(Publicacion publicacion, Vendedor vendedor) {
       List<Publicacion> listPublicaciones = vendedor.getMuro().getListPublicaciones();
       return listPublicaciones.remove(publicacion);
    }

    @Override
    public boolean verificarPublicacionExistente(Publicacion publicacion, Vendedor vendedor) {
        return verificarPublicacion(publicacion, vendedor);
    }

    public boolean verificarPublicacion(Publicacion publicacion, Vendedor vendedor) {
        List<Publicacion> listPublicaciones = vendedor.getMuro().getListPublicaciones();
        return listPublicaciones.contains(publicacion);
    }

    //CHAIN OF RESPONSABILITY
    public List<Publicacion> filtrarPublicaciones(PublicacionFiltro filtro){
        return filtro.filtrar(publicaciones);
    }

    public boolean verificarAdministradorExiste(String idAdministrador) {
        return verificarAdministrador(idAdministrador) != null; // Retorna true si existe, false si no
    }

    public Administrador verificarAdministrador(String idAdministrador) {
        for (Administrador administrador : listAdministradores) {
            if (administrador.getIdAdministrador().equals(idAdministrador)) {
                return administrador;
            }
        }
        return null;
    }

    @Override
    public boolean createAdministrador(Administrador administrador) {
        if (!verificarAdministradorExiste(administrador.getIdAdministrador())) {
            // El administrador ya existe
            Administrador nuevoAdministrador = Administrador.Adminbuilder()
                    .idAdministrador(administrador.getIdAdministrador())
                    .nombre(administrador.getNombre())
                    .apellido(administrador.getApellido())
                    .cedula(administrador.getCedula())
                    .direccion(administrador.getDireccion())
                    .username(administrador.getUsername())
                    .contraseña(administrador.getContraseña())
                    .build();
            add(nuevoAdministrador);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateAdministrador(String idAdministrador, Administrador administrador) {
        Administrador administradorExistente = verificarAdministrador(idAdministrador);

        if (administradorExistente != null) {
            administradorExistente.setIdAdministrador(administrador.getIdAdministrador());
            administradorExistente.setNombre(administrador.getNombre());
            administradorExistente.setApellido(administrador.getApellido());
            administradorExistente.setCedula(administrador.getCedula());
            administradorExistente.setDireccion(administrador.getDireccion());
            administradorExistente.setUsername(administrador.getUsername());
            administradorExistente.setContraseña(administrador.getContraseña());
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteAdministrador(String idAdministrador) {
        Administrador administradorExistente = verificarAdministrador(idAdministrador);
        if (administradorExistente != null) {
            listAdministradores.remove(administradorExistente);
            return true;
        }
        return false;
    }

    @Override
    public List<Administrador> listAdministradores() {
        return new ArrayList<>(listAdministradores);
    }

    @Override
    public Publicacion getPublicacion(Publicacion publicacion) {
        for(Vendedor vendedor : listVendedores){
            for (Publicacion publicacion1 : vendedor.getMuro().getListPublicaciones()){
                if(publicacion.equals(publicacion1)) {
                    return publicacion1;
                }
            }
        }
        return null;
    }

    @Override
    public boolean verificarUsuarioExistente(String cedula) {
        return getUsuario(cedula) != null;
    }

    @Override
    public boolean createUsuario(Usuario usuario) {
        if (!verificarUsuarioExistente(usuario.getCedula())) {
            add(usuario);
            return true;
        }

        return false;
    }

    @Override
    public boolean updateUsuario (Usuario usuarioActualizado){
        Usuario usuarioExistente = getUsuario(usuarioActualizado.getCedula());

        if (usuarioExistente == null){
            usuarioExistente.setNombre(usuarioActualizado.getNombre());
            usuarioExistente.setApellido(usuarioActualizado.getApellido());
            usuarioExistente.setDireccion(usuarioActualizado.getDireccion());
            usuarioExistente.setUsername(usuarioActualizado.getUsername());
            usuarioExistente.setContraseña(usuarioActualizado.getContraseña());
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteUsuario (Usuario usuario){
        if (usuario != null && getListUsuarios().contains(usuario)){
            getListUsuarios().remove(usuario);
            return true;
        }
        return false;
    }

    @Override
    public Usuario getUsuario (String cedula){
        for (Usuario usuario : getListUsuarios()){
            if (usuario.getCedula().equals(cedula)){
                return usuario;
            }
        }
        return null;
    }

    public Usuario getUsuarioVerificar(String usuario, String contraseña){
        if(verificarContraseñaUsuario(usuario, contraseña)){
            for(Usuario usuario1 : listUsuarios){
                if(usuario1.getUsername().equals(usuario) && usuario1.getContraseña().equals(contraseña)){
                    return usuario1;
                }
            }
        }
        return null;
    }

    public boolean verificarContraseñaUsuario(String usuario, String contraseña){
        for (Usuario contraseñaValida : listUsuarios){
            if(contraseñaValida.getUsername().equals(usuario) && contraseñaValida.getContraseña().equals(contraseña)){
                return true;
            }
        }
        return false;
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }
    
    public void setUsuarioActual(Usuario usuario) {
        this.usuarioActual = usuario;
    }
    
    public boolean autenticarUsuario(String nombreUsuario, String contraseña) {
        for (Usuario usuario : getListUsuarios()) {
            if (usuario.getUsername().equals(nombreUsuario) && usuario.getContraseña().equals(contraseña)) {
                setUsuarioActual(usuario); 
                return true;
            }
        }
        return false;
    }
    
    public static void exportarEstadisticos(MarketPlace marketPlace){

        String titulo = "Reporte de estadísticas";

        Usuario usuarioActual = marketPlace.getUsuarioActual();
        String usuario = usuarioActual != null ? usuarioActual.getNombre(): "Desconocido";

        String fecha = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        StringBuilder contenido = new StringBuilder();
        List<Vendedor> vendedores = marketPlace.getListVendedores();
        for (Vendedor vendedor : vendedores) {
            contenido.append("Vendedor:").append(vendedor.getNombre()).append("").append(vendedor.getApellido()).append("\n");

            long productosVendidos = vendedor.getListProductos().stream().filter(p -> p.getEstado() == Estado.VENDIDO).count();
            long productosPublicados = vendedor.getListProductos().stream().filter(p -> p.getEstado() == Estado.PUBLICADO).count();
            long productosCancelados = vendedor.getListProductos().stream().filter(p -> p.getEstado() == Estado.CANCELADO).count();

            contenido.append("Total de productos:").append(vendedor.getListProductos().size()).append("\n");
            contenido.append("Productos vendidos:").append(productosVendidos).append("\n");
            contenido.append("Productos publicados:").append(productosPublicados).append("\n");
            contenido.append("Productos cancelados:").append(productosCancelados).append("\n");
            contenido.append("----------\n");
        }

        String ruta = "reporte_estadistica.txt";

        try (FileWriter writer = new FileWriter(ruta)){
            writer.write("<Título>" + titulo + "\n");
            writer.write("<Fecha> Fecha:" + fecha + "\n");
            writer.write("<Usuario> Reporte hecho por:" + usuario + "\n\n");
            writer.write("Información del reporte:\n" + contenido + "\n");
            writer.write("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
            System.out.println("Reporte exportado existosamente en" + ruta);
        } catch (IOException e){
            System.out.println("Error al exportar el reporte:" + e.getMessage());
        }
    }

    public <T> void add(T object){
        if(object instanceof Usuario usuario){
            listUsuarios.add(usuario);

            if(usuario instanceof Administrador administrador){
                listAdministradores.add(administrador);
            } else  if(usuario instanceof Vendedor vendedor){
                listVendedores.add(vendedor);
            } else {
                throw new IllegalStateException("No se puede agregar el objeto");
            }
        }
    }

    public String getNombre () {
        return nombre;
    }

    public void setNombre (String nombre){
        this.nombre = nombre;
    }

    public List<Usuario> getListUsuarios () {
        return listUsuarios;
    }

    public void setListUsuarios (List < Usuario > listUsuarios) {
        this.listUsuarios = listUsuarios;
    }

    public List<Administrador> getListAdministradores () {
        return listAdministradores;
    }

    public void setListAdministradores (List < Administrador > listAdministradores) {
        this.listAdministradores = listAdministradores;
    }

    public List<Vendedor> getListVendedores () {
        return listVendedores;
    }

    public void setListVendedores (List < Vendedor > listVendedores) {
        this.listVendedores = listVendedores;
    }

    /**
     * Método para aplicar el descuento al producto
     */
    public void aplicarDescuentos() {
        for (Vendedor vendedor : listVendedores()) {
            List<Producto> productosConDescuento = new ArrayList<>();
            for (Producto producto : vendedor.getListProductos()) {

                if (producto.getNombre().equals("Laptop")) {
                    productosConDescuento.add(new DescuentoDecorator(producto, 10));
                } else if (producto.getNombre().equals("Teléfono")) {
                    productosConDescuento.add(new DescuentoDecorator(producto, 15));
                } else {
                    productosConDescuento.add(producto);
                }
            }
            vendedor.setListProductos(productosConDescuento);
        }
    }

    public MarketplaceFacade getMarketplaceFacade(){
        return marketplaceFacade;
    }
//STRATEGY
    public void setEstrategiaProducto(IStrategyProducto estrategiaProducto){
        this.estrategiaProducto = estrategiaProducto;
    }
   public void ordenarProductos(List<Producto> productos){
        if(estrategiaProducto != null){
            estrategiaProducto.ordenarProducto(productos);
        }
   }
//STRATEGY
   public void setEstrategiaPublicacion(IStrategyPublicacion estrategiaPublicacion){
        this.estrategiaProducto = estrategiaProducto;
   }

   public void ordenarPublicaciones(){
        if(estrategiaPublicacion != null){
            estrategiaPublicacion.ordenarPublicacion(publicaciones);
        } 
   }

   public void notificarEvento(Vendedor vendedor, String mensaje){
       EventoObserver evento = new EventoObserver("NOTIFICACION", mensaje, null , vendedor);
       vendedor.notifySeguidores(evento);
   }

}



