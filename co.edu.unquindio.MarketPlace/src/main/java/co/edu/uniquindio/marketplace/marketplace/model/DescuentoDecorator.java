package co.edu.uniquindio.marketplace.marketplace.model;

/**
 * Creación de la clase DescuentoDecorator que hereda de la clase abstracta
 * ProductoDecorato hace parte de la implementación del patrón de diseño
 * estructural Decorator
 */
 public class DescuentoDecorator extends Producto {

    private Producto producto;
    private double porcentajeDescuento;


    public DescuentoDecorator(Producto producto, double porcentajeDescuento) {
        super(producto.getNombre(), producto.getImagen().getUrl(), producto.getCategoria(), producto.getPrecio(), producto.getEstado());
        this.producto=producto;
        this.porcentajeDescuento=porcentajeDescuento;
    }
    /**
     * Metodología de la aplicación de descuento al producto
     *
     * @return descuento aplicado
     */
    @Override
    public double getPrecio() {
        double precioOriginal = producto.getPrecio();
        return precioOriginal - (precioOriginal * (porcentajeDescuento / 100));
    }

    /**
     * Aplicación método para obtener el nombre del producto al que se va a
     * aplicar el descuento
     * @return nombre del producto y descuento aplicado al mismo
     */
    @Override
    public String getNombre() {
        return producto.getNombre() + "(Descuento del" + porcentajeDescuento + " %)";
    }
    @Override
    public String toString() {
        return String.format("%s - Precio con Descuento: %.2f - %s", producto.getNombre(), getPrecio(), producto.getCategoria());
    }
}
