package main.java.com.application;

import com.google.gson.Gson;
import main.java.com.helpers.UserConnectionHelper;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 * Created by Jocelyn on 15/12/2015.
 * Classe d'entrée pour les connexions Utilsateurs
 */
@Path("/")
public class UserConnexion {
    /**
     * Formater JSon
     */
    private Gson gson = new Gson();

    /**
     * Helper user
     */

    UserConnectionHelper userConnectionHelper = new UserConnectionHelper();

    /**
     * Fonction de connexion pour l'utilisateur
     *
     * @param login
     * @param password
     * @return
     */
    @POST
    @Path("/connect")
    @Produces("application/json")
    public Response connectUser(@QueryParam("login") String login, @QueryParam("password") String password) {
        String jsonReponse = userConnectionHelper.userConnect(login, password);
        return Response.status(200).entity(jsonReponse).build();
    }

    /**
     * Fonction de connexion pour l'utilisateur
     *
     * @param login
     * @param token
     * @return
     */
    @POST
    @Path("/istokenvalid")
    @Produces("application/json")
    public Response isTokenValid(@QueryParam("login") String login, @QueryParam("token") String token) {
        String jsonReponse = userConnectionHelper.checkToken(login, token);
        return Response.status(200).entity(jsonReponse).build();
    }
}

