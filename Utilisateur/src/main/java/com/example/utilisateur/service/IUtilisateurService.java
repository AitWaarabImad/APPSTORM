package com.example.utilisateur.service;

import com.example.utilisateur.Entities.Utilisateur;
import com.example.utilisateur.dto.UtilisateurDto;
import com.example.utilisateur.dto.UtilisateurInscriptionDto;

import java.util.List;

public interface IUtilisateurService {
    public UtilisateurDto addUtilisateur(UtilisateurInscriptionDto utilisateurInscriptionDto);
    public void deleteUtilisateur(Integer id);
    public UtilisateurDto updateUtilisateur(UtilisateurDto utilisateur, Integer id);
    public List<UtilisateurDto> getAllUtilisateurs();
    public UtilisateurDto getUtilisateur(Integer id);
}
