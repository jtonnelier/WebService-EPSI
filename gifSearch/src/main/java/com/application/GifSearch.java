package main.java.com.application;

import main.java.com.helpers.GifSearchHelper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Jocelyn on 12/02/2016.
 * Classe d'entrée pour les connexions Utilsateurs
 */
@Path("/search")
public class GifSearch {
    //Gif helper
    private GifSearchHelper gifSearchHelper;
    private String apiKey;

    /**
     * Constructor
     */
    public GifSearch() {
        this.gifSearchHelper = new GifSearchHelper();
        this.apiKey = "dc6zaTOxFJmzC"; // clé publique BETA
    }

    /**
     * Route récupérant des gifs random
     * @return
     */
    @GET
    @Path("/getrandomgif")
    @Produces({"application/xml", "application/json"})
    public Response getRandomGif(@FormParam("format") String format) {
        String response = gifSearchHelper.getRandomGif(format, apiKey);
        //Check format and adapt response
        if(format.equalsIgnoreCase("json") || format == null || format == ""){
            return Response.status(200).type(MediaType.APPLICATION_JSON).entity(response).build();
        }
        else{
            return Response.status(200).type(MediaType.APPLICATION_XML).entity(response).build();
        }
    }

    /**
     * Route récupérant des gifs avec mots clés
     * @param rawSearch
     * @return
     */
    @GET
    @Path("/searchgif")
    @Produces({"application/xml", "application/json"})
    public Response getGifSearch(@FormParam("format") String format, @FormParam("search") String rawSearch) {
        // traitement de la recherche a faire
        String cleanSearch = rawSearch.trim().replaceAll(" +", "+");
        cleanSearch = cleanSearch.replaceAll("[^a-zA-Z0-9+]+", "");
        String response = gifSearchHelper.getGifSearch(format, cleanSearch, apiKey);
        //Check format and adapt response
        if(format.equalsIgnoreCase("json") || format == null){
            return Response.status(200).type(MediaType.APPLICATION_JSON).entity(response).build();
        }
        else{
            return Response.status(200).type(MediaType.APPLICATION_XML).entity(response).build();
        }
    }
}

// exemple d'appel : http://api.giphy.com/v1/gifs/search?q=funny+cat&api_key=dc6zaTOxFJmzC

// appel random : http://api.giphy.com/v1/gifs/random?api_key=dc6zaTOxFJmzC

// fmt - (optional) return results in html or json format (useful for viewing responses as GIFs to debug/test) ==> &fmt=json

// &limit=5