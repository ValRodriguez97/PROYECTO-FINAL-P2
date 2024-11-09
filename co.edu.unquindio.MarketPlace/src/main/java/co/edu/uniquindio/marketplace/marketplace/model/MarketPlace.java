package co.edu.uniquindio.marketplace.marketplace.model;

import co.edu.uniquindio.marketplace.marketplace.service.ICrudAdministrador;
import co.edu.uniquindio.marketplace.marketplace.service.ICrudPublicacion;
import co.edu.uniquindio.marketplace.marketplace.service.ICrudUsuario;
import co.edu.uniquindio.marketplace.marketplace.service.ICrudVendedor;

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
    private Usuario usuarioActual;

    public MarketPlace(String nombre) {
        this.nombre = nombre;
        this.listUsuarios = new ArrayList<Usuario>();
        this.listAdministradores = new ArrayList<Administrador>();
        this.listVendedores = new ArrayList<Vendedor>();
    }
    
    @Override
    public boolean createVendedor(Vendedor vendedor){
       if(verificarVendedorExistente(vendedor.getIdVendedor())){
           Vendedor newVendedor = Vendedor.builder()
                   .idVendedor(vendedor.getIdVendedor())
                   .nombre(vendedor.getNombre())
                   .apellido(vendedor.getApellido())
                   .cedula(vendedor.getCedula())
                   .direccion(vendedor.getDireccion())
                   .usuario(vendedor.getUsuario())
                   .contraseña(vendedor.getContraseña())
                   .build();
           return listVendedores.add(newVendedor);
       }
       return false;
    }

    @Override
    public boolean updateVendedor(String idVendedor, Vendedor vendedor){
        Vendedor vendedorExistente = verificarVendedor(idVendedor);
        if(vendedorExistente != null){
            vendedorExistente.setIdVendedor(vendedor.getIdVendedor());
            vendedorExistente.setNombre(vendedor.getNombre());
            vendedorExistente.setApellido(vendedor.getApellido());
            vendedorExistente.setDireccion(vendedor.getDireccion());
            vendedorExistente.setUsuario(vendedor.getUsuario());
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
                publicacionExistente.setFechaPublicación(publicacion.getFechaPublicacion());
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
        for (Publicacion publicacionExistente : listPublicaciones) {
            if (publicacionExistente.equals(publicacion)) {
                listPublicaciones.remove(publicacion);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean verificarPublicacionExistente(Publicacion publicacion, Vendedor vendedor) {
        return verificarPublicacion(publicacion, vendedor);
    }

    public boolean verificarPublicacion(Publicacion publicacion, Vendedor vendedor) {
        List<Publicacion> listPublicaciones = vendedor.getMuro().getListPublicaciones();
        for (Publicacion publicacion1 : listPublicaciones) {
            if (publicacion1.equals(publicacion)) {
                return true;
            }
        }
        return false;
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
        if (verificarAdministradorExiste(administrador.getIdAdministrador())) {
            // El administrador ya existe
            Administrador nuevoAdministrador = Administrador.builder()
                    .idAdministrador(administrador.getIdAdministrador())
                    .nombre(administrador.getNombre())
                    .apellido(administrador.getApellido())
                    .cedula(administrador.getCedula())
                    .direccion(administrador.getDireccion())
                    .usuario(administrador.getUsuario())
                    .contraseña(administrador.getContraseña())
                    .build();
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
            administradorExistente.setUsuario(administrador.getUsuario());
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
        return new ArrayList<>(listAdministradores); // Retornar una copia de la lista
    }

    @Override
    public Publicacion getPublicacion(Publicacion publicacion) {
        return null;
    }

    @Override
    public boolean verificarUsuarioExistente(String cedula) {
        return getUsuario(cedula) != null;
    }

    @Override
    public boolean createUsuario(Usuario usuario) {
        if (verificarUsuarioExistente(usuario.getCedula())) {
            return false;
        }

        listUsuarios.add(usuario);
        return true;
    }

    @Override
    public boolean updateUsuario (Usuario usuarioActualizado){
        Usuario usuarioExistente = getUsuario(usuarioActualizado.getCedula());

        if (usuarioExistente == null){
            usuarioExistente.setNombre(usuarioActualizado.getNombre());
            usuarioExistente.setApellido(usuarioActualizado.getApellido());
            usuarioExistente.setDireccion(usuarioActualizado.getDireccion());
            usuarioExistente.setUsuario(usuarioActualizado.getUsuario());
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
                if(usuario1.getUsuario().equals(usuario) && usuario1.getContraseña().equals(contraseña)){
                    return usuario1;
                }
            }
        }
        return null;
    }

    public boolean verificarContraseñaUsuario(String usuario, String contraseña){
        for (Usuario contraseñaValida : listUsuarios){
            if(contraseñaValida.getUsuario().equals(usuario) && contraseñaValida.getContraseña().equals(contraseña)){
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
            if (usuario.getUsuario().equals(nombreUsuario) && usuario.getContraseña().equals(contraseña)) {
                setUsuarioActual(usuario); 
                return true;
            }
        }
        return false;
    }
    
    public static void exportarEstadisticos(){

        String titulo = "Reporte de estadísticas";

        Usuario usuarioActual = marketPlace.getUsuarioActual():
        String usuario = usuarioActual != null ? usuarioActual.getNombre(): "Desconocido";

        String fecha = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/mm/yyyy"));

        StringBuilder contenido = new StringBuilder();
        List<Vendedor> vendedores = marketPlace.getListVendeores();
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

        }



