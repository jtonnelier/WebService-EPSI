package main.java.com.application;

import main.java.com.helpers.UserConnectionHelper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Jocelyn on 15/12/2015.
 * Classe d'entrée pour les connexions Utilsateurs
 */
@Path("/connexion")
public class UserConnexion {

    //User Helper
    UserConnectionHelper userConnectionHelper;

    /**
     * Constructor
     */
    public UserConnexion() {
        this.userConnectionHelper = new UserConnectionHelper();
    }

    /**
     * Fonction de connexion pour l'utilisateur
     * @param login
     * @param password
     * @return
     */
    @POST
    @Path("/connect")
    @Produces({"application/xml", "application/json"})
    public Response connectUser(@FormParam("format") String format, @FormParam("login") String login, @FormParam("password") String password) {
        String jsonReponse = userConnectionHelper.userConnect(format, login, password);
        if(format == null || format == "" || format.equalsIgnoreCase("json") ){
            return Response.status(200).type(MediaType.APPLICATION_JSON).entity(jsonReponse).build();
        }
        else{
            return Response.status(200).type(MediaType.APPLICATION_XML).entity(jsonReponse).build();
        }
    }
}

