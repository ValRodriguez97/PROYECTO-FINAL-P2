package co.edu.uniquindio.marketplace.marketplace.viewcontroller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.marketplace.marketplace.controller.LoginController;
import co.edu.uniquindio.marketplace.marketplace.controller.UsuarioController;
import co.edu.uniquindio.marketplace.marketplace.factory.ModelFactory;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.UsuarioDto;
import co.edu.uniquindio.marketplace.marketplace.mapping.dto.VendedorDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

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
    private Label lblErrorMessage;

    @FXML
    void OnPutYourUsername(ActionEvent event) {
        String username = txtUsername.getText();
        if (username.isEmpty()) {
            lblErrorMessage.setText("Debe ingresar el nombre del usuario");
        } else if (username.length() < 8){
            lblErrorMessage.setText("El nombre de usuario debe tener al menos 8 caracteres");
        } else {
            lblErrorMessage.setText("");
            btnLogin.setDisable(false);
        }
    }

    @FXML
    void onCreateAccount(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/marketplace/marketplace/createaccount.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));

        CreateAccountViewController controller = loader.getController();
        controller.initialize();

        Stage cerrar = (Stage) btnCreateAccount.getScene().getWindow();
        cerrar.close();

        stage.show();
    }

    @FXML
    void onForgotYourPassword(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Recuperación de Contraseña");
        alert.setHeaderText(null);
        alert.setContentText("Por favor, contacta al soporte técnico para recuperar tu contraseña");

        alert.showAndWait();
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
        if (loginController.verificarUsuario(usuarioDto)) {
            VendedorDto vendedorDto = (VendedorDto) loginController.getUsuarioDto(usuarioDto);
            if (vendedorDto != null) {
                showStage2(vendedorDto);
            } else {
                lblErrorMessage.setText("Usuario no encontrado");
            }
        } else {
            lblErrorMessage.setText("Usuario o contraseña incorrectos");
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

    public void showStage2(VendedorDto vendedorDto) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/marketplace/marketplace/MenuPrincipal.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 782, 484);
        Stage stage = new Stage();
    
        WindowPrincipalViewController menuController = fxmlLoader.getController();
        menuController.inicializarVentana(vendedorDto); 
        stage.setScene(scene);
    
        Stage cerrar = (Stage) btnLogin.getScene().getWindow();
        cerrar.close();
    
        stage.show();
    }

    @FXML
    void onPutPassword(ActionEvent event) {
        try {
            login();
        } catch (IOException e) {
            e.printStackTrace();
            lblErrorMessage.setText("No se pudo iniciar sesión correctamente. Inténtalo de nuevo");
        }
    }

    @FXML
    void onRememberPassword(ActionEvent event) {
        if (btnRememberMe.isSelected()) {
            String username = txtUsername.getText();
            if (!username.isEmpty()) {
                saveUsername(username);
                lblErrorMessage.setText("Nombre de usuario guardado");
            } else {
                lblErrorMessage.setText("Por favor, ingresa un nombre de usuario antes de seleccionar la opción de recordar");
            }
        } else {
            removeSavedUsername();
            lblErrorMessage.setText("Nombre de usuario eliminado");
        }
    }

    private void saveUsername(String username) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("usuario_guardado.txt"))){
            writer.write(username);
        }catch (IOException e){
            e.printStackTrace();
            lblErrorMessage.setText("Error al guardar el nombre del usuario");
        }
    }

    private void removeSavedUsername() {
        System.out.println("Eliminando el nombre de usuario guardado");
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
