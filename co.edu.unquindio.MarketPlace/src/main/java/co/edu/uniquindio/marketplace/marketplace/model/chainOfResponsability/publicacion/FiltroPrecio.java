package co.edu.uniquindio.marketplace.marketplace.model.chainOfResponsability.publicacion;

import co.edu.uniquindio.marketplace.marketplace.model.Publicacion;
//Chain of Responsability
import java.util.List;

public class FiltroPrecio extends PublicacionFiltro {
    private double minimoPrecio;
    private double maximoPrecio;

    public FiltroPrecio(double minimoPrecio, double maximoPrecio){
        this.minimoPrecio = minimoPrecio;
        this.maximoPrecio = maximoPrecio;
    }

    @Override
    protected List<Publicacion> aplicarFiltro(List<Publicacion> publicaciones){
        return publicaciones.stream().filter(p -> p.getProducto().getPrecio() >= minimoPrecio && p.getProducto().getPrecio() <= maximoPrecio).toList();
    }
}
