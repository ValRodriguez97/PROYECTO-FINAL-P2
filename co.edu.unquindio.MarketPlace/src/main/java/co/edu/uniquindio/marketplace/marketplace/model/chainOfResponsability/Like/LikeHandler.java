package co.edu.uniquindio.marketplace.marketplace.model.chainOfResponsability.Like;

import co.edu.uniquindio.marketplace.marketplace.model.Publicacion;
import co.edu.uniquindio.marketplace.marketplace.model.Vendedor;

//Chain of Responsability
public abstract class LikeHandler {
    private LikeHandler next;

    public void setNext(LikeHandler next) {
        this.next = next;
    }

    public void procesarLike(Publicacion publicacion, Vendedor vendedor){
        if(manejarLike(publicacion, vendedor) && next != null){
            next.procesarLike(publicacion, vendedor);
        }
    }

    protected abstract boolean manejarLike(Publicacion publicacion, Vendedor vendedor);
}
