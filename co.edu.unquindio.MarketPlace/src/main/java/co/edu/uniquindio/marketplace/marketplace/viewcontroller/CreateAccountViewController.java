package co.edu.uniquindio.marketplace.marketplace.viewcontroller;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import co.edu.uniquindio.marketplace.marketplace.controller.UsuarioController;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.VendedorDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CreateAccountViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonCreateAccounnt;

    @FXML
    private TextField txtAddYourAdress;

    @FXML
    private TextField txtAddYourCedula;

    @FXML
    private TextField txtAddYourID;

    @FXML
    private TextField txtAddYourLastName;

    @FXML
    private TextField txtAddYourName;

    @FXML
    private TextField txtAddYourPassword;

    @FXML
    private TextField txtAddYourUsername;
    UsuarioController usuarioController;

    @FXML
    void OnCreateAccount(ActionEvent event) {
        VendedorDto vendedorDto = buildVendedorDto();
        usuarioController.registrarVendedor();
    }

    public VendedorDto buildVendedorDto(){
        return new VendedorDto(
                txtAddYourID.getText(),
                txtAddYourName.getText(),
                txtAddYourLastName.getText(),
                txtAddYourCedula.getText(),
                txtAddYourAdress.getText(),
                txtAddYourUsername.getText(),
                txtAddYourPassword.getText();
        )
    }

    @FXML
    void initialize() {
        assert buttonCreateAccounnt != null : "fx:id=\"buttonCreateAccounnt\" was not injected: check your FXML file 'createaccount.fxml'.";
        assert txtAddYourAdress != null : "fx:id=\"txtAddYourAdress\" was not injected: check your FXML file 'createaccount.fxml'.";
        assert txtAddYourCedula != null : "fx:id=\"txtAddYourCedula\" was not injected: check your FXML file 'createaccount.fxml'.";
        assert txtAddYourID != null : "fx:id=\"txtAddYourID\" was not injected: check your FXML file 'createaccount.fxml'.";
        assert txtAddYourLastName != null : "fx:id=\"txtAddYourLastName\" was not injected: check your FXML file 'createaccount.fxml'.";
        assert txtAddYourName != null : "fx:id=\"txtAddYourName\" was not injected: check your FXML file 'createaccount.fxml'.";
        assert txtAddYourPassword != null : "fx:id=\"txtAddYourPassword\" was not injected: check your FXML file 'createaccount.fxml'.";
        assert txtAddYourUsername != null : "fx:id=\"txtAddYourUsername\" was not injected: check your FXML file 'createaccount.fxml'.";

    }

}
