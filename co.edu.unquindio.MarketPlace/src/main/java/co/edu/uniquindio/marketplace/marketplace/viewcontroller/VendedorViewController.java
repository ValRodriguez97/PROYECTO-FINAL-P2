package co.edu.uniquindio.marketplace.marketplace.viewcontroller;

import co.edu.uniquindio.marketplace.marketplace.controller.VendedorController;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.PublicacionDto;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

import java.util.List;

public class VendedorViewController {
    private VendedorController vendedorController;

    @FXML
    private ListView<String> listViewPublicaciones;

    @FXML
    private TextArea textAreaDetalles;

    public VendedorViewController() {
        vendedorController = new VendedorController();
    }

    /**
     * Método para mostrar las publicaciones de un vendedor y sus contactos
     * @param idVendedor
     */
    public void mostrarPublicaciones(String idVendedor) {
        List<PublicacionDto> publicaciones = vendedorController.obtenerPublicacionesConectados(idVendedor);

        listViewPublicaciones.getItems().clear();
        for (PublicacionDto publicacion : publicaciones) {
            String item = String.format("Fecha: %s - Descripción: %s",
                    publicacion.fechaPublicacion(), publicacion.descripcion());
            listViewPublicaciones.getItems().add(item);
        }
    }

    /**
     * Método que se llama cuando se selecciona una publicación en la ListView
     */
    @FXML
    public void onPublicacionSeleccionada() {
        String seleccion = listViewPublicaciones.getSelectionModel().getSelectedItem();
        if (seleccion != null) {
            textAreaDetalles.setText("Detalles de la publicación seleccionada: " + seleccion);
        }
    }

    @FXML
    void initialize() {
        listViewPublicaciones.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            onPublicacionSeleccionada();
        });
    }
}