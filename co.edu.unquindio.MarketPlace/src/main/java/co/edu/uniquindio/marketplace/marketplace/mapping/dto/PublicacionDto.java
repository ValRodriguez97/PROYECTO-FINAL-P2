package co.edu.uniquindio.marketplace.marketplace.mapping.dto;

import co.edu.uniquindio.marketplace.marketplace.model.Producto;
import co.edu.uniquindio.marketplace.marketplace.model.Vendedor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PublicacionDto {
    private LocalDateTime fechaPublicacion;
    private String descripcion;
    private ProductoDto producto;
    private List<ComentarioDto> comentarioDtos;
    private  List<Vendedor> likesVendedores;
    private String idVendedor;

    public PublicacionDto(LocalDateTime fechaPublicacion, String descripcion, ProductoDto producto, String idVendedor) {
        this.fechaPublicacion = fechaPublicacion;
        this.descripcion = descripcion;
        this.producto = producto;
        this.comentarioDtos = new ArrayList<>();
        this. likesVendedores = new ArrayList<>();
        this.idVendedor = idVendedor;

    }

    public PublicacionDto(){}

    public LocalDateTime getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDateTime fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ProductoDto getProducto() {
        return producto;
    }

    public void setProducto(ProductoDto producto) {
        this.producto = producto;
    }

    public List<ComentarioDto> getComentarioDtos() {
        return comentarioDtos;
    }

    public void setComentarioDtos(List<ComentarioDto> comentarioDtos) {
        this.comentarioDtos = comentarioDtos;
    }

    public List<Vendedor> getLikesVendedores() {
        return likesVendedores;
    }

    public String getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(String idVendedor) {
        this.idVendedor = idVendedor;
    }

    public void setLikesVendedores(List<Vendedor> likesVendedores) {
        this.likesVendedores = likesVendedores;


    }
}
