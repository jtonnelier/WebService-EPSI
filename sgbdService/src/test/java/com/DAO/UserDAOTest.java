package test.java.com.DAO;

import main.java.com.DAO.UserDAO.UserDAO;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Created by Jocelyn on 15/02/2016.
 */
public class UserDAOTest {

    private UserDAO userDAO;

    @Before
    public void setup(){
        this.userDAO = new UserDAO();
    }
    //Test d'existence d'un user dans la base
    @Test
    public void userExist() throws Exception {
        String token = userDAO.connexionUser("testu", "testu");
        assertNotNull(token);
    }
    //Test de non existence d'un user dans la base
    @Test
    public void userDoesntExist() throws Exception {
        String token = userDAO.connexionUser("userinexistant", "userinexistant");
        assertEquals("-1", token);
    }
    //Test d'existence d'un token dans la base
    @Test
    public void userTokenExist() throws Exception {
        boolean tokenExist = userDAO.isValideToken("testu", "tokenusefortu");
        assertTrue(tokenExist);
    }
    //Test de non existence d'un token dans la base
    @Test
    public void userTokenDoesntExist() throws Exception {
        boolean tokenExist = userDAO.isValideToken("testu", "noeinifneozifnoezinfeirgubrigubtrilhnbtruohbo");
        assertFalse(tokenExist);
    }
}
