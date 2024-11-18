package co.edu.uniquindio.marketplace.marketplace.viewcontroller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.marketplace.marketplace.controller.LoginController;
import co.edu.uniquindio.marketplace.marketplace.controller.MenuPrincipalController;
import co.edu.uniquindio.marketplace.marketplace.factory.ModelFactory;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.UsuarioDto;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.UsuarioDtoImpl;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.VendedorDto;
import co.edu.uniquindio.marketplace.marketplace.model.Vendedor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;

public class LoginViewController {
    private ModelFactory modelFactory;
    private LoginController loginController;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCreateAccount;

    @FXML
    private Button btnForgotYourPassword;

    @FXML
    private Button btnLogin;

    @FXML
    private CheckBox btnRememberMe;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUsername;

    @FXML
    void OnPutYourUsername(ActionEvent event) {
        String username = txtUsername.getText();

        if (username.isEmpty()) {
            System.out.println("Debe ingresar un nombre");

        } else if (username.length() < 3) {
            System.out.println("El nombre de usuario debe tener 3 o más caracteres");

        }
    }

    @FXML
    void onCreateAccount(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/marketplace/marketplace/RegistroView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600,400);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Registro");
        stage.show();

        Stage cerrar = (Stage) btnCreateAccount.getScene().getWindow();
        cerrar.close();
    }

    @FXML
    void onForgotYourPassword(ActionEvent event) {

    }

    @FXML
    void onLoginBtn(ActionEvent event)  throws IOException {
        try{
            login();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void login() throws IOException {
        UsuarioDto usuarioDto = buildUsuarioDto();
        if(loginController.verificarUsuario(usuarioDto)){
            showStage2(loginController.getUsuarioDto(usuarioDto));
        }
    }

    public UsuarioDto buildUsuarioDto() {
        return new UsuarioDtoImpl(
                null,
                null,
                null,
                null,
                txtUsername.getText(),
                txtPassword.getText()
        );
    }

    public void showStage2(UsuarioDto usuarioDto) throws IOException {
      if(usuarioDto instanceof VendedorDto){
          FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/marketplace/marketplace/MenuPrincipal.fxml"));
          Scene scene = new Scene(fxmlLoader.load(), 782, 484);
          Stage stage = new Stage();

          WindowPrincipalViewController menuController = fxmlLoader.getController();
            menuController.inicializarVentana((VendedorDto)  usuarioDto);
            stage.setScene(scene);

          Stage cerrar = (Stage) btnLogin.getScene().getWindow();
          cerrar.close();

          stage.show();
      } else {
          System.out.println("Usuario no encontrado");
      }
    }
    @FXML
    void onPutPassword(ActionEvent event) {

    }

    @FXML
    void onRememberPassword(ActionEvent event) {

    }

    @FXML
    void initialize() {
        loginController = new LoginController();
    }

    public ModelFactory getModelFactory() {
        return modelFactory;
    }

    public void setModelFactory(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
    }


}
