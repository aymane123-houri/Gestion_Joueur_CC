package com.example.equipeservice.controller;


import com.example.equipeservice.entitie.Equipe;
import com.example.equipeservice.service.EquipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Equipes")
public class EquipeController {


    private EquipeService equipeService;

    public EquipeController(EquipeService equipeService) {
        this.equipeService = equipeService;
    }

    @PostMapping
    public ResponseEntity<Equipe> save(@RequestBody Equipe equipe){
        Equipe equipe1= equipeService.create_equipe(equipe);
        return ResponseEntity.ok(equipe1);
    }

    @GetMapping
    public ResponseEntity<List<Equipe>> GetAll(){
        List<Equipe> equipes=equipeService.GetAllEquipes();
        return ResponseEntity.ok(equipes);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Equipe> GetById(@PathVariable Long id){
        Equipe equipe = equipeService.GetEquipeById(id);
        return ResponseEntity.ok(equipe);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        equipeService.deleteEquipe(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Equipe> update(@RequestBody Equipe joueur,@PathVariable Long id){
        Equipe equipe1 = equipeService.UpdateEquipe(joueur,id);
        return ResponseEntity.ok(equipe1);
    }

}
