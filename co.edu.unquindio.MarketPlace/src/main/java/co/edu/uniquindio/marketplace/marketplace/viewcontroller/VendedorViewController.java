package co.edu.uniquindio.marketplace.marketplace.viewcontroller;

import co.edu.uniquindio.marketplace.marketplace.mapping.dto.PublicacionDto;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.VendedorDto;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.util.List;

public class VendedorViewController {
    /**private VendedorController vendedorController;
    private VendedorDto vendedorDto;

    @FXML
    private ListView<String> listViewPublicaciones;

    @FXML
    private TextArea textAreaDetalles;

    @FXML
    private TextField txtIdVendedor;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtUsername;
    
    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtCedula;

    @FXML
    private Button btnAgregarVendedor;

    @FXML
    private Button btnActualizarVendedor;

    public VendedorViewController() {
        vendedorController = new VendedorController();
    }

    public void inicializarVentana(VendedorDto vendedorDto){
        this.vendedorDto = vendedorDto;
    }

    /**
     * Método para mostrar las publicaciones de un vendedor y sus contactos
     * @param idVendedor
     */
   /** public void mostrarPublicaciones(String idVendedor) {
        List<PublicacionDto> publicaciones = vendedorController.obtenerPublicacionesConectados(idVendedor);

        listViewPublicaciones.getItems().clear();
        for (PublicacionDto publicacion : publicaciones) {
            String item = String.format("Fecha: %s - Descripción: %s",
                    publicacion.getFechaPublicacion(), publicacion.getDescripcion());
            listViewPublicaciones.getItems().add(item);
        }
    }

    /**
     * Método que se llama cuando se selecciona una publicación en la ListView
     */
   /** @FXML
    public void onPublicacionSeleccionada() {
        String seleccion = listViewPublicaciones.getSelectionModel().getSelectedItem();
        if (seleccion != null) {
            textAreaDetalles.setText("Detalles de la publicación seleccionada: " + seleccion);
        }
    }

    private void mostrarMensaje(String mensaje) {
        // Crear un nuevo cuadro de diálogo de alerta
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null); // Sin encabezado
        alert.setContentText(mensaje); // Mensaje a mostrar

        // Mostrar el cuadro de diálogo y esperar a que el usuario lo cierre
        alert.showAndWait();
    }

    @FXML
    void initialize() {
        listViewPublicaciones.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            onPublicacionSeleccionada();
        });

        btnAgregarVendedor.setOnAction(event -> {
            String idVendedor = txtIdVendedor.getText();
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();
            String cedula = txtCedula.getText();
            String direccion = txtDireccion.getText();
            String username = txtUsername.getText();
            String password = txtPassword.getText();
            VendedorDto vendedor = new VendedorDto(idVendedor,nombre, apellido, cedula, direccion, username, password);
            vendedorController.addVendedor(vendedor);

            boolean agregado = vendedorController.addVendedor(vendedor);
            if (agregado) {
                mostrarMensaje("Vendedor agregado exitosamente.");
                limpiarCampos();
            } else {
                mostrarMensaje("Error al agregar el vendedor. Verifique los datos.");
            }
        });
        btnActualizarVendedor.setOnAction(event -> {
            String idVendedor = txtIdVendedor.getText();
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();
            String cedula = txtCedula.getText();
            String direccion = txtDireccion.getText();
            String username = txtUsername.getText();
            String password = txtPassword.getText();


            VendedorDto vendedorActualizado = new VendedorDto(idVendedor, nombre, apellido, direccion, cedula, username, password);

            boolean actualizado = vendedorController.updateVendedor(vendedorActualizado);
            if (actualizado) {
                mostrarMensaje("Vendedor actualizado exitosamente.");
            } else {
                mostrarMensaje("Error al actualizar el vendedor. Verifique los datos.");
            }
        });
    }

    private void limpiarCampos() {
        txtIdVendedor.clear();
        txtNombre.clear();
        txtApellido.clear();
        txtCedula.clear();
        txtDireccion.clear();
        txtUsername.clear();
        txtPassword.clear();
    }**/
}