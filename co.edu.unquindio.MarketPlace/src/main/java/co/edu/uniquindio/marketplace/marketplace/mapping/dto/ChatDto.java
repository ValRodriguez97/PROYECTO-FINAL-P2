package co.edu.uniquindio.marketplace.marketplace.mapping.dto;

import co.edu.uniquindio.marketplace.marketplace.model.Chat;
import co.edu.uniquindio.marketplace.marketplace.model.Mensaje;

import java.util.ArrayList;
import java.util.List;

public class ChatDto {
private String id;
private int maxUsuarios = 2;
private VendedorDto vendedorDto1;
private VendedorDto vendedorDto2;

public ChatDto(){
}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMaxUsuarios() {
        return maxUsuarios;
    }

    public void setMaxUsuarios(int maxUsuarios) {
        this.maxUsuarios = maxUsuarios;
    }

    public VendedorDto getVendedorDto1() {
        return vendedorDto1;
    }

    public void setVendedorDto1(VendedorDto vendedorDto1) {
        this.vendedorDto1 = vendedorDto1;
    }

    public VendedorDto getVendedorDto2() {
        return vendedorDto2;
    }

    public void setVendedorDto2(VendedorDto vendedorDto2) {
        this.vendedorDto2 = vendedorDto2;
    }
}