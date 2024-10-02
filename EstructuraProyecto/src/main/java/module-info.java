module co.edu.uniquindio.estructuraproyecto.estructuaproyecto {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.estructuraproyecto.estructuaproyecto to javafx.fxml;
    exports co.edu.uniquindio.estructuraproyecto.estructuaproyecto;
}