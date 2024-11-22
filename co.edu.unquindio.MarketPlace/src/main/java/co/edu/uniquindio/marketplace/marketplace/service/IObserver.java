package co.edu.uniquindio.marketplace.marketplace.service;

import co.edu.uniquindio.marketplace.marketplace.model.observer.EventoObserver;

public interface IObserver {
    void update(EventoObserver evento);
}
