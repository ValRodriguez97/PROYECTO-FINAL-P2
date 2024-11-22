package co.edu.uniquindio.marketplace.marketplace.model;

import co.edu.uniquindio.marketplace.marketplace.model.chainOfResponsability.publicacion.PublicacionFiltro;
import co.edu.uniquindio.marketplace.marketplace.model.observer.EventoObserver;
import co.edu.uniquindio.marketplace.marketplace.service.*;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * La clase MarketPlace es un mercado en línea que gestiona usuarios, administrados, vendedores y publicaciones
 * Implementa las interfaces de CRUD para usuarios, administradores, vendedores y publicaciones
 */
public class MarketPlace implements ICrudPublicacion, ICrudUsuario  {
    private String nombre;
    private List<Usuario> listUsuarios;
    private List<Administrador> listAdministradores;
    private List<Vendedor> listVendedores;
    private List<Publicacion> publicaciones;
    private Usuario usuarioActual;
    private IStrategyPublicacion estrategiaPublicacion;
    private IStrategyProducto estrategiaProducto;
    private List<EventoObserver> eventos;

    /**
     * Método constructor de la clase MarketPlace
     * @param nombre
     */
    public MarketPlace(String nombre) {
        this.nombre = nombre;
        this.listUsuarios = new ArrayList<>();
        this.listAdministradores = new ArrayList<>();
        this.listVendedores = new ArrayList<>();
        this.publicaciones = new ArrayList<>();
        this.eventos = new ArrayList<>();
    }

    //METODOS PARA VENDEDOR /////////////////

    /**
     * Método que agrega una publicación al muro de un vendedor
     * @param vendedor
     * @param publicacion
     */
    public void agregarPublicacion(Vendedor vendedor, Publicacion publicacion){
        vendedor.getMuro().añadirPublicacion(publicacion);
        notificarEvento(vendedor, "Nueva publicacion agregada " + publicacion.getProducto().getNombre());
    }

    /**
     * Método que agrega una publicación al muro de un vendedor
     * @param vendedor
     * @param publicacion
     * @param comentario
     */
    public void agregarComentarioAPublicacion(Vendedor vendedor, Publicacion publicacion, Comentario comentario){
        if (vendedor.getMuro().getListPublicaciones().contains(publicacion)){
            publicacion.añadirComentario(comentario);
        }
    }


    /**
     * Método que obtiene una lista de sugerencias de contactos para un vendedor
     * @param vendedor
     * @return
     */
    public List <Vendedor> obtenerSugerenciasContactos(Vendedor vendedor){
        List<Vendedor> sugerencias = new ArrayList<>();
        for (Vendedor otroVendedor : listVendedores){
            if (!vendedor.verificarContactoExistente(otroVendedor) && !otroVendedor.equals(vendedor)) {
                sugerencias.add(otroVendedor);
            }
        }
        return sugerencias;
    }

    public Vendedor verificarVendedor(String idVendedor) {
        if (idVendedor == null) {
            return null;
        }
        for (Vendedor vendedor : listVendedores) {
            if (vendedor.getIdVendedor().equals(idVendedor)) {
                return vendedor;
            }
        }
        return null;
    }

    //METODOS PARA PUBLICACIONES //////////

    @Override
    public boolean createPublicacion(Publicacion publicacion, String vendedor) {
        Vendedor vendedor1 = verificarVendedor(vendedor);
        if(vendedor1 != null && !verificarPublicacionExistente(publicacion)){
            vendedor1.getMuro().añadirPublicacion(publicacion);
            publicaciones.add(publicacion);
            return true;
        }
        return false;
    }

    @Override
    public boolean updatePublicacion(Publicacion publicacion, String vendedor) {
       for(Vendedor vendedor1 : listVendedores){
           if(vendedor1.getMuro().getListPublicaciones().contains(publicacion)){
               publicacion.setFechaPublicacion(LocalDateTime.now());
               return true;
           }
       }
       return  false;
    }

    @Override
    public boolean deletePublicacion(Publicacion publicacion, String vendedor) {
       Vendedor vendedor1 = verificarVendedor(vendedor);
       if(vendedor1 != null && vendedor1.getMuro().getListPublicaciones().contains(publicacion)){
           vendedor1.getMuro().eliminarPublicacion(publicacion);
           publicaciones.remove(publicacion);
           notificarEvento(vendedor1, "Publiicación eliminada: " + publicacion.getProducto().getNombre());
           return true;
       }
       return false;
    }

    @Override
    public boolean verificarPublicacionExistente(Publicacion publicacion) {
        return verificarPublicacion(publicacion);
    }

    public boolean verificarPublicacion(Publicacion publicacion) {
        List<Publicacion> publicaciones = new ArrayList<>();
        for(Vendedor vendedor : listVendedores){
            publicaciones.addAll(vendedor.getMuro().getListPublicaciones());
        }
        return publicaciones.stream().allMatch(p -> p.getProducto().equals(publicacion.getProducto()));
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
            listUsuarios.add(usuario);
            return true;
        }

        return false;
    }

    public Usuario getUsuarioLogin(String username, String password){
        if(verificarContraseñaUsuario(username,password)){
            for(Usuario user : listUsuarios){
                if(user.getUsername().equals(username) && user.getContraseña().equals(password)){
                    return user;
                }
            }
        }
        return null;
    }

    public Usuario getUserId(String id){
        for(Vendedor vendedor : listVendedores){
            if(vendedor.getIdVendedor().equals(id)){
                return  vendedor;
            }
        }
        return null;
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
        return autenticarUsuario(usuario, contraseña) ? usuarioActual : null;
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
        for (Usuario usuario : listUsuarios) {
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
            contenido.append("Vendedor:").append(vendedor.getNombre()).append(" ").append(vendedor.getApellido()).append("\n");

            long productosVendidos = vendedor.getListProductos().stream().filter(p -> p.getEstado() == Estado.VENDIDO).count();
            long productosPublicados = vendedor.getListProductos().stream().filter(p -> p.getEstado() == Estado.PUBLICADO).count();
            long productosCancelados = vendedor.getListProductos().stream().filter(p -> p.getEstado() == Estado.CANCELADO).count();

            contenido.append("Total de productos: ").append(vendedor.getListProductos().size()).append("\n");
            contenido.append("Productos vendidos: ").append(productosVendidos).append("\n");
            contenido.append("Productos publicados: ").append(productosPublicados).append("\n");
            contenido.append("Productos cancelados: ").append(productosCancelados).append("\n");
            contenido.append("----------\n");
        }

        String ruta = "reporte_estadistica.txt";

        try (FileWriter writer = new FileWriter(ruta)){
            writer.write("<Título>" + titulo + "\n");
            writer.write("<Fecha> Fecha: " + fecha + "\n");
            writer.write("<Usuario> Reporte hecho por: " + usuario + "\n\n");
            writer.write("Información del reporte:\n" + contenido + "\n");
            writer.write("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
            System.out.println("Reporte exportado existosamente en " + ruta);
        } catch (IOException e){
            System.out.println("Error al exportar el reporte: " + e.getMessage());
        }
    }


    public String getNombre () {
        return nombre;
    }

    public void setNombre (String nombre){
        this.nombre = nombre;
    }

    /**
     * Método para la implementación del decorator
     */
    public void aplicarDescuentos() {
        for (Vendedor vendedor : listVendedores) {
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

//STRATEGY
    public void setEstrategiaProducto(IStrategyProducto estrategiaProducto){
        this.estrategiaProducto = estrategiaProducto;
    }
   public void ordenarProductos(List<Producto> productos){
        if(estrategiaProducto != null){
            estrategiaProducto.ordenar(productos);
        }
   }

   //STRATEGY
   public void setEstrategiaPublicacion(IStrategyPublicacion estrategiaPublicacion){
        this.estrategiaPublicacion = estrategiaPublicacion;
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

   public List<Mensaje> getMensajes(String id){
        for(Vendedor vendedor : listVendedores){
            for(Chat chat : vendedor.getMuro().getListChat()){
                if(chat.getIdChat().equals(id)){
                    return chat.getMensajes();
                }
            }
        }
        return null;
   }

   public Chat getChat(Vendedor vendedor, Vendedor contacto){
        for(Vendedor vendedor1 : listVendedores){
            if(vendedor1.getIdVendedor().equals(vendedor.getIdVendedor())){
                for(Chat chat : vendedor1.getMuro().getListChat()){
                    if(chat.getVendedor1().getIdVendedor().equals(vendedor.getIdVendedor()) && chat.getVendedor2().getIdVendedor().equals(contacto.getIdVendedor())|| chat.getVendedor1().getIdVendedor().equals(contacto.getIdVendedor())&& chat.getVendedor2().getIdVendedor().equals(vendedor.getIdVendedor())){
                            return chat;
                    }
                }
            }
        }
        return null;
   }

   public List<Producto> getListaProductos(String id){
        List<Producto> productos = new ArrayList<>();
        for(Vendedor vendedor : listVendedores){
            if(vendedor.getIdVendedor().equals(id)){
                productos = vendedor.getListProductos();
            }
        }
        return productos;
   }

   public List<Vendedor> getListContactos(String id){
        List<Vendedor> contactos = new ArrayList<>();
        for(Vendedor vendedor : listVendedores){
            if(vendedor.getIdVendedor().equals(id)){
                contactos = vendedor.getListContactos();
            }
        }
        return contactos;
   }

   public List<Comentario> getListComentarios(String id){
        List<Comentario> comentarios = new ArrayList<>();
        for(Vendedor vendedor : listVendedores){
            if(vendedor.getIdVendedor().equals(id)){
                for(Publicacion publicacion : vendedor.getMuro().getListPublicaciones()){
                    if(publicacion.getIdVendedor().equals(id)){
                        comentarios.addAll(publicacion.getListComentarios());
                    }
                }
            }
        }
        return comentarios;
   }

   public List<Comentario> getComentario(String id, LocalDateTime fecha){
        List<Comentario> comentarios = new ArrayList<>();
        for(Vendedor vendedor : listVendedores){
            if(vendedor.getIdVendedor().equals(id)){
                for(Publicacion publicacion : vendedor.getMuro().getListPublicaciones()){
                    if(publicacion.getFechaPublicacion() == fecha ){
                        comentarios = publicacion.getListComentarios();
                        break;
                    }
                }
            }
        }
        return comentarios;
   }

   public List<Vendedor> getListLike(String id, Producto producto){
        for(Vendedor vendedor : listVendedores){
            if(vendedor.getIdVendedor().equals(id)){
                for(Publicacion publicacion : vendedor.getMuro().getListPublicaciones()){
                    if(publicacion.getProducto().getImagen() == producto.getImagen()){
                        return publicacion.getListLikesVendedores();
                    }
                }
            }
        }
        return null;
   }

   public List<Publicacion> getListPublicaciones(String id){
        List<Publicacion> publicaciones = new ArrayList<>();
        for(Vendedor vendedor : listVendedores){
            if(vendedor.getIdVendedor().equals(id)){
                for(Publicacion publicacion : vendedor.getMuro().getListPublicaciones()){
                    if(publicacion.getIdVendedor().equals(id)){
                        publicaciones.add(publicacion);
                    }
                }
            }
        }
        return publicaciones;
   }

   public void darLikePublicacion(Vendedor vendedor, String id, LocalDateTime fecha){
        for(Vendedor vendedor1 : listVendedores){
            if(vendedor1.getIdVendedor().equals(id)){
                for(Publicacion publicacion : vendedor1.getMuro().getListPublicaciones()){
                    if(publicacion.getFechaPublicacion().equals(fecha)){
                        publicacion.añadirLike(vendedor);
                        break;
                    }
                }
            }
        }
   }

   public void añadirContacto(Vendedor vendedor1, Vendedor vendedor2){
        vendedor1.añadirContacto(vendedor2);
        vendedor2.añadirContacto(vendedor1);
   }

   public boolean addMessage(Mensaje mensaje, Chat chat){
        for(Vendedor vendedor : listVendedores){
            for(Chat chat1: vendedor.getMuro().getListChat()){
                if(chat1.getIdChat().equals(chat.getIdChat())){
                    chat.enviarMensaje(mensaje);
                    return true;
                }
            }
        }
        return false;
   }

   public boolean añadirComentario(Comentario comentario, Publicacion publicacion){
        for(Vendedor vendedor : listVendedores){
            if(vendedor.getIdVendedor().equals(publicacion.getIdVendedor())){
                for(Publicacion publicacion1 : vendedor.getMuro().getListPublicaciones()){
                    if(publicacion1.getFechaPublicacion().equals(publicacion.getFechaPublicacion())){
                        publicacion1.añadirComentario(comentario);
                        return true;
                    }
                }
            }
        }
        return false;
   }

   public void likeComentario(Comentario comentario, Publicacion publicacion){
        for(Vendedor vendedor : listVendedores){
            if(vendedor.getIdVendedor().equals(publicacion.getIdVendedor())){
                for(Publicacion publicacion1 : vendedor.getMuro().getListPublicaciones()){
                    if (publicacion1.getFechaPublicacion().equals(publicacion.getFechaPublicacion())) {
                        for(Comentario comentario1 : publicacion.getListComentarios()){
                            if(comentario1.getFechaComentario().equals(comentario.getFechaComentario())){
                                comentario1.setNumLikes(comentario1.getNumLikes()+1);
                            }
                        }
                    }
                }
            }
        }
   }

   public int getLikesComentarios(Comentario comentario, Publicacion publicacion){
        for(Vendedor vendedor : listVendedores){
            if(vendedor.getIdVendedor().equals(publicacion.getIdVendedor())){
                for(Publicacion publicacion1 : vendedor.getMuro().getListPublicaciones()){
                    if (publicacion1.getFechaPublicacion().equals(publicacion.getFechaPublicacion())) {
                        for(Comentario comentario1 : publicacion.getListComentarios()){
                            if(comentario1.getFechaComentario().equals(comentario.getFechaComentario())){
                                return comentario1.getNumLikes();
                            }
                        }
                    }
                }
            }
        }
        return 0;
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

    public List<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public void setPublicaciones(List<Publicacion> publicaciones) {
        this.publicaciones = publicaciones;
    }
}



