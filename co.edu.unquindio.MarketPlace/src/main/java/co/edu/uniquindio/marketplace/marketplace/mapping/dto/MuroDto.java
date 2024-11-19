package co.edu.uniquindio.marketplace.marketplace.mapping.dto;

import java.util.ArrayList;
import java.util.List;

public class MuroDto {
    private String idVendedor;
    private List<PublicacionDto> listPublicaciones;
    private List<ChatDto> listChats;

    public MuroDto(String idVendedor) {
        this.idVendedor = idVendedor;
        this.listPublicaciones = new ArrayList<>();
        this.listChats = new ArrayList<>();
    }

    public String getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(String idVendedor) {
        this.idVendedor = idVendedor;
    }

    public List<PublicacionDto> getListPublicaciones() {
        return listPublicaciones;
    }

    public void setListPublicaciones(List<PublicacionDto> listPublicaciones) {
        this.listPublicaciones = listPublicaciones;
    }

    public List<ChatDto> getListChats() {
        return listChats;
    }

    public void setListChats(List<ChatDto> listChats) {
        this.listChats = listChats;
    }
}