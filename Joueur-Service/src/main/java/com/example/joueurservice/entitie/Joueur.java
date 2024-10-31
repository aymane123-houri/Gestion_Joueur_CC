package com.example.joueurservice.entitie;


import com.example.joueurservice.modele.Equipe;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Joueur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String position;

    private Long saliare;

    private Long but;

    private Long id_equipe;

    @Transient
    private Equipe equipe;

}

