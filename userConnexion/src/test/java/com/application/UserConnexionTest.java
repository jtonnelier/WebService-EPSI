package test.java.com.application;

import main.java.com.application.UserConnexion;
import main.java.com.helpers.UserConnectionHelper;
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
 * Created by Jocelyn on 16/02/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserConnexionTest {

    @Mock
    private UserConnectionHelper mockUserConnectionHelper;

    @InjectMocks
    private UserConnexion userConnexion;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    //Test si retour json possible
    @Test
    public void testJsonUserConnexion(){
        Mockito.when(this.mockUserConnectionHelper.userConnect(anyString(), anyString(), anyString())).thenReturn("[{\"userId\": 10, \"id\": 100,}]");
        Response response = this.userConnexion.connectUser("json", "login", "password");
        String reponseType = response.getMediaType().getType() + "/" + response.getMediaType().getSubtype();
        assertEquals(reponseType, MediaType.APPLICATION_JSON);
    }

    //Test si le retour XML est OK
    @Test
    public void testXMLUserConnexion(){
        Mockito.when(this.mockUserConnectionHelper.userConnect(anyString(), anyString(), anyString())).thenReturn("<user><id>1</id><login>Fake</login></user>");
        Response response = this.userConnexion.connectUser("xml", "login", "password");
        String reponseType = response.getMediaType().getType() + "/" + response.getMediaType().getSubtype();
        assertEquals(reponseType, MediaType.APPLICATION_XML);
    }
}
