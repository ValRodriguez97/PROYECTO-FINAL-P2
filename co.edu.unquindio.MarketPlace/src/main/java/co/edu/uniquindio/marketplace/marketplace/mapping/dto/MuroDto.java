package co.edu.uniquindio.marketplace.marketplace.mapping.dto;

import co.edu.uniquindio.marketplace.marketplace.model.Chat;
import co.edu.uniquindio.marketplace.marketplace.model.Publicacion;

import java.util.ArrayList;
import java.util.List;

public class MuroDto {
    private String id;

    public  MuroDto(String id){
        this.id = id;
    }

    public MuroDto(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}