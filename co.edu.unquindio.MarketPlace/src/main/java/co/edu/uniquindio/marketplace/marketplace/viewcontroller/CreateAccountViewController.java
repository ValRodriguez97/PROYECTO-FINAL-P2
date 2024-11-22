package co.edu.uniquindio.marketplace.marketplace.viewcontroller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.marketplace.marketplace.controller.MenuPrincipalController;
import co.edu.uniquindio.marketplace.marketplace.controller.UsuarioController;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.UsuarioDto;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.VendedorDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;

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
    void OnCreateAccount(ActionEvent event) throws IOException {
        UsuarioDto vendedorDto = buildVendedorDto();
        usuarioController.createUsuario((VendedorDto) vendedorDto);
        JOptionPane.showMessageDialog(null,"Usuario Creado Exitosamente");
        nextStage((VendedorDto) usuarioController.getUsuarioDto(vendedorDto));
    }

    public UsuarioDto buildVendedorDto(){
        return new VendedorDto(
                txtAddYourID.getText(),
                txtAddYourName.getText(),
                txtAddYourLastName.getText(),
                txtAddYourCedula.getText(),
                txtAddYourAdress.getText(),
                txtAddYourUsername.getText(),
                txtAddYourPassword.getText()
        );
    }

    public void nextStage(VendedorDto vendedorDto) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/marketplace/marketplace/MenuPrincipal.fxml"));
        Scene scene = new Scene(loader.load(), 782, 484);
        WindowPrincipalViewController controller = loader.getController();
        controller.inicializarVentana(vendedorDto);
        Stage stage = new Stage();
        stage.setScene(scene);

        Stage stageCerrar = (Stage) buttonCreateAccounnt.getScene().getWindow();
        stageCerrar.close();

        stage.show();
    }

    @FXML
    void initialize() {
        usuarioController = new UsuarioController();
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

