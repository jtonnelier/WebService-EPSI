package test.java.com.DAO;

import main.java.com.DAO.GifDAO.GifDAO;
import main.java.com.DAO.UserDAO.UserDAO;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 * Created by Jocelyn on 17/02/2016.
 */
public class GifDAOTest {

    private GifDAO gifDAO;

    @Before
    public void setup(){
        this.gifDAO = new GifDAO();
    }

    //Verify if Gif is correctly return for an user
    @Test
    public void getGifUserWithGifExist(){
        ArrayList<String> gifsList = gifDAO.getGifUser("testu");
        assertEquals(gifsList.size(), 1);
    }

    //Test with an unknow user
    @Test
    public void getGifUserWithoutGif(){
        ArrayList<String> gifsList = gifDAO.getGifUser("ozeboeziufb");
        assertEquals(gifsList.size(), 0);
    }
}
