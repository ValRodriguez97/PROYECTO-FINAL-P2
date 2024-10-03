module co.edu.uniquindio.marketplace.marketplace {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.marketplace.marketplace to javafx.fxml;
    exports co.edu.uniquindio.marketplace.marketplace;
}