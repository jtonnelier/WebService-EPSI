package main.java.com.helpers;

import main.java.com.service.CommonServiceHelper;

import java.util.HashMap;

/**
 * Created by Jocelyn on 10/02/2016.
 */
public class GifUserHelper {

    /** Common Helper **/
    private CommonServiceHelper commonServiceHelper = new CommonServiceHelper();

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
}
