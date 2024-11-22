package co.edu.uniquindio.marketplace.marketplace.service;

import co.edu.uniquindio.marketplace.marketplace.model.Publicacion;
import co.edu.uniquindio.marketplace.marketplace.model.Vendedor;

public interface ICrudPublicacion {
    boolean createPublicacion(Publicacion publicacion, String vendedor);
    boolean updatePublicacion(Publicacion publicacion, String vendedor);
    boolean deletePublicacion(Publicacion publicacion, String vendedor);
    Publicacion getPublicacion(Publicacion publicacion);

    boolean verificarPublicacionExistente(Publicacion publicacior);
}
