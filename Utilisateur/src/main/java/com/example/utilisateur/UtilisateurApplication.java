package com.example.utilisateur;

import com.example.utilisateur.Entities.Utilisateur;
import com.example.utilisateur.Repositories.UtilisateurRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class UtilisateurApplication {


    @Autowired
    UtilisateurRepository utilisateurRepository;
    public static void main(String[] args) {
        SpringApplication.run(UtilisateurApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            List<Utilisateur> utilisateurs = List.of(Utilisateur.builder().nom("nom1").prenom("prenom1").email("email1@gmail.com").build(),
                    Utilisateur.builder().nom("nom2").prenom("prenom2").email("email2@gmail.com").build(),
                    Utilisateur.builder().nom("nom3").prenom("prenom3").email("email3@gmail.com").build());
            utilisateurRepository.saveAll(utilisateurs);
        };
    }
}
