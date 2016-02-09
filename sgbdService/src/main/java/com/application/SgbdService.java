package main.java.com.application;

import main.java.com.helpers.UserHelper;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Classe principale du WS SGBD Service
 * Created by Jocelyn on 13/01/2016.
 */
@Path("/")
public class SgbdService {

    private UserHelper userHelper = new UserHelper();

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
     * Entrée verification token SGBD
     * @param login
     * @param token
     * @return
     */
    @POST
    @Path("/istokenvalid")
    @Produces("application/json")
    public Response isTokenValid(@FormParam("login") String login, @FormParam("token") String token){
        String jsonResponse = userHelper.isAValidToken(login, token);
        return Response.status(200).entity(jsonResponse).build();
    }
}
