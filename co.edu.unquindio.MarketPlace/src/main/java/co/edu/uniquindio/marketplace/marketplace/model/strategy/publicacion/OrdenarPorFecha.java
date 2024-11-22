package co.edu.uniquindio.marketplace.marketplace.model.strategy.publicacion;

import co.edu.uniquindio.marketplace.marketplace.model.Comentario;
import co.edu.uniquindio.marketplace.marketplace.model.Publicacion;
import co.edu.uniquindio.marketplace.marketplace.service.IStrategyPublicacion;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
//Strategy
public class OrdenarPorFecha implements IStrategyPublicacion {

    @Override
   public void ordenarPublicacion(List<Publicacion> publicaciones){
        for(Publicacion publicacion : publicaciones){
            Collections.sort(publicaciones, (p1, p2) -> p1.getFechaPublicacion().compareTo(p2.getFechaPublicacion()));

        }
    }
}
