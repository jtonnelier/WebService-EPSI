package main.java.com.helpers;

import com.google.gson.Gson;
import main.java.com.DAO.UserDAO.UserDAO;
import main.java.com.responses.UserConnexionResponse;

import java.sql.SQLException;

/**
 * Created by Jocelyn on 13/01/2016.
 */
public class UserHelper {

    UserDAO userDAO = new UserDAO();

    /**
     * Formater JSon
     */
    private Gson gson = new Gson();

    public UserHelper(){

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
            response.setIsConnect(this.userDAO.connexionUser(login, password));
        } catch (SQLException e) {
            response.setIsConnect(-1);
        }
        return gson.toJson(response);
    }
}
