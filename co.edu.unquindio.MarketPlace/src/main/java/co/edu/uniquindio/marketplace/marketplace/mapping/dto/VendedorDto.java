package co.edu.uniquindio.marketplace.marketplace.mapping.dto;

public class VendedorDto extends UsuarioDto{
    private String idVendedor;

    public VendedorDto(String idVendedor, String nombre, String apellido, String cedula, String direccion, String username, String password) {
        super(nombre, apellido, cedula, direccion, username, password);
        this.idVendedor = idVendedor;
    }

    public String getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(String idVendedor) {
        this.idVendedor = idVendedor;
    }
}
