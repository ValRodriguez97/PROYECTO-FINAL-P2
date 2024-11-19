package co.edu.uniquindio.marketplace.marketplace.viewcontroller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import co.edu.uniquindio.marketplace.marketplace.factory.ModelFactory;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.ProductoDto;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.UsuarioDto;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.VendedorDto;
import co.edu.uniquindio.marketplace.marketplace.model.Usuario;
import co.edu.uniquindio.marketplace.marketplace.model.Vendedor;
import co.edu.uniquindio.marketplace.marketplace.model.Producto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import java.lang.StringBuilder;

public class WindowPrincipalViewController{
    VendedorDto vendedorDto;
    ModelFactory modelFactory;
    Usuario usuario;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button SearchHistory;

    @FXML
    private Button btnFavorites;

    @FXML
    private MenuButton btnMenu;

    @FXML
    private Button btnProducts;

    @FXML
    private Button btnSellers;

    @FXML
    private Button btnSrttings;

    @FXML
    private Button btnWall;

    @FXML
    private Button profileUser;

    @FXML
    void onSearchFavorites(ActionEvent event) {
        VendedorDto vendedorDto = this.vendedorDto;
        Vendedor vendedor = modelFactory.getMarketPlace().getListVendedores().stream()
                .filter(v -> v.getCedula().equals(vendedorDto.cedula()))
                .findFirst()
                .orElse(null);
        if (vendedor != null) {
            List<Producto> productosFavoritos = vendedor.getProductosFavoritos();
            mostrarProductosFavoritos(productosFavoritos);
        } else {
            System.out.println("Vendedor no encontrado.");
        }
    }

    @FXML
    private ListView<String> listViewFavoritos;

    private void mostrarProductosFavoritos(List<Producto> productosFavoritos) {
        ObservableList<String> favoritosObservableList = FXCollections.observableArrayList();

        for (Producto producto : productosFavoritos) {
            favoritosObservableList.add(producto.toString()); // Muestra nombre, precio y categoría
        }

        listViewFavoritos.setItems(favoritosObservableList);
    }

    @FXML
    private ListView<String> listViewHistorial;

    @FXML
    void onSearchHistory(ActionEvent event) {
        Vendedor vendedor = modelFactory.getMarketPlace().getListVendedores().stream()
                .filter(v -> v.getCedula().equals(vendedorDto.cedula()))
                .findFirst()
                .orElse(null);

        if (vendedor != null) {
            List<Producto> historialProductos = vendedor.getHistorialConsultas();
            mostrarHistorialConsultas(historialProductos);
        } else {
            System.out.println("Vendedor no encontrado.");
        }
    }
    
    private void mostrarHistorialConsultas(List<Producto> historialProductos) {
        ObservableList<String> historialObservableList = FXCollections.observableArrayList();

        for (Producto producto : historialProductos) {
            historialObservableList.add(producto.toString());
        }
        listViewFavoritos.setItems(historialObservableList);
    }

    @FXML
    void onSearchMenu(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Opciones de búsqueda");
        alert.setHeaderText("Selecciona una opción");
        alert.setContentText("1. BuscarProductos\\n2. Buscar vendedores");

        ButtonType buscarProductosButton = new ButtonType("Buscar Productos");
        ButtonType buscarVendedoresButton = new ButtonType("Buscar Vendedores");
        ButtonType cancelarButton = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buscarProductosButton, buscarVendedoresButton, cancelarButton);

        alert.showAndWait().ifPresent(response -> {
            if (response == buscarProductosButton) {
                onSearchProducts(event);
            } else if (response == buscarVendedoresButton){
                onSearchSellers(event);
            }
        });
    }

    @FXML
    void onSearchProducts(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("BuscarProductos");
        dialog.setHeaderText("Ingresa el nombre del producto que deseas buscar:");
        dialog.setContentText("Nombre del producto:");

        dialog.showAndWait().ifPresent(nombreProducto -> {
            List<ProductoDto> productosEncontrados = modelFactory.getProductosPorNombre(nombreProducto);

            if (productosEncontrados.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Resultados de la búsqueda");
                alert.setHeaderText(null);
                alert.setContentText("No se encontraron productos con ese nombre");
                alert.showAndWait();
            } else {
                StringBuilder resultados = new StringBuilder("Productos encontrados:\n");
                for (ProductoDto producto : productosEncontrados) {
                    resultados.append(producto.getNombre()).append("\n");
                }
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Resultados de la búsqueda");
                alert.setHeaderText(null);
                alert.setContentText(resultados.toString());
                alert.showAndWait();
            }
        });
    }

    @FXML
    void onSearchSellers(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Buscar vendedores");
        dialog.setHeaderText("Ingresa el nombre del vendedor que deseas buscar:");
        dialog.setContentText("Nombre del vendedor:");

        dialog.showAndWait().ifPresent(nombreVendedor -> {
            List<VendedorDto> vendedoresEncontrados = modelFactory.getVendedoresPorNombre(nombreVendedor);

            if (vendedoresEncontrados.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Resultados de la búsqueda");
                alert.setHeaderText(null);
                alert.setContentText("No se encontraron vendedores con ese nombre");
                alert.showAndWait();
            } else {
                StringBuilder resultados = new StringBuilder("Vendedores encontrados:\n");
                for (VendedorDto vendedor : vendedoresEncontrados) {
                    resultados.append(vendedor.getNombre()).append("\n");
                }
            }
        });
    }

    @FXML
    void onSearchProfileUser(ActionEvent event) {
        if (usuario == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No se ha encontrado información del usuario");
            alert.setContentText("No se ha encontrado información del usuario. Asegúrate de haber iniciado sesión correctamente");
            alert.showAndWait();
            return;
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Perfil del usuario");
        alert.setHeaderText("Información del usuario");

        StringBuilder contenido = new StringBuilder();
        contenido.append("Nombre:").append(usuario.getNombre()).append("\n");
        contenido.append("Apellido: ").append(usuario.getApellido()).append("\n");
        contenido.append("Cédula: ").append(usuario.getCedula()).append("\n");
        contenido.append("Dirección: ").append(usuario.getDireccion()).append("\n");
        contenido.append("Username: ").append(usuario.getUsername()).append("\n");

        alert.setContentText(contenido.toString());
        alert.showAndWait();
    }

    @FXML
    void onSearchSettings(ActionEvent event) {

    }

    @FXML
    void onSearchWall(ActionEvent event) {

    }

    public void inicializarVentana(VendedorDto vendedorDto) throws IOException{
        modelFactory =  ModelFactory.getInstance();

    }
    @FXML
    void initialize() {
        assert SearchHistory != null : "fx:id=\"SearchHistory\" was not injected: check your FXML file 'MenuPrincipal.fxml'.";
        assert btnFavorites != null : "fx:id=\"btnFavorites\" was not injected: check your FXML file 'MenuPrincipal.fxml'.";
        assert btnMenu != null : "fx:id=\"btnMenu\" was not injected: check your FXML file 'MenuPrincipal.fxml'.";
        assert btnProducts != null : "fx:id=\"btnProducts\" was not injected: check your FXML file 'MenuPrincipal.fxml'.";
        assert btnSellers != null : "fx:id=\"btnSellers\" was not injected: check your FXML file 'MenuPrincipal.fxml'.";
        assert btnSrttings != null : "fx:id=\"btnSrttings\" was not injected: check your FXML file 'MenuPrincipal.fxml'.";
        assert btnWall != null : "fx:id=\"btnWall\" was not injected: check your FXML file 'MenuPrincipal.fxml'.";
        assert profileUser != null : "fx:id=\"profileUser\" was not injected: check your FXML file 'MenuPrincipal.fxml'.";

    }

}
