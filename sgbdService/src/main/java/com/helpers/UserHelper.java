package main.java.com.helpers;

import com.google.gson.Gson;
import main.java.com.DAO.UserDAO.UserDAO;
import main.java.com.responses.UserConnexionResponse;

import java.sql.SQLException;

/**
 * Created by Jocelyn on 13/01/2016.
 */
public class UserHelper {

    //User DAO
    private UserDAO userDAO;

    //Formatter JSON
    private Gson gson;

    public UserHelper(){
        this.userDAO = new UserDAO();
        this.gson = new Gson();
    }

    /**
     * Fonction appellant la DAO pour vérifier la connexion d'un utilisateur
     * @param login
     * @param password
     * @return
     */
    public String connectUser(String login, String password){
        UserConnexionResponse response = new UserConnexionResponse();
        try {
            String tokenUser = this.userDAO.connexionUser(login, password);
            if(tokenUser != null){
                response.setIsConnect(1);
                response.setToken(tokenUser);
            }
            else{
                response.setIsConnect(-1);
            }
        } catch (SQLException e) {
            response.setIsConnect(-1);
        }
        return gson.toJson(response);
    }

    /**
     * Fonction appellant la DAO pour vérifier le token d'un utilisateur
     * @param login
     * @param password
     * @return
     */
    public Boolean isAValidToken(String login, String password){
        UserConnexionResponse response = new UserConnexionResponse();
        return this.userDAO.isValideToken(login, password);
    }
}
