package main.java.com.application;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Created by Jocelyn on 12/02/2016.
 * Classe d'entrée pour les connexions Utilsateurs
 */
@Path("/")
public class GifSearch {

    /**
     * Constructor
     */
    public GifSearch() {
    }

    /**
     * Route recuperant des gifs ramdom
     * @return
     */
    @GET
    @Path("/getrandomgif")
    @Produces({"application/xml", "application/json"})
    public Response getGifUser() {
        return Response.status(200).build();
    }
}
