package co.edu.uniquindio.marketplace.marketplace.service;

import co.edu.uniquindio.marketplace.marketplace.model.Publicacion;
import co.edu.uniquindio.marketplace.marketplace.model.Vendedor;

public interface ICrudPublicacion {
    boolean createPublicacion(Publicacion publicacion, Vendedor vendedor);
    boolean updatePublicacion(Publicacion publicacion, Vendedor vendedor);
    boolean deletePublicacion(Publicacion publicacion, Vendedor vendedor);
    Publicacion getPublicacion(Publicacion publicacion);

    boolean verificarPublicacionExistente(Publicacion publicacion, Vendedor vendedor);
}
