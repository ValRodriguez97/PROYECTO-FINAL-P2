package co.edu.uniquindio.marketplace.marketplace.controller;

import co.edu.uniquindio.marketplace.marketplace.mapping.dto.VendedorDto;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class WallController {
    private VendedorDto vendedorDto;

      @FXML
    private Label lblNombre;
   
    public void inicializarVentana(VendedorDto vendedorDto) {
        this.vendedorDto = vendedorDto;
        lblNombre.setText(vendedorDto.getNombre()); 
    }
}
