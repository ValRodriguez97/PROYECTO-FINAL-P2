package co.edu.uniquindio.marketplace.marketplace;

import co.edu.uniquindio.marketplace.marketplace.controller.LoginController;
import co.edu.uniquindio.marketplace.marketplace.factory.ModelFactory;
import co.edu.uniquindio.marketplace.marketplace.viewcontroller.LoginViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MarketPlaceApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException{
        ModelFactory modelFactory = ModelFactory.getInstance();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/marketplace/marketplace/Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 782, 474);
        LoginViewController loginViewController = fxmlLoader.getController();
        loginViewController.setModelFactory(modelFactory);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
