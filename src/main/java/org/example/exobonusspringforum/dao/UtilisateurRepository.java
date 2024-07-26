package org.example.exobonusspringforum.dao;

import org.example.exobonusspringforum.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    List<Utilisateur> findByNom(String nom);
    List<Utilisateur> findByPassword(String password);
}
