package co.edu.uniquindio.marketplace.marketplace.model.observer;

import co.edu.uniquindio.marketplace.marketplace.model.Publicacion;
import co.edu.uniquindio.marketplace.marketplace.model.Vendedor;

public class EventoObserver {
   private String tipoEvento;
   private String mensaje;
   private Publicacion publicacion;
   private Vendedor vendedor;

   public EventoObserver(String tipoEvento, String mensaje, Publicacion publicacion, Vendedor vendedor){
       this.tipoEvento = tipoEvento;
       this.mensaje = mensaje;
       this.publicacion = publicacion;
       this.vendedor = vendedor;
   }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
}
