package com.example.utilisateur.service;

import com.example.utilisateur.Entities.Utilisateur;
import com.example.utilisateur.Repositories.UtilisateurRepository;
import com.example.utilisateur.dto.UtilisateurDto;
import com.example.utilisateur.dto.UtilisateurInscriptionDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UtilisateurService implements IUtilisateurService{

    @Autowired
    ModelMapper modelMapper ;

    @Autowired
    UtilisateurRepository utilisateurRepository;


    @Override
    public UtilisateurDto addUtilisateur(UtilisateurInscriptionDto utilisateur) {
        Utilisateur u = modelMapper.map(utilisateur, Utilisateur.class);
        utilisateurRepository.save(u);
        return modelMapper.map(u, UtilisateurDto.class);
    }

    @Override
    public void deleteUtilisateur(Integer id) {
        utilisateurRepository.deleteById(id);
    }

    @Override
    public UtilisateurDto updateUtilisateur(UtilisateurDto utilisateurDto, Integer id) {

        Utilisateur u = utilisateurRepository.findById(id).get();
        modelMapper.map(utilisateurDto, u);
        Utilisateur u1 = utilisateurRepository.save(u);
        return modelMapper.map(u1, UtilisateurDto.class);
    }


    @Override
    public List<UtilisateurDto> getAllUtilisateurs() {
        List<UtilisateurDto> LiUtil = utilisateurRepository.findAll()
                .stream()
                .map(utilisateur -> modelMapper.map(utilisateur, UtilisateurDto.class))
                .collect(Collectors.toList());
        return LiUtil;
    }

    @Override
    public UtilisateurDto getUtilisateur(Integer id)
    {

        Utilisateur user = utilisateurRepository.findById(id).get();
        return modelMapper.map(user, UtilisateurDto.class);
    }
}
