package co.edu.uniquindio.marketplace.marketplace.service;

import co.edu.uniquindio.marketplace.marketplace.model.Vendedor;
//OBSERVER
public interface INotifyServiceObserver {
    void suscribeSeguidor(Vendedor vendedor, IObserver observer);
    void deleteSeguidor(Vendedor vendedor, IObserver observer);
    void notifySeguidores(Vendedor vendedor, String mensaje);
}
