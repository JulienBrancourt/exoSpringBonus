package org.example.exobonusspringforum.service;

import jakarta.servlet.http.HttpSession;
import org.example.exobonusspringforum.entity.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private HttpSession httpSession;

    public boolean login(String username, String password){
        return utilisateurService.findByName(username)
                .map(utilisateur -> {
                    if(utilisateur.getPassword().equals(password)){ // Vous devriez hacher et comparer les mots de passe
                        httpSession.setAttribute("login", "OK");
                        httpSession.setAttribute("user", utilisateur);
                        return true;
                    }
                    return false;
                })
                .orElse(false);
    }

    public boolean isLogged(){
        String userIsLogged = (String) httpSession.getAttribute("login");
        return "OK".equals(userIsLogged);
    }

    public void logout() {
        httpSession.invalidate();
    }
}