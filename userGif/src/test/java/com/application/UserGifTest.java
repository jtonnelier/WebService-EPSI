package test.java.com.application;

import main.java.com.application.UserGif;
import main.java.com.helpers.GifUserHelper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;

/**
 * Created by Jocelyn on 15/02/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserGifTest {

    @InjectMocks
    private UserGif userGif;

    @Mock
    private GifUserHelper mockHelper;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    //Test si retour json possible
    @Test
    public void testJsonGetGifUser(){
        Mockito.when(this.mockHelper.getUserGif(anyString(), anyString(), anyString())).thenReturn("[{\"userId\": 10, \"id\": 100,}]");
        Response response = this.userGif.getGifUser("json", "login", "token");
        String reponseType = response.getMediaType().getType() + "/" + response.getMediaType().getSubtype();
        assertEquals(reponseType, MediaType.APPLICATION_JSON);
    }

    //Test sans précisier le format
    @Test
    public void testNullGetGifUser(){
        Mockito.when(this.mockHelper.getUserGif(anyString(), anyString(), anyString())).thenReturn("[{\"userId\": 10, \"id\": 100,}]");
        Response response = this.userGif.getGifUser("", "login", "token");
        String reponseType = response.getMediaType().getType() + "/" + response.getMediaType().getSubtype();
        assertEquals(reponseType, MediaType.APPLICATION_JSON);
    }

    //Test si le retour JSON est OK
    @Test
    public void testJsonaddGifUser(){
        Mockito.when(this.mockHelper.addGifUser(anyString(), anyString(), anyString(), anyString(), anyString())).thenReturn("[{\"userId\": 10, \"id\": 100,}]");
        Response response = this.userGif.addGifUser("json", "login", "token", "label", "url");
        String reponseType = response.getMediaType().getType() + "/" + response.getMediaType().getSubtype();
        assertEquals(reponseType, MediaType.APPLICATION_JSON);
    }

    //Test sans précisier le format
    @Test
    public void testNulladdGifUser(){
        Mockito.when(this.mockHelper.addGifUser(anyString(), anyString(), anyString(), anyString(), anyString())).thenReturn("[{\"userId\": 10, \"id\": 100,}]");
        Response response = this.userGif.addGifUser("", "login", "token", "label", "url");
        String reponseType = response.getMediaType().getType() + "/" + response.getMediaType().getSubtype();
        assertEquals(reponseType, MediaType.APPLICATION_JSON);
    }

    //Test si retour xml possible
    @Test
    public void testXMLGetGifUser(){
        Mockito.when(this.mockHelper.getUserGif(anyString(), anyString(), anyString())).thenReturn("<user><id>1</id><login>Fake</login></user>");
        Response response = this.userGif.getGifUser("xml", "login", "token");
        String reponseType = response.getMediaType().getType() + "/" + response.getMediaType().getSubtype();
        assertEquals(reponseType, MediaType.APPLICATION_XML);
    }

    //Test si retour xml possible
    @Test
    public void testXMLaddGifUser(){
        Mockito.when(this.mockHelper.addGifUser(anyString(), anyString(), anyString(), anyString(), anyString())).thenReturn("<user><id>1</id><login>Fake</login></user>");
        Response response = this.userGif.addGifUser("xml", "login", "token", "label", "url");
        String reponseType = response.getMediaType().getType() + "/" + response.getMediaType().getSubtype();
        assertEquals(reponseType, MediaType.APPLICATION_XML);
    }
}
