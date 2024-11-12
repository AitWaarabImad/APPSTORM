package com.example.utilisateur.service;

import com.example.utilisateur.Entities.Utilisateur;
import com.example.utilisateur.Repositories.UtilisateurRepository;
import com.example.utilisateur.dto.UtilisateurDto;
import com.example.utilisateur.dto.UtilisateurInscriptionDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class UtilisateurServiceTest {


    @InjectMocks
    private UtilisateurService utilisateurService;
    @Mock
    private UtilisateurRepository utilisateurRepository;
    @Mock
    private ModelMapper modelMapper;

    @BeforeEach
    public void setUp()
    {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void addUtilisateur()
    {
        //given
        Utilisateur utilisateur = new Utilisateur().builder().id(1).nom("nom").prenom("prenom").email("email").password("aze").build();
        UtilisateurDto utilisateurDto = new UtilisateurDto(
                1,
                "nom",
                "prenom",
                "email"
        );
        UtilisateurInscriptionDto utilisateurInscriptionDto = new UtilisateurInscriptionDto(
                "nom",
                "prenom",
                "email",
                "aze"
        );
        //when
        when(utilisateurRepository.save(utilisateur)).thenReturn(utilisateur);
        utilisateurService.addUtilisateur(utilisateurInscriptionDto);
        //then
        assertEquals(utilisateurInscriptionDto.getPassword(), utilisateur.getPassword());
        assertEquals(utilisateurDto.getNom(), utilisateur.getNom());
    }




}