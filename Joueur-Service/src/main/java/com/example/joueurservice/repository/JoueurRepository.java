package com.example.joueurservice.repository;

import com.example.joueurservice.entitie.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface JoueurRepository extends JpaRepository<Joueur,Long> {

    @Query("select j from Joueur j order by j.but desc ")
    List<Joueur> findTrie();



    @Query("select j from Joueur j order by j.but DESC limit 1 ")
    Joueur Meilleur_Buteur();


}



