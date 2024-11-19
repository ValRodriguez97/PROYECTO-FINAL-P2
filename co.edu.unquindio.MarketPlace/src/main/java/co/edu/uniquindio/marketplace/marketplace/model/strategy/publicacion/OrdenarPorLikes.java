package co.edu.uniquindio.marketplace.marketplace.model.strategy.publicacion;

import co.edu.uniquindio.marketplace.marketplace.model.Publicacion;
import co.edu.uniquindio.marketplace.marketplace.service.IStrategyPublicacion;

import java.util.List;

//Strategy
public class OrdenarPorLikes implements IStrategyPublicacion {

    @Override
    public void ordenarPublicacion(List<Publicacion> publicaciones){
        publicaciones.sort((publicacion1, publicqcion2) -> Integer.compare(publicqcion2.getListLikesVendedores().size(), publicacion1.getListLikesVendedores().size()));
    }
}
