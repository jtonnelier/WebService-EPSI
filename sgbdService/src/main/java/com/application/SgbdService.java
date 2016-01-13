package main.java.com.application;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 * Classe principale du WS SGBD Service
 * Created by Jocelyn on 13/01/2016.
 */
@Path("/sgbd")
public class SgbdService {

    /**
     * Verification des infos users
     * @param login
     * @param password
     * @return
     */
    @POST
    @Path("/userconnect")
    @Produces("application/json")
    public Response userConnect(@QueryParam("login") String login, @QueryParam("password") String password){

        return Response.status(200).build();
    }
}
