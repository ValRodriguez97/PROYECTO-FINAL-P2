package co.edu.uniquindio.marketplace.marketplace.model.chainOfResponsability.Like;

import co.edu.uniquindio.marketplace.marketplace.model.Publicacion;
import co.edu.uniquindio.marketplace.marketplace.model.Vendedor;
//Chain of Responsability
public class LikeDuplicado extends LikeHandler{
    @Override
    protected boolean manejarLike(Publicacion publicacion, Vendedor vendedor){
        if(publicacion.getListLikesVendedores().contains(vendedor)){
            return false;
        }
        return true;
    }
}
