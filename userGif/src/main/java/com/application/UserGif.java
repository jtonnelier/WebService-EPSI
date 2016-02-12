package main.java.com.application;

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
    public Response getGifUser(@QueryParam("login") String login, @QueryParam("token") String token) {
        String jsonReponse = gifUserHelper.getUserGif(login, token);
        return Response.status(200).entity(jsonReponse).build();
    }

    /**
     * Route ajoutant un gif pour un user
     * @param login
     * @param token
     * @return
     */
    @POST
    @Path("/addGif")
    @Produces("application/json")
    public Response addGifUser(@FormParam("login") String login, @FormParam("token") String token, @FormParam("label") String label,
                               @FormParam("gifURL") String gifURL ) {
        String jsonReponse = gifUserHelper.getUserGif(login, token);
        return Response.status(200).entity(jsonReponse).build();
    }
}

