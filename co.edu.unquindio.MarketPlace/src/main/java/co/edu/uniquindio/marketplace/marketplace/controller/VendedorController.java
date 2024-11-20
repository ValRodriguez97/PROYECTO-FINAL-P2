package co.edu.uniquindio.marketplace.marketplace.controller;

import co.edu.uniquindio.marketplace.marketplace.factory.ModelFactory;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.PublicacionDto;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.VendedorDto;
import co.edu.uniquindio.marketplace.marketplace.model.Publicacion;
import co.edu.uniquindio.marketplace.marketplace.model.Vendedor;
import co.edu.uniquindio.marketplace.marketplace.service.IVendedorController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class VendedorController implements IVendedorController {
    ModelFactory modelFactory;

    public VendedorController() {
        modelFactory = ModelFactory.getInstance();
    }

    @Override
    public List<VendedorDto> getVendedoresDto(){
        return List.of();
    }

    @Override
    public boolean addVendedor(VendedorDto vendedorDto) {
        if (vendedorDto != null &&
            vendedorDto.getIdVendedor() != null && !vendedorDto.getIdVendedor().isEmpty() &&
            vendedorDto.getNombre() != null && !vendedorDto.getNombre().isEmpty() &&
                vendedorDto.getApellido() != null && !vendedorDto.getApellido().isEmpty() &&
                vendedorDto.getDireccion() != null && !vendedorDto.getDireccion().isEmpty() &&
                vendedorDto.getUsername() != null && !vendedorDto.getUsername().isEmpty() &&
                vendedorDto.getPassword() != null && !vendedorDto.getPassword().isEmpty()) {

            Vendedor nuevoVendedor = Vendedor.Vendedorbuilder()
                    .idVendedor(vendedorDto.getIdVendedor())
                    .nombre(vendedorDto.getNombre())
                    .apellido(vendedorDto.getApellido())
                    .direccion(vendedorDto.getDireccion())
                    .username(vendedorDto.getUsername())
                    .contraseña(vendedorDto.getPassword())
                    .build();

            return modelFactory.getMarketPlace().createVendedor(nuevoVendedor);
        }

        // Retornar false si la validación falla
        return false;
    }

    @Override
    public boolean updateVendedor(VendedorDto vendedorDto){ return false;}

   /** @Override
    public boolean updateVendedor(VendedorDto vendedorDto){
        if (vendedorDto == null ||
            vendedorDto.getIdVendedor() == null || vendedorDto.getIdVendedor().isEmpty()) {
            return false;
        }
        Vendedor vendedorExistente = modelFactory.getMarketPlace().verificarVendedor(vendedorDto.getIdVendedor());
        if (vendedorExistente == null) {
            return false;
        }
        Vendedor vendedorActualizado = new Vendedor.Vendedorbuilder()
                .idVendedor(vendedorDto.getIdVendedor())
                .nombre(vendedorDto.getNombre())
                .apellido(vendedorDto.getApellido())
                .direccion(vendedorDto.getDireccion())
                .username(vendedorDto.getUsername())
                .contraseña(vendedorDto.getPassword())
                .build();

        return crudVendedor.updateVendedor(vendedorDto.getIdVendedor(), vendedorActualizado);
    } */

    @Override
    public boolean deleteVendedor(String cedula){
        return false;
    }

    /**
     * Implementación del requisito RF-007
      * @param idVendedor
     * @return
     */
    public List<PublicacionDto> obtenerPublicacionesConectados(String idVendedor) {
        Vendedor vendedor = modelFactory.getMarketPlace().verificarVendedor(idVendedor);
        List<Publicacion> todasLasPublicaciones = new ArrayList<>();
        todasLasPublicaciones.addAll(vendedor.getMuro().getListPublicaciones());

        for (Vendedor contacto : vendedor.getListContactos()) {
            todasLasPublicaciones.addAll(contacto.getMuro().getListPublicaciones());
        }

        List<Publicacion> publicacionesOrdenadas = todasLasPublicaciones.stream()
                .sorted(Comparator.comparing(Publicacion::getFechaPublicacion).reversed()) // Ordenar de más reciente a más antiguo
                .collect(Collectors.toList());

        return publicacionesOrdenadas.stream()
                .map(this::convertirAPublicacionDto)
                .collect(Collectors.toList());
    }

    private PublicacionDto convertirAPublicacionDto(Publicacion publicacion) {
        return new PublicacionDto(
                publicacion.getFechaPublicacion(),
                publicacion.getDescripcion(),
                publicacion.getProducto()
        );
    }
}

