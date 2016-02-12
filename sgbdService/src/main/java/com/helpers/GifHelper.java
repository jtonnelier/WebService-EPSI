package main.java.com.helpers;

import com.google.gson.Gson;
import main.java.com.DAO.GifDAO.GifDAO;
import main.java.com.responses.GifUserResponse;

/**
 * Created by Jocelyn on 10/02/2016.
 */
public class GifHelper {

    //Gif DAO
    private GifDAO gifDAO;
    //Formater Json
    private Gson gson;
    //User Helper
    private UserHelper userHelper;

    /**
     * Constructor
     */
    public GifHelper() {
        this.gifDAO = new GifDAO();
        this.gson = new Gson();
        this.userHelper = new UserHelper();
    }

    /**
     * Appel de la DAO pour la recuperation des gifs
     * d'un utilisateur avec verification du token
     * @param login
     * @param token
     * @return
     */
    public String getUserGif(String login, String token){
        GifUserResponse response = new GifUserResponse();
        if(userHelper.isAValidToken(login, token)){
            response.setGifUser(gifDAO.getGifUser(login));
        }
        else{
            response.setError("Token Invalide");
        }
        return gson.toJson(response);
    }

    /**
     * Appel de la DAO pour la sauvegarde d'un gif
     * pour un utilisateur avec verification du token
     * @param login
     * @param token
     * @return
     */
    public String addUserGif(String login, String token, String label, String url){
        GifUserResponse response = new GifUserResponse();
        if(userHelper.isAValidToken(login, token)){
            int resultAddedGif = gifDAO.addGifUser(login, label, url);
            if(resultAddedGif != 1){
                response.setError("Error d'ajout du gif");
            }
            else{
                response.setGifAdded(resultAddedGif);
            }

        }
        else{
            response.setError("Token Invalide");
        }
        return gson.toJson(response);
    }
}
