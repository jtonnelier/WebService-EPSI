package main.java.com.application;

import main.java.com.helpers.GifUserHelper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
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
    @Produces({"application/xml", "application/json"})
    public Response getGifUser(@QueryParam("format") String format, @QueryParam("login") String login, @QueryParam("token") String token) {
        String response = gifUserHelper.getUserGif(format, login, token);
        //Check format and adapt response
        if(format == null || format == "" || format.equalsIgnoreCase("json") ){
            return Response.status(200).type(MediaType.APPLICATION_JSON).entity(response).build();
        }
        else{
            return Response.status(200).type(MediaType.APPLICATION_XML).entity(response).build();
        }
    }

    /**
     * Route ajoutant un gif pour un user
     * @param login
     * @param token
     * @return
     */
    @POST
    @Path("/addGif")
    @Produces({"application/xml", "application/json"})
    public Response addGifUser(@FormParam("format") String format, @FormParam("login") String login, @FormParam("token") String token, @FormParam("label") String label,
                               @FormParam("gifURL") String gifURL ) {
        String response = gifUserHelper.addGifUser(format, login, token, label, gifURL);
        //Check format and adapt response
        if(format == null || format == "" | format.equalsIgnoreCase("json") ){
            return Response.status(200).type(MediaType.APPLICATION_JSON).entity(response).build();
        }
        else{
            return Response.status(200).type(MediaType.APPLICATION_XML).entity(response).build();
        }
    }
}

