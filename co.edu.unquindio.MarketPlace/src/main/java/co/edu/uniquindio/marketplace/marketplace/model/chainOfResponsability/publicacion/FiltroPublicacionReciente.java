package co.edu.uniquindio.marketplace.marketplace.model.chainOfResponsability.publicacion;

import co.edu.uniquindio.marketplace.marketplace.model.Publicacion;

import java.time.LocalDateTime;
import java.util.List;
//Chain Of Responsability
public class FiltroPublicacionReciente extends PublicacionFiltro {
    private LocalDateTime fechaMinima;

    public FiltroPublicacionReciente(LocalDateTime fechaMinima){
        this.fechaMinima = fechaMinima;
    }

    @Override
    protected List<Publicacion> aplicarFiltro(List<Publicacion> publicaciones){
        return publicaciones.stream().filter(p -> p.getFechaPublicacion().isAfter(fechaMinima)).toList();
    }
}
