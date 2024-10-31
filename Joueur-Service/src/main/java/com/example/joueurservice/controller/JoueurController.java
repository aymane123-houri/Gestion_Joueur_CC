package com.example.joueurservice.controller;


import com.example.joueurservice.entitie.Joueur;
import com.example.joueurservice.service.JoueurService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/Joueurs")
@OpenAPIDefinition(
        info = @Info(
                title = "La Gestion des Joueurs",
                description = "offre les opération pour gérer les joueurs",
                version = "1.0.0"
        ),
        servers = @Server(
                url = "http://localhost:8083/"
        )
)
public class JoueurController {

    private JoueurService joueurService;

    public JoueurController(JoueurService joueurService) {
        this.joueurService = joueurService;
    }

    @Operation(
            summary = "Ajouter un nouvel joueur",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Joueur.class)
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Joueur ajouté avec succès",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Joueur.class))),
                    @ApiResponse(responseCode = "400", description = "Erreur lors de l'ajout de joueur")
            }
    )
    @PostMapping
    public ResponseEntity<Joueur> save(@RequestBody Joueur joueur){
        Joueur joueur1= joueurService.create_joueur(joueur);
        return ResponseEntity.ok(joueur1);
    }

    @GetMapping
    public ResponseEntity<List<Joueur>> GetAll(){
        List<Joueur> joueurs=joueurService.GetAllJoueur();
        return ResponseEntity.ok(joueurs);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Joueur> GetById(@PathVariable Long id){
        Joueur joueur = joueurService.GetJoueurById(id);
        return ResponseEntity.ok(joueur);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        joueurService.deleteJoueur(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Joueur> update(@RequestBody Joueur joueur,@PathVariable Long id){
        Joueur joueur1 = joueurService.UpdateJoueur(joueur,id);
        return ResponseEntity.ok(joueur1);
    }


    @PatchMapping("{id}/{but}")
    public ResponseEntity<Joueur> update_But(@PathVariable Long id,@PathVariable Long but){
        Joueur joueur= joueurService.update_But(id,but);
        return ResponseEntity.ok(joueur);
    }


@GetMapping("/classement")
    public  List<Joueur> ListJoueur(){
        return joueurService.ListJoueur();
    }
    @GetMapping("/Buteur")
    public Joueur Buteur(){
        return joueurService.meilleur_Butteur();
    }
}
