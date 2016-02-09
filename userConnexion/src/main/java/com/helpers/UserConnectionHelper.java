package main.java.com.helpers;



import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import main.java.com.service.CommonServiceHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

/**
 * Created by Jocelyn on 13/01/2016.
 */
public class UserConnectionHelper {

    /** Common Helper **/
    private CommonServiceHelper commonServiceHelper = new CommonServiceHelper();

    //TODO refactorer ces fonctions en une seule
    /**
     * Fonction appellant la fonction commune d'appel a un WS
     * @param login
     * @param password
     */
    public String userConnect(String login, String password){
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("login", login);
        params.put("password", password);
        String serviceResponse = commonServiceHelper.callWS("http://localhost:8080/sgbd/userconnect", params);
        return serviceResponse;
    }

    public String checkToken(String login, String token){
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("login", login);
        params.put("token", token);
        String serviceResponse = commonServiceHelper.callWS("http://localhost:8080/sgbd/istokenvalid", params);
        return serviceResponse;
    }
}

