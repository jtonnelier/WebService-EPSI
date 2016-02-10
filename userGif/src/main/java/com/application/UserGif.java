package main.java.com.application;

import com.google.gson.Gson;
import main.java.com.helpers.GifUserHelper;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by Jocelyn on 15/12/2015.
 * Classe Service pour la recuperation / sauvegarde de gif
 */
@Path("/")
public class UserGif {
    //Gif helper
    private GifUserHelper gifUserHelper;

    public UserGif() {
        this.gifUserHelper = new GifUserHelper();
    }

    /**
     * Route recuperant les gifs d'un user
     * @param login
     * @param token
     * @return
     */
    @GET
    @Path("/getgifuser")
    @Produces("application/json")
    public Response isTokenValid(@QueryParam("login") String login, @QueryParam("token") String token) {
        String jsonReponse = gifUserHelper.getUserGif(login, token);
        return Response.status(200).entity(jsonReponse).build();
    }
}

