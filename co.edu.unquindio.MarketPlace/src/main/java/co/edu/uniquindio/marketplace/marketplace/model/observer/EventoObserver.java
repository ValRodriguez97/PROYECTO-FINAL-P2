package co.edu.uniquindio.marketplace.marketplace.model.observer;

import co.edu.uniquindio.marketplace.marketplace.model.Publicacion;
import co.edu.uniquindio.marketplace.marketplace.model.Vendedor;

public class EventoObserver {
    private String tipoEvento;
    private String mensaje;
    private Publicacion publicacion;
    private Vendedor vendedor;

    public EventoObserver(String tipoEvento, String mensaje,Publicacion publicacion, Vendedor vendedor) {
        this.tipoEvento = tipoEvento;
        this.publicacion = publicacion;
        this.vendedor = vendedor;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public String getMensaje() {
        return mensaje;
    }
}
