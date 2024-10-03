package co.edu.uniquindio.marketplace.marketplace.model;

import java.time.LocalDateTime;

public class Mensaje {
    private String mensaje;
    private LocalDateTime fechaMensaje;

    public Mensaje(String mensaje, LocalDateTime fechaMensaje) {
        this.mensaje = mensaje;
        this.fechaMensaje = fechaMensaje;
    }


}
