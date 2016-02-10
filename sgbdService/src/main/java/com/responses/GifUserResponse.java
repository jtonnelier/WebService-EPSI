package main.java.com.responses;

import java.util.ArrayList;

/**
 * Created by Jocelyn on 10/02/2016.
 */
public class GifUserResponse {

    private ArrayList<String> gifUser;

    private String error;

    public GifUserResponse() {
        this.gifUser = new ArrayList<String>();
    }

    public ArrayList<String> getGifUser() {
        return gifUser;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setGifUser(ArrayList<String> gifUser) {
        this.gifUser = gifUser;
    }
}
