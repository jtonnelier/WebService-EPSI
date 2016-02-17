package test.java.com.service;

import main.java.com.service.CommonServiceHelper;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Jocelyn on 17/02/2016.
 */
public class CommonServiceHelperTest {

    private CommonServiceHelper commonServiceHelper;

    @Before
    public void setup(){
        this.commonServiceHelper = new CommonServiceHelper();
    }

    /**
     * Test Fonction conversion JSON->XML
     */
    @Test
    public void testConvertJsonToXML(){
        String XML = commonServiceHelper.convertJsonToXML("{\"userId\": 10, \"id\": 100,}");
        XML = XML.replaceAll("(\\r|\\n)", "");
        assertEquals(XML, "<?xml version=\"1.0\" encoding=\"UTF-8\"?><o><id type=\"number\">100</id><userId type=\"number\">10</userId></o>");
    }

}
