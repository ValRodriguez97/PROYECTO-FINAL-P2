package co.edu.uniquindio.marketplace.marketplace.model;

public class ProductoDecorator extends Producto{
    protected Producto productoDecorator;

    public ProductoDecorator(Producto producto){
        super(producto.getNombre(), producto.getImagen(), producto.getCategoria(), producto.getPrecio() , producto.getEstado());
        this.productoDecorator = producto;
    }

    @Override
    public String getNombre(){
        return productoDecorator.getNombre();
    }

    @Override
    public String getImagen(){
        return productoDecorator.getImagen();
    }

    @Override
    public String getCategoria(){
        return productoDecorator.getCategoria();
    }

    @Override
    public double getPrecio(){
        return productoDecorator.getPrecio();
    }

    @Override
    public Estado getEstado(){
        return productoDecorator.getEstado();
    }

    @Override
    public void setPrecio(double precio){
        productoDecorator.setPrecio(precio);
    }

}
