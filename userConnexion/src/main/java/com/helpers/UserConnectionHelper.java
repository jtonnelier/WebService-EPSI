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

    /**
     * Fonction appellant la fonction commune d'appel a un WS*
     * @param format
     * @param login
     * @param password
     */
    public String userConnect(String format, String login, String password){
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("login", login);
        params.put("password", password);
        String serviceResponse = commonServiceHelper.callWS("http://localhost:8080/sgbd/userconnect", params, format);
        return serviceResponse;
    }
}

