package com.formation.velo.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

@Table(name = "Composts")
public class Compost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "name is mandatory")
    private String nom;
    private String lieu;
    private String categorie;
    private String adresse;
    private String lien;

    private double lattitude;
    private double longitude;
    private double[] position;

    @NotBlank(message = "recordId is mandatory")
    private String recordId;
}
