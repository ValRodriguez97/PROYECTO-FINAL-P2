package co.edu.uniquindio.marketplace.marketplace.model.builder;

import co.edu.uniquindio.marketplace.marketplace.model.Administrador;

public class AdministradorBuilder extends UsuarioBuilder<AdministradorBuilder>{
   protected String idAdministrador;

   public AdministradorBuilder idAdministrador(String idAdministrador) {
       this.idAdministrador = idAdministrador;
       return this;
   }


   public Administrador build() {
       return new Administrador(idAdministrador, nombre, apellido, cedula, direccion, usuario, contraseña);
   }
}
