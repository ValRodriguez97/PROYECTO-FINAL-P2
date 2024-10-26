package co.edu.uniquindio.marketplace.marketplace.model;

import co.edu.uniquindio.marketplace.marketplace.service.ICrudAdministrador;
import co.edu.uniquindio.marketplace.marketplace.service.ICrudPublicacion;
import co.edu.uniquindio.marketplace.marketplace.service.ICrudUsuario;
import co.edu.uniquindio.marketplace.marketplace.service.ICrudVendedor;

import java.util.ArrayList;
import java.util.List;

public class MarketPlace implements ICrudVendedor, ICrudPublicacion, ICrudUsuario, ICrudAdministrador {
    private String nombre;
    private List<Usuario> listUsuarios;
    private List<Administrador> listAdministradores;
    private List<Vendedor> listVendedores;

    public MarketPlace(String nombre) {
        this.nombre = nombre;
        this.listUsuarios = new ArrayList<Usuario>();
        this.listAdministradores = new ArrayList<Administrador>();
        this.listVendedores = new ArrayList<Vendedor>();
    }

    @Override
    public boolean createVendedor(Vendedor vendedor){
       if(verificarVendedor(vendedor.getIdVendedor())){
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
    public boolean updateVendedor( Vendedor vendedor) {
        Vendedor vendedorEXistente = verificarVendedor(vendedor.getIdVendedor());
        

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
        return verificarVendedor(idVendedor);
    }

    public boolean verificarVendedor(String idVendedor) {
        for (Vendedor vendedor : listVendedores) {
            if (vendedor.getCedula().equals(idVendedor)) {
                return true;
            }
        }
        return false;
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
                publicacionExistente.setFechaPublicación(publicacion.getFechaPublicación());
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



