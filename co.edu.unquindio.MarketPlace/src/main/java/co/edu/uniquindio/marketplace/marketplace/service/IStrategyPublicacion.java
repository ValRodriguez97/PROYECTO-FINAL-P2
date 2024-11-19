package co.edu.uniquindio.marketplace.marketplace.service;

import co.edu.uniquindio.marketplace.marketplace.model.Publicacion;

import java.util.List;
//Strategy
public interface IStrategyPublicacion {

    void ordenarPublicacion(List<Publicacion> publicaciones);
}
