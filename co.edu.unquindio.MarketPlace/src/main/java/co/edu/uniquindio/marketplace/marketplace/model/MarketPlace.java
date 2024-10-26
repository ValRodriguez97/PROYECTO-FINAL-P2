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
    public boolean createVendedor(String nombre, String apellido, String cedula, String direccion, String usuario, String contraseña) {
        Vendedor vendedorExistente = verificarVendedor(cedula);
        if (vendedorExistente == null) {
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
    public Vendedor readVendedor(String cedula) {
        Vendedor vendedorExistente = verificarVendedor(cedula);
        if (vendedorExistente != null) {
            return vendedorExistente;
        }
        return null;
    }

    @Override
    public boolean updateVendedor(String nombre, String apellido, String cedula, String direccion, String usuario, String contraseña) {
        Vendedor vendedorExistente = verificarVendedor(cedula);
        if (vendedorExistente != null) {
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
    public boolean deleteVendedor(String cedula) {
        Vendedor vendedorExistente = verificarVendedor(cedula);
        if (vendedorExistente != null) {
            getListVendedores().remove(vendedorExistente);
            return true;
        }
        return false;
    }

    @Override
    public List<Vendedor> listVendedores() {
        return List.of();
    }

    @Override
    public boolean verificarVendedorExistente(String cedula) {
        if (verificarVendedor(cedula) == null) {
            return true;
        }
        return false;
    }

    public Vendedor verificarVendedor(String cedula) {
        Vendedor vendedorExistente = null;

        for (Vendedor vendedor : listVendedores) {
            if (vendedor.getCedula().equals(cedula)) {
                vendedorExistente = vendedor;
                break;
            }
        }
        return vendedorExistente;
    }

    @Override
    public boolean createPublicacion(Publicacion publicacion, Vendedor vendedor) {
        if (verificarPublicacion(publicacion, vendedor)) {
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
    public boolean verificarAdministradorExiste(String cedula) {
        return verificarAdministrador(cedula) != null; // Retorna true si existe, false si no
    }

    public Administrador verificarAdministrador(String cedula) {
        for (Administrador administrador : listAdministradores) {
            if (administrador.getCedula().equals(cedula)) {
                return administrador;
            }
        }
        return null;
    }

    public Administrador verificarAdministradorPorId(String idAdministrador) {
        for (Administrador administrador : listAdministradores) {
            if (administrador.getIdAdminsitrador().equals(idAdministrador)) {
                return administrador;
            }
        }
        return null;
    }

    @Override
    public boolean createAdministrador(Administrador administrador) {
        if (verificarAdministradorExiste(administrador.getIdAdminsitrador())) {
            return false; // El administrador ya existe
        }

        Administrador nuevoAdministrador = Administrador.builder()
                .idAdministrador(administrador.getIdAdminsitrador())
                .nombre(administrador.getNombre())
                .apellido(administrador.getApellido())
                .cedula(administrador.getCedula())
                .direccion(administrador.getDireccion())
                .usuario(administrador.getUsuario())
                .contraseña(administrador.getContraseña())
                .build();

        @Override
        public boolean updateAdministrador(String idAdministrador,Administrador administrador) {
            Administrador administradorExistente = verificarAdministrador(idAdministrador);
            if (administradorExistente != null) {
                administradorExistente.setIdAdminsitrador(administrador.getIdAdministrador);
                administradorExistente.setNombre(nombre);
                administradorExistente.setApellido(apellido);
                administradorExistente.setCedula(cedula);
                administradorExistente.setDireccion(direccion);
                administradorExistente.setUsuario(usuario);
                administradorExistente.setContraseña(contraseña);
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
        public List<Administrador>listAdministradores() {
            return new ArrayList<>(listAdministradores); // Retornar una copia de la lista
        }

            @Override
            public Publicacion getPublicacion (Publicacion publicacion){
                return null;
            }

            /**
             * implementación del CRUD usuario
             * @param nombre
             * @param apellido
             * @param cedula
             * @param direccion
             * @param usuario
             * @param contraseña
             * @return
             */
            @Override
            public boolean createUsuario (String nombre, String apellido, String cedula, String direccion, String
            usuario, String contraseña){
                Usuario usuarioExistente = getUsuario(cedula);
                if (usuarioExistente == null) {
                    Usuario nuevoUsuario = Usuario.builder()
                            .nombre(nombre)
                            .apellido(apellido)
                            .cedula(cedula)
                            .direccion(direccion)
                            .usuario(usuario)
                            .contraseña(contraseña)
                            .build();
                    listUsuarios.add(nuevoUsuario);
                    return true;
                }
                return false;
            }

            @Override
            public boolean updateUsuario (Usuario usuario){
                return false;
            }

            @Override
            public boolean deleteUsuario (Usuario usuario){
                return false;
            }

            @Override
            public Usuario getUsuario (String cedula){
                return null;
            }

            @Override
            public boolean verificarUsuarioExistente (String cedula){
                return false;
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
    }


