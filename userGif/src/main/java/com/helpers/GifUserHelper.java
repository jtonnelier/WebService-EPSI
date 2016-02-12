package main.java.com.helpers;

import main.java.com.service.CommonServiceHelper;

import java.util.HashMap;

/**
 * Created by Jocelyn on 10/02/2016.
 */
public class GifUserHelper {

    /** Common Helper **/
    private CommonServiceHelper commonServiceHelper;

    public GifUserHelper() {
        this.commonServiceHelper = new CommonServiceHelper();
    }

    /**
    * Fonction appellant le service SGBD pour récuperer les
    * gifs enregistrés de l'utilisateur
    * @param login
    * @param token
    * @return
    */
    public String getUserGif(String login, String token){
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("login", login);
        params.put("token", token);
        String serviceResponse = commonServiceHelper.callWS("http://localhost:8080/sgbd/getusergif", params);
        return serviceResponse;
    }

    /**
     * Fonction appellant le service SGBD pour enregistrer un
     * gif pour un utilisateur
     * @param login
     * @param token
     * @return
     */
    public String addGifUser(String login, String token, String label, String gifUrl){
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("login", login);
        params.put("token", token);
        params.put("label", label);
        params.put("gifURL", gifUrl);
        String serviceResponse = commonServiceHelper.callWS("http://localhost:8080/sgbd/getusergif", params);
        return serviceResponse;
    }
}
