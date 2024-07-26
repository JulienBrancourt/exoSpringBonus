package org.example.exobonusspringforum.dao;

import org.example.exobonusspringforum.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

}
