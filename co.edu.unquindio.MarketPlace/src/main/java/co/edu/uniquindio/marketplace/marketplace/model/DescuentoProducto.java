package co.edu.uniquindio.marketplace.marketplace.model;

public class DescuentoProducto extends ProductoDecorator{
    private double descuento;

    public DescuentoProducto(Producto producto, double descuento){
        super(producto);
        this.descuento = descuento;
    }

    @Override
    public double getPrecio() {
        double precioNuevo = productoDecorator.getPrecio() * (1 - descuento);
        return precioNuevo;
    }
}
