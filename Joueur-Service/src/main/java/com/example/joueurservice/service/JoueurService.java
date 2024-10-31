package com.example.joueurservice.service;

import com.example.joueurservice.EquipeFeign.EquipeFeign;
import com.example.joueurservice.entitie.Joueur;
import com.example.joueurservice.repository.JoueurRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.management.RuntimeErrorException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JoueurService {

    private JoueurRepository joueurRepository;
    private EquipeFeign equipeFeign;

    public JoueurService(JoueurRepository joueurRepository, EquipeFeign equipeFeign) {
        this.joueurRepository = joueurRepository;
        this.equipeFeign = equipeFeign;
    }

    public Joueur create_joueur(Joueur joueur){
        return joueurRepository.save(joueur);
    }

    public List<Joueur> GetAllJoueur(){
        List<Joueur> joueurs= joueurRepository.findAll();
        for (Joueur j: joueurs){
            j.setEquipe(equipeFeign.getEquipeById(j.getId_equipe()));
        }
        return joueurs;
    }


    public Joueur GetJoueurById(Long id ){
        Joueur joueur= joueurRepository.findById(id).orElse(null);
        joueur.setEquipe(equipeFeign.getEquipeById(joueur.getId_equipe()));
        return joueur;
    }

    public void deleteJoueur(Long id){
        joueurRepository.deleteById(id);
    }

    public Joueur UpdateJoueur(Joueur joueur,Long id){

        return joueurRepository.findById(id).map(joueur1 -> {
            joueur1.setNom(joueur.getNom());
            joueur1.setSaliare(joueur.getSaliare());
            joueur1.setBut(joueur.getBut());
            joueur1.setPosition(joueur.getPosition());
             return joueurRepository.save(joueur1);
                }

                ).orElseThrow(() -> new RuntimeException("joueur n'est pas trouver"));
    }


    public Joueur update_But(Long id,Long but){
        Joueur joueur =joueurRepository.getById(id);
        joueur.setBut(joueur.getBut() + but);
        joueurRepository.save(joueur);
        return joueur;

    }


public  List<Joueur> ListJoueur(){

    List<Joueur> joueurs=joueurRepository.findTrie();

    return joueurs;
}

public Joueur meilleur_Butteur(){
        Joueur joueur = joueurRepository.Meilleur_Buteur();
        return joueur;
}

}
