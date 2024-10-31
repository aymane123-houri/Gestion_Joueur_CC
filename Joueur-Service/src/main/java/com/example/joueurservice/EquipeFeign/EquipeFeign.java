package com.example.joueurservice.EquipeFeign;


import com.example.joueurservice.modele.Equipe;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "EQUIPE-SERVICE")
public interface EquipeFeign {

    @GetMapping("/Equipes/{id}")
    Equipe getEquipeById(@PathVariable Long id);
}
