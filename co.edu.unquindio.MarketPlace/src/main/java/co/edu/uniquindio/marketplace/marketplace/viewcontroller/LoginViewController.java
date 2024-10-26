package co.edu.uniquindio.marketplace.marketplace.viewcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.marketplace.marketplace.controller.LoginController;
import co.edu.uniquindio.marketplace.marketplace.factory.ModelFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    void onLoginBtn(ActionEvent event) {

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
