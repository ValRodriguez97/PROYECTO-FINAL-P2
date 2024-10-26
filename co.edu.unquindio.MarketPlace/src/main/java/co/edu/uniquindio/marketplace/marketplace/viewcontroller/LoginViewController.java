package co.edu.uniquindio.marketplace.marketplace.viewcontroller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.marketplace.marketplace.controller.LoginController;
import co.edu.uniquindio.marketplace.marketplace.factory.ModelFactory;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.UsuarioDto;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.VendedorDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

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

    }

    @FXML
    void onCreateAccount(ActionEvent event) {

    }

    @FXML
    void onForgotYourPassword(ActionEvent event) {

    }

    @FXML
    void onLoginBtn(ActionEvent event)  throws IOException {
        login();
    }

    public void login() throws IOException {
        UsuarioDto usuarioDto = buildUsuarioDto();
        if(loginController.verificarUsuario(usuarioDto)){
            showStage2(loginController.getUsuarioDto(usuarioDto));
        }
    }

    public UsuarioDto buildUsuarioDto() {
        return new UsuarioDto(
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
            FXMLLoader fxmlLoader = new FXMLLoader(getClass());
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
