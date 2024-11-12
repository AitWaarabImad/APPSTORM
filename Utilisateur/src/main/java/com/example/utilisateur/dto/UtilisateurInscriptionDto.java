package com.example.utilisateur.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UtilisateurInscriptionDto {
    private String nom;
    private String prenom;
    private String email;
    private String password;
}
