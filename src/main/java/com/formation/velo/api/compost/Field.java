package com.formation.velo.api.compost;

// import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Field {
    private String lieu;
    private String nom;
    private String categorie;
    private String adresse;
    private String lien;
    private double[] location;
}
