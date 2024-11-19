package co.edu.uniquindio.marketplace.marketplace.model.strategy.publicacion;

import co.edu.uniquindio.marketplace.marketplace.model.Comentario;
import co.edu.uniquindio.marketplace.marketplace.model.Publicacion;
import co.edu.uniquindio.marketplace.marketplace.service.IStrategyPublicacion;

import java.util.Comparator;
import java.util.List;
//Strategy
public class OrdenarPorFecha implements IStrategyPublicacion {

    @Override
    public void ordenarPublicacion(List<Publicacion> publicaciones){
        publicaciones.sort(Comparator.comparing(Publicacion::getFechaPublicacion).reversed());
    }
}
