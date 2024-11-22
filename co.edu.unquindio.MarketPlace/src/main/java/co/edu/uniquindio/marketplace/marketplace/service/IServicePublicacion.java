package co.edu.uniquindio.marketplace.marketplace.service;

import co.edu.uniquindio.marketplace.marketplace.mapping.dto.ComentarioDto;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.PublicacionDto;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.UsuarioDto;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.VendedorDto;

import java.util.List;

public interface IServicePublicacion {
    void darMeGusta(UsuarioDto usuario, String idVendedor, PublicacionDto dto);
    List<VendedorDto> getListaMeGustas(String id, PublicacionDto dto);
    List<ComentarioDto> getListaComentarios(String id, PublicacionDto dto);
    boolean agregarComentario(ComentarioDto dto, PublicacionDto publicacion);
    void darLikeComentario(ComentarioDto dto, PublicacionDto publicacion);
    int getLikesComentario(ComentarioDto dto, PublicacionDto publicacion);
    boolean agregarPublicacion(PublicacionDto publicacion, VendedorDto vendedor);
    boolean eliminarPublicacion(PublicacionDto publicacion, VendedorDto vendedor);
    boolean actualizarPublicacion(PublicacionDto publicacion, VendedorDto vendedor);
}
