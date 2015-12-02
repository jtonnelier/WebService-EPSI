package main.java.com.connect;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * Created by Jocelyn on 02/12/2015.
 */
@Path("/connect")
public class Connect {

    @GET
    @Path("/helloworld")
    public Response getHelloWorld() {
        String value = "Hello World";
        return Response.status(200).entity(value).build();
    }
}
