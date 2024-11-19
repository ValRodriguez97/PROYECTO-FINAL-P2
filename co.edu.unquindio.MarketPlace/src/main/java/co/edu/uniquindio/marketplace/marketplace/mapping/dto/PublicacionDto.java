package co.edu.uniquindio.marketplace.marketplace.mapping.dto;

import co.edu.uniquindio.marketplace.marketplace.model.Producto;
import co.edu.uniquindio.marketplace.marketplace.model.Vendedor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PublicacionDto {
    private LocalDateTime fechaPublicacion;
    private String descripcion;
    private ProductoDto productoDto;
    private List<ComentarioDto> comentarioDtos;
    private  List<Vendedor> likesVendedores;

    public PublicacionDto(LocalDateTime fechaPublicacion, String descripcion, ProductoDto productoDto) {
        this.fechaPublicacion = fechaPublicacion;
        this.descripcion = descripcion;
        this.productoDto = productoDto;
        this.comentarioDtos = new ArrayList<>();
        this. likesVendedores = new ArrayList<>();
    }

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

    public ProductoDto getProductoDto() {
        return productoDto;
    }

    public void setProductoDto(ProductoDto productoDto) {
        this.productoDto = productoDto;
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

    public void setLikesVendedores(List<Vendedor> likesVendedores) {
        this.likesVendedores = likesVendedores;
    }
}
