package main.java.com.helpers;

import main.java.com.service.CommonServiceHelper;

import java.util.HashMap;

/**
 * Created by Benjamin on 14/02/2016.
 */
public class GifSearchHelper {

    /** Common Helper **/
    private CommonServiceHelper commonServiceHelper;

    public GifSearchHelper() {
        this.commonServiceHelper = new CommonServiceHelper();
    }

    /**
     * Fonction appellant l'api giphy pour r�cup�rer des gifs avec mots-cl�s
     * @param key
     * @return
     */
    public String getRandomGif(String format, String key){
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("api_key", key); // cl� necessaire pour utiliser giphy api
        String serviceResponse = commonServiceHelper.callWS("http://api.giphy.com/v1/gifs/random", params, format);
        return serviceResponse;
    }

    /**
     * Fonction appellant l'api giphy pour r�cup�rer des gifs
     * @param search
     * @param key
     * @return
     */
    public String getGifSearch(String format, String search, String key){
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("q", search); // mots cl�s de la recherche
        params.put("api_key", key); // cle necessaire pour utiliser giphy api
        String serviceResponse = commonServiceHelper.callWS("http://api.giphy.com/v1/gifs/search", params, format);
        return serviceResponse;
    }
}
