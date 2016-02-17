package main.java.com.application;

import main.java.com.helpers.GifHelper;
import main.java.com.helpers.UserHelper;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Classe principale du WS SGBD Service
 * Created by Jocelyn on 13/01/2016.
 */
@Path("/")
public class SgbdService {

    //Helper pour le microService UserHelper
    private UserHelper userHelper;
    //Helper pour le microService userGif
    private GifHelper gifHelper;

    /**
     * Constructor
     */
    public SgbdService() {
        this.userHelper = new UserHelper();
        this.gifHelper = new GifHelper();
    }

    /**
     * USERCONNEXION
     * SERVICE
     */

    /**
     * Entrée SGBD connexion utilisateur
     * @param login
     * @param password
     * @return
     */
    @POST
    @Path("/userconnect")
    @Produces("application/json")
    public Response userConnect(@FormParam("login") String login, @FormParam("password") String password){
        String jsonResponse = userHelper.connectUser(login, password);
        return Response.status(200).entity(jsonResponse).build();
    }


    /**
     * USERGIF
     * SERVICE
     */

    /**
     * Entrée recuperation des gifs d'un utilisateur
     * @param login
     * @return
     */
    @POST
    @Path("/getusergif")
    @Produces("application/json")
    public Response getGifUser(@FormParam("login") String login, @FormParam("token") String token){
        String jsonResponse = gifHelper.getUserGif(login, token);
        return Response.status(200).entity(jsonResponse).build();
    }

    /**
     * Entrée enregistrement d'un gif pour un utilisateur
     * @param login
     * @return
     */
    @POST
    @Path("/addusergif")
    @Produces("application/json")
    public Response addGifUser(@FormParam("login") String login, @FormParam("token") String token, @FormParam("label") String label,
                               @FormParam("gifURL") String gifURL ){
        String jsonResponse = gifHelper.addUserGif(login, token, label, gifURL);
        return Response.status(200).entity(jsonResponse).build();
    }
}
