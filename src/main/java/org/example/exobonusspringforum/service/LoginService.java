package org.example.exobonusspringforum.service;

import jakarta.servlet.http.HttpSession;
import org.example.exobonusspringforum.entity.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {
    private List<Utilisateur> utilisateurs;
    private String LOGIN = "admin";
    private String PASSWORD = "admin123";

    // Annotation @Autowired -> car nous utilisons un service externe
    @Autowired
    private HttpSession httpSession;

    public boolean login(String username, String password){
        for(Utilisateur u : utilisateurs){
            if(u.getName().equals(username) && u.getPassword().equals(password)){
                httpSession.setAttribute("login", "OK");
                return true;
            }
        } return  false;
    }

    public boolean isLogged(){
        try {
            String userIsLogged = httpSession.getAttribute("login").toString();
            return userIsLogged.equals("OK");
        } catch (Exception e){
            return false;
        }
    }
}
