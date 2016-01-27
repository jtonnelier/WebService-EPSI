package main.java.com.service;

import javax.ws.rs.client.*;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response;
import java.util.Map;

/**
 * Created by Jocelyn on 27/01/2016.
 */
public class CommonServiceHelper {

    public String callWS(String url, Map<String, String> params){
        String jsonResponse = "";
        try{
            Form form = new Form();
            for(Map.Entry mapentry : params.entrySet()) {
                form.param((String) mapentry.getKey(), (String) mapentry.getValue());
            }
            Client client = ClientBuilder.newClient();
            WebTarget webTarget = client.target(url);
            Invocation.Builder builder = webTarget.request();

            Response response = builder.post(Entity.form(form));
            jsonResponse = response.readEntity(String.class);

            if (response.getStatus() != 200) {
                throw new RuntimeException("Erreur Appel WS, Code erreur : "
                        + response.getStatus());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonResponse;
    }

}
