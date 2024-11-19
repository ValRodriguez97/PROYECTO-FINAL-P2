package co.edu.uniquindio.marketplace.marketplace.mapping.dto;

public class AdministradorDto extends UsuarioDto{
        private String idAdministrador;

        public AdministradorDto(String idAdministrador, String nombre, String apellido, String cedula, String direccion, String username, String password){
                super(nombre, apellido, cedula, direccion, username, password);
                this.idAdministrador = idAdministrador;
        }

        public String getIdAdministrador() {
                return idAdministrador;
        }

        public void setIdAdministrador(String idAdministrador) {
                this.idAdministrador = idAdministrador;
        }
}
