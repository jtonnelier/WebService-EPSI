package main.java.com.application;

import com.google.gson.Gson;
import main.java.com.helpers.UserConnectionHelper;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by Jocelyn on 15/12/2015.
 * Classe d'entrée pour les connexions Utilsateurs
 */
@Path("/")
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
    @GET
    @Path("/connect")
    @Produces("application/json")
    public Response connectUser(@QueryParam("login") String login, @QueryParam("password") String password) {
        String jsonReponse = userConnectionHelper.userConnect(login, password);
        return Response.status(200).entity(jsonReponse).build();
    }
}

