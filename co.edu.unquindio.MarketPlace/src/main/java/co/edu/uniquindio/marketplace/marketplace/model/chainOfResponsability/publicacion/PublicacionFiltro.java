package co.edu.uniquindio.marketplace.marketplace.model.chainOfResponsability.publicacion;

import co.edu.uniquindio.marketplace.marketplace.model.Publicacion;

import java.util.List;
//Chain of Responsability

public abstract class PublicacionFiltro {
    private PublicacionFiltro next;

    public void setNext(PublicacionFiltro next){
        this.next = next;
    }

    public List<Publicacion>  filtrar(List<Publicacion> publicaciones ){
        List<Publicacion> publicacionesFiltradas = aplicarFiltro(publicaciones);
        if(next != null){
            return next.filtrar(publicacionesFiltradas);
        }
        return publicacionesFiltradas;
    }

    protected  abstract  List<Publicacion> aplicarFiltro (List<Publicacion> publicaciones);
}
