package co.edu.uniquindio.marketplace.marketplace.controller;

import co.edu.uniquindio.marketplace.marketplace.factory.ModelFactory;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.ComentarioDto;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.PublicacionDto;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.UsuarioDto;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.VendedorDto;
import co.edu.uniquindio.marketplace.marketplace.service.IServicePublicacion;

import java.util.List;

public class PublicacionController implements IServicePublicacion {
    ModelFactory modelFactory;

    public  PublicacionController (){
        modelFactory = ModelFactory.getInstance();
    }

    @Override
    public void darMeGusta(UsuarioDto usuario, String idVendedor, PublicacionDto dto) {
        modelFactory.darLikePublicacion(usuario, idVendedor, dto);
    }

    @Override
    public List<VendedorDto> getListaMeGustas(String id, PublicacionDto dto) {
        return modelFactory.getListLikeDto(id, dto);
    }

    @Override
    public List<ComentarioDto> getListaComentarios(String id, PublicacionDto dto) {
        return modelFactory.getListComentariosDto(id, dto);
    }

    @Override
    public boolean agregarComentario(ComentarioDto dto, PublicacionDto publicacion) {
        return modelFactory.agregarComentario(dto, publicacion);
    }

    @Override
    public void darLikeComentario(ComentarioDto dto, PublicacionDto publicacion) {
    modelFactory.darLike(dto, publicacion);
    }

    @Override
    public int getLikesComentario(ComentarioDto dto, PublicacionDto publicacion) {
      return  modelFactory.getLikes(dto, publicacion);
    }

    @Override
    public boolean agregarPublicacion(PublicacionDto publicacion, VendedorDto vendedor) {
        return modelFactory.addPublicacion(publicacion, vendedor);
    }

    @Override
    public boolean eliminarPublicacion(PublicacionDto publicacion, VendedorDto vendedor) {
        return modelFactory.deletePublicacion(publicacion, vendedor);
    }

    @Override
    public boolean actualizarPublicacion(PublicacionDto publicacion, VendedorDto vendedor) {
        return modelFactory.updatePublicacion(publicacion, vendedor);
    }
}
