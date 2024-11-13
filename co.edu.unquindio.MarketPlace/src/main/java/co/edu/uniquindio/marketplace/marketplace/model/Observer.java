package co.edu.uniquindio.marketplace.marketplace.model;

public class Observer implements co.edu.uniquindio.marketplace.marketplace.service.Observer {
    private Producto producto;

    public Observer (Producto producto){
        this.producto = producto;
        this.producto.addObserver(this);
    }

    @Override
    public void updateObserver(double precio) {
    }
}
