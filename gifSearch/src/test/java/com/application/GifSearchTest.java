package test.java.com.application;

import main.java.com.application.GifSearch;
import main.java.com.helpers.GifSearchHelper;
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

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;

/**
 * Created by Jocelyn on 17/02/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class GifSearchTest {

    @Mock
    private GifSearchHelper gifSearchHelper;

    @InjectMocks
    private GifSearch gifSearch;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Testing json return
     */
    @Test
    public void getJSONRandomGifTest(){
        Mockito.when(this.gifSearchHelper.getRandomGif(anyString(), anyString())).thenReturn("{\"url\": 10, \"url\": 100,}");
        Response response = this.gifSearch.getRandomGif("json");
        String reponseType = response.getMediaType().getType() + "/" + response.getMediaType().getSubtype();
        assertEquals(reponseType, MediaType.APPLICATION_JSON);
    }

    /**
     * Verify if null return json
     */
    @Test
    public void getNullRandomGifTest(){
        Mockito.when(this.gifSearchHelper.getRandomGif(anyString(), anyString())).thenReturn("{\"url\": 10, \"url\": 100,}");
        Response response = this.gifSearch.getRandomGif("");
        String reponseType = response.getMediaType().getType() + "/" + response.getMediaType().getSubtype();
        assertEquals(reponseType, MediaType.APPLICATION_JSON);
    }

    /**
     * Testing xml return
     */
    @Test
    public void getXMLRandomGifTest(){
        Mockito.when(this.gifSearchHelper.getRandomGif(anyString(), anyString())).thenReturn("<user><id>1</id><login>Fake</login></user>");
        Response response = this.gifSearch.getRandomGif("xml");
        String reponseType = response.getMediaType().getType() + "/" + response.getMediaType().getSubtype();
        assertEquals(reponseType, MediaType.APPLICATION_XML);
    }

    /**
     * Testing json return
     */
    @Test
    public void getJsonGifSearch(){
        Mockito.when(this.gifSearchHelper.getGifSearch(anyString(), anyString(), anyString())).thenReturn("{\"url\": 10, \"url\": 100,}");
        Response response = this.gifSearch.getGifSearch("json", "hashtag");
        String reponseType = response.getMediaType().getType() + "/" + response.getMediaType().getSubtype();
        assertEquals(reponseType, MediaType.APPLICATION_JSON);
    }

    /**
     * Testing xml return
     */
    @Test
    public void getXmlGifSearch(){
        Mockito.when(this.gifSearchHelper.getGifSearch(anyString(), anyString(), anyString())).thenReturn("<user><id>1</id><login>Fake</login></user>");
        Response response = this.gifSearch.getGifSearch("xml", "hashtag");
        String reponseType = response.getMediaType().getType() + "/" + response.getMediaType().getSubtype();
        assertEquals(reponseType, MediaType.APPLICATION_XML);
    }
}
