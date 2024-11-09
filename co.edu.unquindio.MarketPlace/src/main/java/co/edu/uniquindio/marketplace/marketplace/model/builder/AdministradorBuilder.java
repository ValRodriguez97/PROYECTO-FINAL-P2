package co.edu.uniquindio.marketplace.marketplace.model.builder;

import co.edu.uniquindio.marketplace.marketplace.model.Administrador;

public class AdministradorBuilder {
   protected String idAdministrador;
   protected String nombre;
   protected String apellido;
   protected String cedula;
   protected String direccion;
   protected String usuario;
   protected String contraseña;

   public AdministradorBuilder idAdministrador(String idAdministrador) {
       this.idAdministrador = idAdministrador;
       return this;
   }

   public AdministradorBuilder nombre(String nombre) {
       this.nombre = nombre;
       return this;
   }

   public AdministradorBuilder apellido(String apellido) {
       this.apellido = apellido;
       return this;
   }

   public AdministradorBuilder cedula(String cedula) {
       this.cedula = cedula;
       return this;
   }

   public AdministradorBuilder direccion(String direccion) {
       this.direccion = direccion;
       return this;
   }

   public AdministradorBuilder usuario(String usuario) {
       this.usuario = usuario;
       return this;
   }

   public AdministradorBuilder contraseña(String contraseña){
       this.contraseña = contraseña;
       return this;
   }

   public Administrador build() {
       return new Administrador(idAdministrador, nombre, apellido, cedula, direccion, usuario, contraseña);
   }
}
