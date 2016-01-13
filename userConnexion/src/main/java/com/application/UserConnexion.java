package main.java.com.application;

import com.google.gson.Gson;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 * Created by Jocelyn on 15/12/2015.
 * Classe d'entrée pour les connexions Utilsateurs
 */
@Path("/connexion")
public class UserConnexion {
    /**
     * Formater JSon
     */
    private Gson gson = new Gson();

    /**
     * URL du WebService BDD
     */
    private String URL_SGBD;

    /**
     * Fonction de connexion pour l'utilisateur
     * @param login
     * @param password
     * @return
     */
    @POST
    @Path("/connect")
    @Produces("application/json")
    public Response connectUser(@QueryParam("login") String login, @QueryParam("password") String password ) {
        String Json = gson.toJson("Ok");
        return Response.status(200).entity(Json).build();
    }


    public Gson getGson() {
        return gson;
    }

    public String getURL_SGBD() {
        return URL_SGBD;
    }

    public void setGson(Gson gson) {
        this.gson = gson;
    }

    public void setURL_SGBD(String URL_SGBD) {
        this.URL_SGBD = URL_SGBD;
    }
}
