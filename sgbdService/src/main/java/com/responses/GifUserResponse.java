package main.java.com.responses;

import java.util.ArrayList;

/**
 * Created by Jocelyn on 10/02/2016.
 */
public class GifUserResponse {

    //Liste des gifs d'un utilisateur
    private ArrayList<String> gifUser;
    //Champ d'erreur
    private String error;
    //Champ validant l'ajout en base d'un gif
    private int gifAdded;

    /**
     * Constructor
     */
    public GifUserResponse() {
        this.gifUser = new ArrayList<String>();
    }

    /**
     * GETTERS METHODS
     *
     */

    public ArrayList<String> getGifUser() {
        return gifUser;
    }

    public String getError() {
        return error;
    }

    public int getGifAdded() {
        return gifAdded;
    }

    /**
     * SETTERS METHODS
     *
     */

    public void setError(String error) {
        this.error = error;
    }

    public void setGifUser(ArrayList<String> gifUser) {
        this.gifUser = gifUser;
    }

    public void setGifAdded(int gifAdded) {
        this.gifAdded = gifAdded;
    }
}
