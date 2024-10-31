package com.example.equipeservice.service;

import com.example.equipeservice.entitie.Equipe;
import com.example.equipeservice.repository.EquipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipeService {

    private EquipeRepository equipeRepository;


    public EquipeService(EquipeRepository equipeRepository) {
        this.equipeRepository = equipeRepository;
    }

    public Equipe create_equipe(Equipe equipe){
        return equipeRepository.save(equipe);
    }

    public List<Equipe> GetAllEquipes(){
        return equipeRepository.findAll();
    }


    public Equipe GetEquipeById(Long id ){
        return equipeRepository.findById(id).orElse(null);

    }

    public void deleteEquipe(Long id){
        equipeRepository.deleteById(id);
    }

    public Equipe UpdateEquipe(Equipe equipe,Long id){

        return equipeRepository.findById(id).map(equipe1 -> {
                    equipe1.setCode(equipe.getCode());
                    equipe1.setLibelle(equipe.getLibelle());
                    return equipeRepository.save(equipe1);
                }

        ).orElseThrow(() -> new RuntimeException("equipe n'est pas trouver"));
    }




}
