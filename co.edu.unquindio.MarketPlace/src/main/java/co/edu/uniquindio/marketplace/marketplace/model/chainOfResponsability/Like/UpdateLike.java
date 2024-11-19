package co.edu.uniquindio.marketplace.marketplace.model.chainOfResponsability.Like;

import co.edu.uniquindio.marketplace.marketplace.model.Publicacion;
import co.edu.uniquindio.marketplace.marketplace.model.Vendedor;

public class UpdateLike extends LikeHandler{
//Chain of Responsability
    @Override
    protected boolean manejarLike(Publicacion publicacion, Vendedor vendedor){
        publicacion.añadirLike(vendedor);
        return true;
    }
}
