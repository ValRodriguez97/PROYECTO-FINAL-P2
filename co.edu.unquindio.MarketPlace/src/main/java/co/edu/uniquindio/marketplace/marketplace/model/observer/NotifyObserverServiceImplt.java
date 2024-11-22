package co.edu.uniquindio.marketplace.marketplace.model.observer;

import co.edu.uniquindio.marketplace.marketplace.model.Vendedor;
import co.edu.uniquindio.marketplace.marketplace.service.INotifyServiceObserver;
import co.edu.uniquindio.marketplace.marketplace.service.IObserver;

//OBSERVER
public class NotifyObserverServiceImplt implements INotifyServiceObserver {

    @Override
    public void suscribeSeguidor(Vendedor vendedor, IObserver seguidor){
        vendedor.addSeguidor(seguidor);
    }

    @Override
    public void deleteSeguidor(Vendedor vendedor, IObserver seguidor){
        vendedor.deleteSeguidor(seguidor);
    }

    @Override
    public void notifySeguidores(Vendedor vendedor, String mensaje){
        EventoObserver eventoObserver = new EventoObserver("NOTIFICACION", mensaje, null, vendedor);
        vendedor.notifySeguidores(eventoObserver);
    }

}
