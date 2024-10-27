package co.edu.uniquindio.marketplace.marketplace.viewcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.marketplace.marketplace.mapping.dto.UsuarioDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;

public class WindowPrincipalViewController{
    UsuarioDto usuarioDto;

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

    }

    @FXML
    void onSearchHistory(ActionEvent event) {

    }

    @FXML
    void onSearchMenu(ActionEvent event) {

    }

    @FXML
    void onSearchProducts(ActionEvent event) {

    }

    @FXML
    void onSearchProfileUser(ActionEvent event) {

    }

    @FXML
    void onSearchSellers(ActionEvent event) {

    }

    @FXML
    void onSearchSettings(ActionEvent event) {

    }

    @FXML
    void onSearchWall(ActionEvent event) {

    }

    public void setUsuarioDto(UsuarioDto usuarioDto) {
        this.usuarioDto = usuarioDto;
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
