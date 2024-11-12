package com.example.utilisateur.Controller;

import com.example.utilisateur.Entities.Utilisateur;
import com.example.utilisateur.dto.UtilisateurDto;
import com.example.utilisateur.dto.UtilisateurInscriptionDto;
import com.example.utilisateur.service.IUtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @CrossOrigin(origins = "http://localhost:4200")
public class UtilisateurController {
    @Autowired
    IUtilisateurService IutilisateurService;

    @GetMapping("/utilisateurs")
    public List<UtilisateurDto> getUtilisateurs()
    {

        return IutilisateurService.getAllUtilisateurs();
    }

    @GetMapping("/utilisateur/{id}")
    public UtilisateurDto getUtilisateur(@PathVariable Integer id)
    {
        return IutilisateurService.getUtilisateur(id);
    }

    @PostMapping("/utilisateur")
    public UtilisateurDto addUtilisateur(@RequestBody UtilisateurInscriptionDto utilisateur)
    {
        return IutilisateurService.addUtilisateur(utilisateur);
    }

    @PutMapping("/utilisateur/{id}")
    public UtilisateurDto updateUtilisateur(@RequestBody UtilisateurDto utilisateur, @PathVariable Integer id)
    {
        return IutilisateurService.updateUtilisateur(utilisateur, id);
    }

    @DeleteMapping("/utilisateur/{id}")
    public void deleteUtilisateur(@PathVariable Integer id)
    {
        IutilisateurService.deleteUtilisateur(id);
    }
}
