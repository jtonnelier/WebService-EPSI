package test.java.com.helpers;

import main.java.com.helpers.UserHelper;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Jocelyn on 15/02/2016.
 */
public class UserHelperTest {

    private UserHelper userHelper;

    @Before
    public void setUp(){
        userHelper = new UserHelper();
    }

    //Test token existence via helper
    @Test
    public void testExistTokenUserHelper(){
        boolean valideToken = this.userHelper.isAValidToken("testu", "tokenusefortu");
        assertTrue(valideToken);
    }

    //Test token non existence via helper
    @Test
    public void testNotExistTokenUserHelper(){
        boolean valideToken = this.userHelper.isAValidToken("testu", "noeinifneozifnoezinfeirgubrigubtrilhnbtruohbo");
        assertFalse(valideToken);
    }
}
